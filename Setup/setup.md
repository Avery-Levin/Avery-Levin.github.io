# Installation
Installing Kotlin into your FTC project is very easy and shouldn't take more than a few minutes.

## Prerequisites
Before installing Kotlin, please make sure you have done the following:
- [Have the latest version of Android Studio downloaded and installed](https://developer.android.com/studio)
- [Have a repository containing the latest version of the FTC SDK](https://github.com/FIRST-Tech-Challenge/FtcRobotController)
- Make sure the Kotlin Plugin is downloaded in Android Studio

## Buildscript
The first step of adding Kotlin to your FTC project is by adding kotlin to the *build.gradle* file under build script. Add the following code to the aforementioned file: 


    buildscript {

    ext.kotlin_version = '1.8.20' <----- ADD THIS LINE, UPDATE VERSION TO LATEST IF NEEDED

    repositories {
        mavenCentral()
        google()
    }

    dependencies {
        classpath 'com.android.tools.build:gradle:7.2.0'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version" <----- ADD THIS LINE
    }
    } 
