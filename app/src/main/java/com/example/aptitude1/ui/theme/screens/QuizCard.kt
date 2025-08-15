package com.example.aptitude1.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.aptitude1.model.QuetionModel
import com.example.aptitude1.viewmodel.QuestionViewModel

@Composable
fun QuizHome(viewModel: QuestionViewModel){

    val questionlist = viewModel.questionList.collectAsState()

    val index : MutableState<Int> = remember { mutableStateOf(0) }
    val result : MutableState<Int> = remember { mutableStateOf(0) }

    if(questionlist.value.isEmpty()){
        Text("Loading...")
    }else {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "Aptitude Test",
                modifier = Modifier.padding(10.dp)
                    .fillMaxWidth(1f),
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                "TIME",
                modifier = Modifier.width(10.dp).align(Alignment.End)
            )

            QuizCard(questionlist.value.get(index.value), index, result = result)
        }
    }
}

@Composable
fun QuizCard(
    model : QuetionModel,
    index : MutableState<Int>,
    result : MutableState<Int>
){
    var select = ""
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(model.Question, modifier = Modifier.padding(5.dp).fillMaxWidth())
        model.Options.forEach {
            Button(
                onClick = {
                    select = it
                },
                modifier = Modifier.fillMaxWidth(0.9f).padding(5.dp)
            ) { Text(it, modifier = Modifier.padding(5.dp)) }
        }
        Button(
            onClick = {
                if(select.isEmpty())
                {
                    if(select.equals(model.Answer))
                    {
                        result.value++
                        index.value++
                    }
                }
            },
            modifier = Modifier.width(IntrinsicSize.Max)
                .padding(5.dp)
                .align(Alignment.End)
                .background(color = Color.Gray)
        ) {
            Text("Submit")
        }
    }
}