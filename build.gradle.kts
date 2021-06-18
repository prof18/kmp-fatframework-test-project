plugins {
    kotlin("multiplatform") version "1.5.10"
    id("com.android.library")
    id("com.prof18.kmp.fatframework.cocoa") version "0.0.2-SNAPSHOT"
}

group = "com.prof18"
version = "1.0.1-SNAPSHOT"

repositories {
//    mavenLocal()
    google()
    jcenter()
    mavenCentral()
}

kotlin {
    android()
    ios {
        binaries.framework("LibraryName")
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("com.google.android.material:material:1.2.1")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13")
            }
        }
        val iosMain by getting
        val iosTest by getting
    }
}

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(30)
    }
}

fatFrameworkCocoaConfig {
    fatFrameworkName = "LibraryName"
//    outputPath = "$rootDir/../test-dest"
    outputPath = "$rootDir/../test-dest-xc"
//    namePrefix = "LibraryName"
    versionName = "1.2"

    cocoaPodRepoInfo {
        summary = "This is a test KMP framework"
        homepage = "https://github.com/prof18/ccoca-repo-test"
        license = "Apache"
        authors = "\"Marco Gomiero\" => \"mg@me.com\""
        gitUrl = "git@github.com:prof18/cocoa-repo-xcframework-test.git"
        useXCFramework = true
    }
}
