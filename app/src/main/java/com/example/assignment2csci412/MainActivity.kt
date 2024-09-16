package com.example.assignment2csci412

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment2csci412.ui.theme.Assignment2CSCI412Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment2CSCI412Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

    @Composable
    fun MainScreen(modifier: Modifier = Modifier) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Russell Abarte", fontSize = 24.sp, textAlign = TextAlign.Center)
            Text(text = "Student ID: 1433892", fontSize = 20.sp, modifier = Modifier.padding(top = 8.dp))

            // Button for explicit intent
            Button(
                onClick = {
                    // Explicit Intent to start SecondActivity
                    val intent = Intent(this@MainActivity, SecondActivity::class.java)
                    startActivity(intent)
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Start Activity Explicitly")
            }

            // Button for implicit intent
            Button(
                onClick = {
                    val implicitIntent = Intent("com.example.assignment2csci412.ACTION_VIEW")
                    startActivity(implicitIntent)
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Start Activity Implicitly")
            }

        }
    }
}
