package com.example.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HelloScreen(
    navHostController: NavHostController
) {
   Column(
         modifier = Modifier
              .fillMaxSize()
              .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
   ){
       Text(text = "Hello Screen")
       Button(onClick = {
           navHostController.navigate("login")
       }) {
            Text(text = "Login")
       }

   }
}