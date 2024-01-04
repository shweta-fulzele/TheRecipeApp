package com.base.therecipeapp.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.base.therecipeapp.data.models.Category
import com.base.therecipeapp.data.viewmodels.RecipeViewModel
import com.base.therecipeapp.presentation.navigation.Screens

@Composable
fun RecipeHomePage(navController: NavHostController) {
    val recipeViewModel: RecipeViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screens.RecipeScreen.route) {
        composable(Screens.RecipeScreen.route) {
            RecipeScreenUI(viewState = viewState) {
                navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                navController.navigate(Screens.CategoryDetailsScreen.route)
            }
        }

        composable(Screens.CategoryDetailsScreen.route) {
            val category =
                navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat")
                    ?: Category("", "", "", "")
            CategoryDetailsScreen(category = category)

        }
    }
}