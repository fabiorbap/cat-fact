# Cat Facts

## Description

This app was developed according to the project requirements described in the challenge.

It's an app about cat facts, which displays a random cat fact, taken from the https://catfact.ninja API.

The user can get a new fact and save it to favorites. The fact will appear
on a list which can be viewed even when connection isn't available.

The user can also remove the fact from the list.

I also added the sharing functionality, which allows the user to share
a quote with other people through other apps.

Below there are sections that talk about important topics such as architecture, libraries used and additional details about the development.

It is a summary, the rest of the information is available in the project.

## Technical details

This app was developed using Android Studio Chimpunk | 2021.1.Beta 4 in a Mac M1 computer.
The JDK version is 11.0.12. Other details can be found in the code.

## Setup instructions

Clone the repository to your computer and open it with Android Studio.

Run the project in either `master` or `develop` branch, they are identical at this moment.

The project should run and check if you have all the tools required to run it.

You may be required to download the project Build Tools or SDK version so that
you can run it.

After you have downloaded everything required to run the project, click "Run", which will open an emulator or run into a connected device.

If you can't run the project, please, let me know so I can help you.

## Architecture summary

I used the [MVVM architecture](https://developer.android.com/jetpack/guide), for separation of concerns between layers (decreasing code coupling),
code reusability and better readability, and also due to the ViewModel from Android Architecture Components
being lifecycle aware, which is important to prevent crashes and leaks.
I also used LiveData to make the code reactive and also lifecycle aware.

## Libraries

Here is a list of the most important libraries in the project and the reason why they were used:

### [Material Components](https://github.com/material-components/material-components-android)

Implement default and custom views in the app

### [ConstraintLayout](https://developer.android.com/jetpack/androidx/releases/constraintlayout)

Build screens layout and custom views

### [ViewModel and LiveData](https://developer.android.com/jetpack/androidx/releases/lifecycle#declaring_dependencies)

Make the ViewModel layer lifecycle aware and responsive, data manipulation and to store data from the facts fragment after it was destroyed.

### [Navigation](https://developer.android.com/guide/navigation/navigation-getting-started)

Navigation with fragments implementation made simpler

### [Room](https://developer.android.com/training/data-storage/room)

Local persistence storage which enables the user to access the favorites screen even when the device is offline

### [Retrofit](https://square.github.io/retrofit/)

Create a HTTP client to communicate with the catfact.ninja API

### [RxJava2](https://github.com/ReactiveX/RxAndroid)

Make the code reactive and make it easier to work with threads

### [Koin](https://insert-koin.io/)

Implement dependency injection to make the code less coupled and more reusable

### [Lottie](https://github.com/airbnb/lottie-android)

Run the loading animation with the cat

## Design

I decided for a simple, minimalistic design which does not distract the user from the fact.

I also wanted the app to be playful, that's why I included the cat face in the main screen and as the app icon and also the cat loading.

I chose dark pink as the primary color for the app because I felt it also gave the app a feeling of playfulness, of fun.

In the favorites screen, a dialog shows when the user tries to remove the fact, because if the user accidentally deleted the fact, then he/she would have to find it again.

The dialog is not present in the fact screen, after the user presses the heart button, because the user can easily favorite the fact in display again. I thought the dialog would be intrusive in this screen.

I implemented a share functionality because I believe users would enjoy showing the information to their friends. The message says "Download it in the Play Store", but I have not uploaded it there, it was just as an example.
