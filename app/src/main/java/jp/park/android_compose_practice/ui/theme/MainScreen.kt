package jp.park.android_compose_practice.ui.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    var bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomAppBar { }
        }
    ) { innerPadding ->
        NavHost(
            navController = bottomNavController,
            startDestination = "video_list",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("video_list") { backStackEntry ->
                VideoListScreen()
            }
        }
    }
}