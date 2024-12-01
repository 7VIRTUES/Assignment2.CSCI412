package com.example.assignment2csci412

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UiAutomatorTest {

    private lateinit var device: UiDevice

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup() {
        // Initialize UiDevice instance
        device = UiDevice.getInstance(androidx.test.platform.app.InstrumentationRegistry.getInstrumentation())

        // Start from the home screen
        device.pressHome()

        // Wait for launcher
        val launcherPackage: String = device.launcherPackageName
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), 5000)

        // Launch the app
        val context: Context = ApplicationProvider.getApplicationContext()
        val intent = context.packageManager.getLaunchIntentForPackage("com.example.assignment2csci412")
        intent!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK) // Clear out any previous instances
        context.startActivity(intent)

        // Wait for the app to appear
        device.wait(Until.hasObject(By.pkg("com.example.assignment2csci412").depth(0)), 5000)
    }

    @Test
    fun testStartActivityExplicitly() {
        // Wait for the "Start Activity Explicitly" button to appear and click it
        val startButton = device.wait(
            Until.findObject(By.text("Start Activity Explicitly")),
            5000 // Timeout in milliseconds
        )
        assertTrue("Start Activity Explicitly button not found", startButton != null)
        startButton.click()

        // Wait for the second activity to load (verify by checking the heading text)
        val secondActivityTitle = device.wait(
            Until.findObject(By.text("Mobile Software Engineering Challenges")),
            5000 // Timeout in milliseconds
        )
        assertTrue("Second activity title not found", secondActivityTitle != null)

        // Wait for one of the challenges to appear (e.g., "Managing limited device resources")
        val challengeText = device.wait(
            Until.findObject(By.textContains("Managing limited device resources")),
            5000 // Timeout in milliseconds
        )
        assertTrue("Expected challenge not found", challengeText != null)
    }


}
