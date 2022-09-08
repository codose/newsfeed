plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.android)
    kotlin(Plugins.kapt)
    id(Plugins.parcelize)
    id(Plugins.hilt)
    id(Plugins.jacoco)
}

android {
    compileSdk = 31

    lint {
        abortOnError = false
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    defaultConfig {
        applicationId = "com.android.newsfeed"
        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.android.newsfeed.HiltTestRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }

    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeVersion
    }
}

dependencies {
    implementation(Kotlin.core)
    implementation(Compose.ui)
    implementation(Compose.hilt)
    implementation(Compose.uiTooling)
    implementation(Compose.livedata)
    implementation(Compose.foundation)
    implementation(Compose.material)
    implementation(Compose.materialIconsCore)
    implementation(Compose.materialIconExtended)
    implementation(Compose.accompanistPermission)
    implementation("androidx.lifecycle:lifecycle-process:2.4.1")
    androidTestImplementation(Compose.composeUiTest)
    implementation(Compose.navigation)

    implementation(Timber.library)
    implementation(Navigation.navigation)
    implementation(Navigation.navigationUI)

    implementation(Kotlin.coroutines)
    implementation(Kotlin.coroutinesCore)
    implementation(Kotlin.coroutineReactive)

    testImplementation(Tests.coreTesting)
    testImplementation(Tests.core)
    testImplementation(Tests.coroutineTest)
    testImplementation(Tests.robolectric)
    testImplementation(Tests.mockk)
    testImplementation(Tests.extJUnit)
    testImplementation(Tests.espressoCore)
    testImplementation(Tests.junit)
    testImplementation(Tests.composeUiTest)
    testImplementation(Tests.hiltTesting)
    testImplementation(Tests.mockWebServer)
    testImplementation(Tests.idling)
    kaptTest(Tests.hiltCompiler)
    debugImplementation(Tests.composeDebugTest)

    // Hilt
    implementation(Hilt.hiltAndroid)
    kapt(Hilt.hiltAndroidCompiler)
    kapt(Hilt.hiltCompiler)
    implementation(Hilt.hiltNavigation)

    // Retrofit
    implementation(Retrofit.retrofit)
    implementation(Retrofit.okhttp)
    implementation(Retrofit.gson)
    implementation(Retrofit.logging)

    implementation(Compose.coil)
    implementation(Compose.paging)

    implementation(Room.room)
    implementation(Room.roomKtx)
    kapt(Room.roomKapt)
}

jacoco {
    toolVersion = Build.jacocoVersion
}
