package jp.park.android_compose_practice.ui.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BorderColor
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

sealed class BottomNavItem(val route: String, val title: String, val icon: ImageVector) {
    object Study1 : BottomNavItem("study1", "ビデオリスト", Icons.Default.BorderColor)
    object Study2 : BottomNavItem("study2", "マイページ", Icons.Default.BorderColor)
    object Study3 : BottomNavItem("study3", "Study3", Icons.Default.BorderColor)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var bottomNavController = rememberNavController()
    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val navItems = listOf(
        BottomNavItem.Study1,
        BottomNavItem.Study2,
        BottomNavItem.Study3
    )

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.White
            ) {
                navItems.forEach { item ->
                    NavigationBarItem(
                        icon = { Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )},
                        label = { Text(
                            text = item.title,
                            fontSize = 11.sp
                        )},
                        selected = currentRoute == item.route,
                        onClick = {
                            if (currentRoute != item.route) {
                                bottomNavController.navigate(item.route) {
                                    popUpTo(bottomNavController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    )
                }
            }
        }
    ) { _ ->
        NavHost(
            navController = bottomNavController,
            startDestination = BottomNavItem.Study1.route
        ) {
            composable(BottomNavItem.Study1.route) { VideoListScreen() }
            composable(BottomNavItem.Study2.route) { MyPageScreen() }
            composable(BottomNavItem.Study3.route) { VideoListScreen() }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MainScreenPreview() {
    MainScreen()
}