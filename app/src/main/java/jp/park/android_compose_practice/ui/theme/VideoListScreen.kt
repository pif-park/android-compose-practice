package jp.park.android_compose_practice.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jp.park.android_compose_practice.data.VideoItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideoListScreen() {
    val dummyVideos = remember {
        listOf(
            VideoItem(1, "test video1"),
            VideoItem(2, "test video2"),
            VideoItem(3, "test video3"),
            VideoItem(4, "test video4"),
            VideoItem(5, "test video5"),
            VideoItem(6, "test video6"),
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Test app")
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(dummyVideos) { video ->
                VideoCard(videoItem = video)
            }
        }
    }
}

@Composable
private fun VideoCard(videoItem: VideoItem) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().height(210.dp).background(Color.Gray)
        ) {
            Text(
                text = videoItem.title,
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
                    .background(Color.Black.copy(alpha = 0.8f), shape = RoundedCornerShape(4.dp))
                    .padding(horizontal = 4.dp, vertical = 2.dp)
            )
        }
    }
}