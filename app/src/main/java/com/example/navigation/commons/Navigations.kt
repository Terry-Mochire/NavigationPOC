package com.example.navigation.commons

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation.HelloScreen

abstract class TestEntry: ComposableFeatureEntry {

    final override val name: String = "Test"
    final override val featureRoute: String = "test"

}

class TestEntryImpl: TestEntry() {

    @Composable
    override fun Composable(navController: NavHostController, backStackEntry: NavBackStackEntry) {

            HelloScreen(navHostController = navController)
    }
}

val featureEntries: List<ComposableFeatureEntry> = listOf(
    TestEntryImpl()
)

// Access abstract classes from the dynamic feature module
// by using the fully qualified name of the class.

//import com.example.feature.authentication.api.AuthenticationEntry

//val featureEntries: List<FeatureEntry> = listOf(
//    AuthenticationEntryImpl()
//)

//    val featureEntries: List<FeatureEntry> = listOf(
//        AuthenticationEntryImpl()
//    )




@Composable
fun Navigation(){

    val navController = rememberNavController()

    NavHost(navController = navController , startDestination = "hello") {

        composable("hello"){
                featureEntries.forEach{
                    println("featureRoute: ${it.featureRoute}")
                    println("currentDestination: ${navController.currentDestination?.route}")
//                if(it.featureRoute == navController.currentDestination?.route){
//                    it.composable(navController = navController)
//                }
                }
           HelloScreen(navHostController = navController)
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