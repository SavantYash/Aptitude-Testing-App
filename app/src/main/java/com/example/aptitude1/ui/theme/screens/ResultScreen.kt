package com.example.aptitude1.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.aptitude1.viewmodel.QuestionViewModel

@Composable
fun ResultScreen(result: Int?,navController: NavHostController,viewModel: QuestionViewModel){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Aptitude Test",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 24.dp)
                .fillMaxWidth(),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        Spacer(modifier = Modifier.fillMaxWidth().padding(10.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ){
           Text(
               "Result",
               modifier = Modifier.fillMaxWidth()
                   .align(Alignment.CenterHorizontally)
                   .padding(5.dp)
           )
            Text("Your result is : ${result} out of 25",modifier = Modifier.fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(5.dp))

            if (result != null) {
                if(result == 25 || result > 20) {
                    Text("Keep it up!",modifier = Modifier.fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .padding(5.dp))
                }else if(result > 15){
                    Text("Good! Just few more.",modifier = Modifier.fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .padding(5.dp))
                }else if(result > 10){
                    Text("Nice going!",modifier = Modifier.fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .padding(5.dp))
                }else{
                    Text("Work hard!",modifier = Modifier.fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .padding(5.dp))
                }
            }
            Button(
                onClick = {
                    navController.navigate("HomeScreen")
                    viewModel.emptyQuestionList()
                }
            ) {
                Text("Home")
            }
        }
    }
}