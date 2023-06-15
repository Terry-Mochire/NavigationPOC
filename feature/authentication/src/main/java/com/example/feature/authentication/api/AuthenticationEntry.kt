package com.example.feature.authentication.api

import com.example.navigation.commons.ComposableFeatureEntry

abstract class AuthenticationEntry: ComposableFeatureEntry {

    final override val name: String = "Authentication"
    final override val featureRoute: String = "authentication"

}