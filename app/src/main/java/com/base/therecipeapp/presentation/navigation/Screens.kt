package com.base.therecipeapp.presentation.navigation

sealed class Screens(val route : String) {
    object RecipeScreen:Screens("RecipeScreen")
    object CategoryDetailsScreen:Screens("CategoryDetailsScreen")
}