package com.example.assignment2csci412

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.assignment2csci412.ui.theme.Assignment2CSCI412Theme

class MainActivity : ComponentActivity() {

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                // Permission granted
                println("Custom permission granted")
            } else {
                // Permission denied
                println("Custom permission denied")
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Request the custom permission at runtime
        requestCustomPermission()

        setContent {
            Assignment2CSCI412Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

    private fun requestCustomPermission() {
        val customPermission = "com.example.assignment2csci412.MSE412"

        // Check if the custom permission is already granted
        if (ContextCompat.checkSelfPermission(this, customPermission) !=
            android.content.pm.PackageManager.PERMISSION_GRANTED
        ) {
            // Request the permission using the launcher
            requestPermissionLauncher.launch(customPermission)
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
                    // Check if permission is granted before navigating to SecondActivity
                    val customPermission = "com.example.assignment2csci412.MSE412"
                    if (ContextCompat.checkSelfPermission(
                            this@MainActivity,
                            customPermission
                        ) == android.content.pm.PackageManager.PERMISSION_GRANTED
                    ) {
                        val intent = Intent(this@MainActivity, SecondActivity::class.java)
                        startActivity(intent)
                    } else {
                        println("Permission not granted. Cannot start SecondActivity.")
                    }
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

            // New Button to Start Image Activity
            Button(
                onClick = {
                    val imageActivityIntent = Intent(this@MainActivity, ImageCaptureActivity::class.java)
                    startActivity(imageActivityIntent)
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("View Image Activity")
            }

        }
    }
}
