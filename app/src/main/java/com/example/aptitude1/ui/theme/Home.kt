package com.example.aptitude1.ui.theme

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aptitude1.ui.theme.screens.HomeScreen
import com.example.aptitude1.ui.theme.screens.QuizHome
import com.example.aptitude1.viewmodel.QuestionViewModel

@Composable
fun Home(
    navController : NavHostController,
    viewModel: QuestionViewModel = viewModel()
    ){

    NavHost(navController, startDestination = "HomeScreen"){
        composable("HomeScreen") {
            HomeScreen (onStartQuiz = {
                viewModel.getData()
                navController.navigate("Quize")
            })
        }
        composable("Quize") { QuizHome(viewModel) }
    }
}