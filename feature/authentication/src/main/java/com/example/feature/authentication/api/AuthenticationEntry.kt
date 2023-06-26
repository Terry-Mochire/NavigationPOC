package com.example.feature.authentication.api

import androidx.navigation.NavDeepLink
import androidx.navigation.NavDeepLinkBuilder
import com.example.navigation.commons.ComposableFeatureEntry

abstract class AuthenticationEntry: ComposableFeatureEntry {

    final override val name: String = "Authentication"
    final override val featureRoute: String = "authentication"

    final override val deepLinks: List<NavDeepLink> = listOf(
        NavDeepLink.Builder()
            .setUriPattern("app://authentication")
            .setAction("android.intent.action.VIEW")
            .build()
    )

}