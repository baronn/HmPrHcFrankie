package com.example.homeprjhc.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.homeprjhc.presentation.view.HomeScreen

@ExperimentalComposeUiApi
@Composable
fun WeatherNavigation(navController: NavHostController = rememberNavController()) {

    NavHost(navController = navController,startDestination = Destinations.Home.route){

        composable(Destinations.Home.route){
            HomeScreen()
        }
    }
}