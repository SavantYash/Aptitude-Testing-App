package com.example.aptitude1.ui.theme.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavHostController
import com.example.aptitude1.model.QuetionModel
import com.example.aptitude1.viewmodel.QuestionViewModel
import kotlinx.coroutines.delay

@Composable
fun QuizHome(navController: NavHostController, viewModel: QuestionViewModel) {

    val questionlist = viewModel.questionList.collectAsState()

    val index = remember { mutableIntStateOf(0) }
    val result = remember { mutableIntStateOf(0) }
    val totalTime = remember { mutableStateOf(30 * 60) }
    val showExitDialog = remember { mutableStateOf(false) }
    val navigateHome = remember { mutableStateOf(false) }
    val navigatingInternally = remember { mutableStateOf(false) }

    val lifecycleOwner = androidx.lifecycle.compose.LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_STOP && !navigatingInternally.value) {
                showExitDialog.value = true
                navigateHome.value = true
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }

    LaunchedEffect(Unit) {
        while (totalTime.value > 0) {
            delay(1000L)
            totalTime.value--
        }
    }

    LaunchedEffect(navigateHome.value) {
        if (navigateHome.value) {
            navController.navigate("HomeScreen") {
                popUpTo("QuizHome") { inclusive = true }
            }
            navigateHome.value = false
        }
    }

    if (showExitDialog.value) {
        AlertDialog(
            onDismissRequest = { showExitDialog.value = false },
            title = { Text("Test Failed") },
            text = { Text("You left the app. Your exam has failed.") },
            confirmButton = {
                Button(onClick = {
                    showExitDialog.value = false
                    navigateHome.value = true
                }) { Text("OK") }
            }
        )
    }

    BackHandler { showExitDialog.value = true }

    if (questionlist.value.isEmpty()) {
        Text("Loading...")
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5)) // light background for contrast
        ) {
            // Header
            Text(
                text = "Aptitude Test",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp, bottom = 8.dp),
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                color = Color.Black
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        navController.navigate("Result?result=${0}")
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    modifier = Modifier.wrapContentWidth()
                ) {
                    Text(
                        "Leave",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White
                    )
                }

                Text(
                    text = "Time Left: ${formatTime(totalTime.value)}",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Red
                )
            }


            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .weight(1f),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                QuizCard(
                    model = questionlist.value[index.value],
                    navController,
                    index = index,
                    result = result,
                    navigatingInternally,
                    size = questionlist.value.size
                )
            }
        }
    }
}

@Composable
fun QuizCard(
    model: QuetionModel,
    navController: NavHostController,
    index: MutableState<Int>,
    result: MutableState<Int>,
    navigatingInternally : MutableState<Boolean>,
    size: Int
) {
    val selectedOption = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            model.Question,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        model.Options.forEach { option ->
            Button(
                onClick = { selectedOption.value = option },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedOption.value == option) Color.DarkGray else Color.LightGray
                )
            ) {
                Text(option, modifier = Modifier.padding(5.dp))
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                if (selectedOption.value.isNotEmpty()) {
                    if (selectedOption.value == model.Answer) {
                        result.value++
                    }
                    if (index.value < size - 1) {
                        index.value++
                    } else {
                        navigatingInternally.value = true
                        navController.navigate("Result?result=${result.value}")
                    }
                    selectedOption.value = ""
                }
            },
            modifier = Modifier.align(Alignment.End),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
        ) {
            Text("Submit")
        }
    }
}

fun formatTime(seconds: Int): String {
    val minutes = seconds / 60
    val sec = seconds % 60
    return String.format("%02d:%02d", minutes, sec)
}
