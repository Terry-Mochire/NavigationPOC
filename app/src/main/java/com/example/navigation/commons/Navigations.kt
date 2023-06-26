package com.example.navigation.commons

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation.HelloScreen


@Composable
fun Navigation() {

    val navController = rememberNavController()

    val authenticationEntryImpl = Class.forName("com.example.feature.authentication.impl.ui.AuthenticationEntryImpl")

    val featureEntry = authenticationEntryImpl.getDeclaredConstructor().newInstance() as ComposableFeatureEntry


    NavHost(navController = navController, startDestination = "hello") {

        composable("hello") {
            HelloScreen(navHostController = navController)
        }

        composable("authentication") {
            featureEntry.Composable(navController = navController, backStackEntry =  it )
        }

    }

}



//@Composable
//fun NavGraphBuilder.navigation(navController: NavHostController) {
//    featureEntries.forEach { featureEntry ->
//        when (featureEntry) {
//            is ComposableFeatureEntry -> {
//                featureEntry.composable(navController = navController)
//            }
//            is AggregateFeatureEntry -> {
//                featureEntry.navigation(navController = navController)
//            }
//        }
//    }
//}