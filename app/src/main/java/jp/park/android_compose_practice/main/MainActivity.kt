package jp.park.android_compose_practice.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import jp.park.android_compose_practice.ui.theme.AndroidcomposepracticeTheme
import jp.park.android_compose_practice.ui.theme.LoginScreen
import jp.park.android_compose_practice.ui.theme.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidcomposepracticeTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "login") {
                    composable("login") {
                        LoginScreen { email, password ->
                            Log.d("LOGIN", "email = $email")
                            Log.d("LOGIN", "password = $password")

                            navController.navigate("main_screen") {
                                popUpTo("login") { inclusive = true }
                            }
                        }
                    }

                    composable( route = "main_screen") {
                        MainScreen()
                    }
                }
            }
        }
    }
}