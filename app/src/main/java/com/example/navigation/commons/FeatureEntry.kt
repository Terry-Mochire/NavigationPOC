package com.example.navigation.commons

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NamedNavArgument
import androidx.navigation.compose.composable

interface FeatureEntry {
    val name: String
    val featureRoute: String
    val arguments: List<NamedNavArgument>
        get() = emptyList()

    val deepLinks: List<NavDeepLink>
        get() = emptyList()

}



interface ComposableFeatureEntry : FeatureEntry {
    fun NavGraphBuilder.composable(
        navController: NavHostController,
    ) {
        composable(
            route = featureRoute,
            arguments = arguments,
            deepLinks = deepLinks
        ) { backStackEntry ->
            Composable(
                navController = navController,
                backStackEntry = backStackEntry
            )
        }
    }

    @Composable
    fun Composable(
        navController: NavHostController,
        backStackEntry: NavBackStackEntry
    )
}

interface AggregateFeatureEntry : FeatureEntry {
    fun NavGraphBuilder.navigation(navController: NavHostController)
}
