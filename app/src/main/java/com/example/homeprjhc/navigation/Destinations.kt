package com.example.homeprjhc.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(val route: String, val title: String, val icon: ImageVector) {
    data object Home: Destinations("home","Home", Icons.Filled.Home)
}