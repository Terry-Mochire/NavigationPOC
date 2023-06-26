package com.example.navigation

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
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
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.google.android.play.core.splitinstall.SplitInstallSessionState
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus
import com.google.android.play.core.tasks.OnFailureListener
import com.google.android.play.core.tasks.OnSuccessListener


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

       val splitInstallManager: SplitInstallManager = SplitInstallManagerFactory.create(navHostController.context)

       val installedModules: Set<String> = splitInstallManager.getInstalledModules()

       if (installedModules.isNotEmpty()) {
              installedModules.forEach {
                  Button(onClick = {
                navHostController.navigate("authentication")
                  }) {
                      Text(text = it)
                  }
              }

       } else {
           Button(onClick = {
               downloadDynamicModule(context = navHostController.context)
           }) {
               Text(text = "Download Module")
           }

       }

   }
}

private fun downloadDynamicModule(context: Context) {
    var mySessionId: Int = 0

    val TAG = "Hello Screen"


    val splitInstallManager: SplitInstallManager = SplitInstallManagerFactory.create(context)
    val request: SplitInstallRequest = SplitInstallRequest
        .newBuilder()
        .addModule("Authentication")
        .build()
    val listener: SplitInstallStateUpdatedListener = object : SplitInstallStateUpdatedListener {
        override fun onStateUpdate(splitInstallSessionState: SplitInstallSessionState) {

            if (splitInstallSessionState.sessionId() == mySessionId) {
                when (splitInstallSessionState.status()) {
                    SplitInstallSessionStatus.INSTALLED -> {
                        Log.d(TAG, "Dynamic Module downloaded")
                        Toast.makeText(
                            context,
                            "Dynamic Module downloaded",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
    splitInstallManager.registerListener(listener)
    splitInstallManager.startInstall(request)
        .addOnFailureListener(object : OnFailureListener {
            override fun onFailure(e: Exception) {
                Log.d(TAG, "Exception: $e")
            }
        })
        .addOnSuccessListener(object : OnSuccessListener<Int?> {
            override fun onSuccess(sessionId: Int?) {
                mySessionId = sessionId!!
            }
        })
}