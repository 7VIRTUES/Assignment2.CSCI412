package com.example.assignment2csci412

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import com.example.assignment2csci412.ui.theme.Assignment2CSCI412Theme

class ImageCaptureActivity : ComponentActivity() {
    private var capturedImage: MutableState<Bitmap?> = mutableStateOf(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Assignment2CSCI412Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImageCaptureScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

    // Composable Function for Image Capture UI
    @Composable
    fun ImageCaptureScreen(modifier: Modifier = Modifier) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Capture Image Button
            Button(
                onClick = { captureImage() },
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text(text = "Capture Image")
            }

            // Display captured image if available
            capturedImage.value?.let { bitmap ->
                Image(
                    bitmap = bitmap.asImageBitmap(),
                    contentDescription = "Captured Image",
                    modifier = Modifier
                        .size(200.dp)
                        .padding(top = 16.dp)
                )
            }
        }
    }

    // Function to capture an image using the camera
    private fun captureImage() {
        val cameraIntent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
        cameraLauncher.launch(cameraIntent)
    }

    // Register the activity result to handle the captured image
    private val cameraLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val imageBitmap = result.data?.extras?.get("data") as? Bitmap
            capturedImage.value = imageBitmap
        }
    }
}
