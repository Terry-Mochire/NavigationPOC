package com.example.feature.authentication.impl.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.feature.authentication.api.AuthenticationEntry
import com.example.feature.authentication.commons.Navigation

class AuthenticationEntryImpl : AuthenticationEntry() {

    @Composable
    override fun Composable(navController: NavHostController, backStackEntry: NavBackStackEntry) {
        Navigation()
    }
}