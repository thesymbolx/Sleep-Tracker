package com.example.sleeptracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sleeptracker.ui.theme.SleepTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SleepQualityPickerScreen()
        }
    }
}

@Composable
fun SleepQualityPickerScreen() {
    SleepTrackerTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            SleepRatingPicker()
        }
    }
}

@Composable
fun SleepRatingPicker() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
    ) {
        SleepRatingButton(8, 8, 0, 0)
        SleepRatingButton(0, 0, 0, 0)
        SleepRatingButton(0, 0, 0, 0)
        SleepRatingButton(0, 0, 8, 8)
    }
}

@Composable
fun SleepRatingButton(topStart: Int, topEnd: Int, bottomStart: Int, bottomEnd: Int) {
    Box(
        Modifier
            .clip(
                RoundedCornerShape(
                    topStart = topStart.dp,
                    topEnd = topEnd.dp,
                    bottomStart = bottomStart.dp,
                    bottomEnd = bottomEnd.dp
                )
            )
            .clickable { }) {
        Surface(
            color = Color.Yellow,
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = topStart.dp,
                        topEnd = topEnd.dp,
                        bottomStart = bottomStart.dp,
                        bottomEnd = bottomEnd.dp
                    )
                )
                .fillMaxWidth()
        ) {
            Text(text = "Hello", textAlign = TextAlign.Center)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SleepTrackerTheme {
        SleepRatingPicker()
    }
}