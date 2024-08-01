
# Installation

Installing Kotlin into your FTC project is very easy and shouldn't take more than a few minutes.

## Project Gradle Script

The first step of adding Kotlin to your FTC project is by adding Kotlin to the *build.gradle* file that has *Project: REPO-NAME* next to it. Add the indicated lines of code to the aforementioned file:

    buildscript {

    ext.kotlin_version = '1.8.20' <----- ADD THIS LINE, UPDATE VERSION TO LATEST IF NEEDED

    repositories {
        mavenCentral()
        google()
    }

    dependencies {
        classpath 'com.android.tools.build:gradle:7.2.0'
        ==classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version" <----- ADD THIS LINE==
    }
    }

## TeamCode Gradle Script

The only other thing you have to do is copy the indicated line of code into the *build.gradle* file that has *Module: TeamCode* next to it.

    apply from: '../build.common.gradle'
    apply from: '../build.dependencies.gradle'
    apply plugin: 'kotlin-android' <----- ADD THIS LINE

If you are confused on where to copy the code, I have labeled the place to copy the first set of lines in blue, and the other line in yellow.
![Please ignore everything else, as this is a preexisting project that has other libraries installed.](/assets/images/installation-gradle.png)
After doing this, you should be ready to start programming!
