package com.example.aptitude1.ui.theme

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.aptitude1.ui.theme.screens.HomeScreen
import com.example.aptitude1.ui.theme.screens.QuizHome
import com.example.aptitude1.ui.theme.screens.ResultScreen
import com.example.aptitude1.viewmodel.QuestionViewModel

@Composable
fun Home(
    navController : NavHostController,
    viewModel: QuestionViewModel = viewModel()
    ){

    NavHost(navController, startDestination = "HomeScreen?examFailed={examFailed}") {
        composable(
            "HomeScreen?examFailed={examFailed}",
            arguments = listOf(navArgument("examFailed") {
                type = NavType.BoolType
                defaultValue = false
            })
        ) { backStackEntry ->
            val failed = backStackEntry.arguments?.getBoolean("examFailed") ?: false
            HomeScreen(onStartQuiz = {
                viewModel.getData()
                navController.navigate("Quize")
            }, failed)
        }

        composable("Quize") {
            QuizHome(navController, viewModel)
        }

        composable(
            "Result?result={result}",
            arguments = listOf(navArgument("result"){
                type = NavType.IntType
                defaultValue = 0
            })
        ) { result ->
            val result = result.arguments?.getInt("result")
            ResultScreen(result,navController, viewModel)
        }
    }

}