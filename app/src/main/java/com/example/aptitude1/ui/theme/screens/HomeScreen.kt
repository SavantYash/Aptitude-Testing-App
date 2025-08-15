package com.example.aptitude1.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

@Composable
fun HomeScreen(
    onStartQuiz : () -> Unit
){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    )
    {
        Text(
            text = "Aptitude Test",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(10.dp)
        )
        Column {
            Text("Welcome! Ready to test your skills?")
            Button(
                onClick = onStartQuiz,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Start Quiz")
            }
        }
    }
    Text(
        text = "© 2025 MyApp",
        style = MaterialTheme.typography.labelSmall
    )
}