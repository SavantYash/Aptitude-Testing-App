package com.example.aptitude1.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    onStartQuiz: () -> Unit,
    examFailed: Boolean
) {
    if (examFailed) {
        AlertDialog(
            onDismissRequest = {},
            confirmButton = {
                Button(onClick = {}) {
                    Text("OK")
                }
            },
            title = { Text("Exam Failed") },
            text = { Text("You left the app during the exam. Your attempt is marked as failed.") }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding() // leaves space for network & notification bar
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

        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Welcome!",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Ready to test your aptitude skills?",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        // Start Quiz Button
        Button(
            onClick = onStartQuiz,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Start Quiz", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.weight(1f)) // Push footer to bottom

        // Footer
        Text(
            text = "© 2025 MyApp",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(bottom = 10.dp)
        )
    }
}
