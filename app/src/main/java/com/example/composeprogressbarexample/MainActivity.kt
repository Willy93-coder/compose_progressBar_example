package com.example.composeprogressbarexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeprogressbarexample.ui.theme.ComposeProgressBarExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProgressBarExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyProgressAdvance()
                }
            }
        }
    }
}

@Composable
fun MyProgressAdvance() {
    var percent by rememberSaveable {
        mutableStateOf(0f)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = percent)
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = {
                if (percent > 0f) {
                    percent -= 0.1f
                }
            }) {
                Text(text = "-")
            }
            Button(onClick = {
                if (percent < 1f) {
                    percent += 0.1f
                }
            }) {
                Text(text = "+")
            }
        }
    }
}

@Composable
fun MyProgress1() {
    var showLoading by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        Modifier.padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator()
            LinearProgressIndicator(modifier = Modifier.padding(top = 32.dp))
        }
    }

    Button(onClick = { showLoading = !showLoading }) {
        Text(text = "Mostrar progressbar")
    }
}

@Composable
fun MyProgress() {
    Column(
        Modifier.padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = Color.Red, strokeWidth = 5.dp)
        LinearProgressIndicator(modifier = Modifier.padding(top = 32.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun MyProgressPreview() {
    ComposeProgressBarExampleTheme {
        MyProgress()
    }
}