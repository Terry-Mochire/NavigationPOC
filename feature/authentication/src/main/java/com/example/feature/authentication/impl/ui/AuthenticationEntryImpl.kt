package com.example.feature.authentication.impl.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.feature.authentication.api.AuthenticationEntry

class AuthenticationEntryImpl : AuthenticationEntry() {

    @Composable
    override fun Composable(navController: NavHostController, backStackEntry: NavBackStackEntry) {

        LoginScreen(navHostController = navController)
    }
}