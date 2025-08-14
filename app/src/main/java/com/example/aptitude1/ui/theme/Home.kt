package com.example.aptitude1.ui.theme

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun Home(navController : NavHostController, viewModel : ViewModel){

    NavHost(navController, startDestination = "HomeScreen"){

    }
}