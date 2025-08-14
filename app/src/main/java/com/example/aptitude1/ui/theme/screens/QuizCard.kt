package com.example.aptitude1.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aptitude1.model.QuetionModel

@Composable
fun QuizHome(){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
       Text("Aptitude Test",
           modifier = Modifier.padding(10.dp)
               .fillMaxWidth(1f),
           style = MaterialTheme.typography.headlineSmall)

        Text("TIME",
            modifier = Modifier.width(10.dp).align(Alignment.End)
            )

    }
}

@Composable
fun QuizCard(
    model : QuetionModel,
    onSubmit : () -> Unit
){
    val select : String
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(model.Question, modifier = Modifier.padding(5.dp).fillMaxWidth())
        model.Options.forEach {
            Button(onClick = {}) { Text(it, modifier = Modifier.padding(5.dp)) }
        }
    }
}