package com.example.feature.authentication.commons

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.feature.authentication.api.AuthenticationEntry
import com.example.feature.authentication.impl.ui.AuthenticationEntryImpl
import com.example.feature.authentication.impl.ui.LoginScreen
import com.example.feature.authentication.impl.ui.WelcomeScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = AuthenticationEntryImpl().featureRoute) {

            composable(AuthenticationEntryImpl().featureRoute) {
                LoginScreen(navHostController = navController)
            }

            composable("welcome") {
                WelcomeScreen()
            }

    }
}