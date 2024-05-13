package com.example.tugas3.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Gallery : Screen("gallery")
    data object About : Screen("about")
    data object Detail : Screen("detail")
}