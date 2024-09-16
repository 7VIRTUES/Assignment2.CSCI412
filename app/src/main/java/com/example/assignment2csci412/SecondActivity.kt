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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment2csci412.ui.theme.Assignment2CSCI412Theme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment2CSCI412Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SecondScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

    @Composable
    fun SecondScreen(modifier: Modifier = Modifier) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Mobile Software Engineering Challenges",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // List of mobile software engineering challenges
            val challenges = listOf(
                "1. Managing limited device resources",
                "2. Ensuring compatibility across multiple devices",
                "3. Handling user data securely",
                "4. Optimizing battery and performance",
                "5. Designing intuitive and responsive UIs"
            )

            challenges.forEach { challenge ->
                Text(text = challenge, fontSize = 18.sp, modifier = Modifier.padding(4.dp))
            }

            // Button to go back to the main activity
            Button(
                onClick = {
                    val intent = Intent(this@SecondActivity, MainActivity::class.java)
                    startActivity(intent)
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Back to Main Activity")
            }
        }
    }
}
