package jp.park.android_compose_practice.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyPageScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("マイページ") },
                actions = {
                    IconButton(onClick = { }) { Icon(imageVector = Icons.Default.Email, contentDescription = "Mail", tint = Color.DarkGray) }
                    IconButton(onClick = { }) { Icon(imageVector = Icons.Default.Notifications, contentDescription = "Notifications", tint = Color.DarkGray) }
                    IconButton(onClick = { }) { Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings", tint = Color.DarkGray) }
                },
                modifier = Modifier.statusBarsPadding(),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black
                ),
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ) {

        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MyPageScreenPreView() {
    MyPageScreen()
}