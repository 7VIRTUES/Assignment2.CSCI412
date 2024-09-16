# Assignment 2 - Mobile Software Engineering Challenges

## Description
This is an Android app developed for **Assignment 2** of the CSCI 412 course. The app demonstrates the use of **explicit** and **implicit intents** in Android by launching activities within the application. The main focus of the app is to showcase a simple user interface (UI) where users can view a list of mobile software engineering challenges and navigate between activities using intents.

## Features
- **Main Activity**:
    - Displays basic information about the developer (Name and Student ID).
    - Two buttons are provided for:
        1. Launching the `SecondActivity` using **explicit intent**.
        2. Launching the `SecondActivity` using **implicit intent**.

- **Second Activity**:
    - Displays a list of common mobile software engineering challenges:
        1. Managing limited device resources.
        2. Ensuring compatibility across multiple devices.
        3. Handling user data securely.
        4. Optimizing battery and performance.
        5. Designing intuitive and responsive UIs.
    - Includes a button to return to the `MainActivity`.

## Technologies Used
- **Kotlin**: The programming language used for the app.
- **Jetpack Compose**: Used to create the user interface declaratively.
- **Android Studio**: IDE for development.
- **Android Intents**: Demonstrated explicit and implicit intents for navigating between activities.

## Device/Emulator and Android OS Version
- **Emulator**: Medium Phone API 35
- **Android OS Version**: API Level 35 (Android 12L)

## App Structure
1. **MainActivity**:
    - Displays developer information and two buttons for intent navigation.
2. **SecondActivity**:
    - Shows a list of mobile engineering challenges and a button to return to `MainActivity`.

## How to Use the App
1. **Explicit Intent**: Click the "Start Activity Explicitly" button on the main screen to directly launch the `SecondActivity`.
2. **Implicit Intent**: Click the "Start Activity Implicitly" button to indirectly launch the `SecondActivity` using an implicit intent action.
3. **Return to Main Activity**: On the second screen, click "Back to Main Activity" to return to the main screen.
