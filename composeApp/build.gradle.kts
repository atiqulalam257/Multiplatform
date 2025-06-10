import com.codingfeline.buildkonfig.compiler.FieldSpec
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.buildKonfig)
}

buildkonfig {
    packageName = "com.atiq.mp"

    defaultConfigs {


        // Read and sanitize properties from gradle.properties
        val apiKeyTmdb = (project.property("API_KEY_TMDB") as String).trim()
        val baseUrl = (project.property("BASE_URL") as String).trim()
        println("BASE_URL used in build: $baseUrl")
        val imageBaseUrl = (project.property("IMAGE_BASE_URL") as String).trim()
        val registerUrl = (project.property("REGISTER_URL") as String).trim()
        val resetPasswordUrl = (project.property("RESET_PASSWORD_URL") as String).trim()

        // Inject as string literals (each value must be wrapped with quotes manually)
        buildConfigField(FieldSpec.Type.STRING, "API_KEY_TMDB", "\"$apiKeyTmdb\"")
        buildConfigField(FieldSpec.Type.STRING, "BASE_URL", "\"$baseUrl\"")
        buildConfigField(FieldSpec.Type.STRING, "IMAGE_BASE_URL", "\"$imageBaseUrl\"")
        buildConfigField(FieldSpec.Type.STRING, "REGISTER_URL", "\"$registerUrl\"")
        buildConfigField(FieldSpec.Type.STRING, "RESET_PASSWORD_URL", "\"$resetPasswordUrl\"")
    }

    /* targetConfigs {
         // this name should be the same as target names you specified
         android {
             buildConfigField 'STRING', 'name2', 'value2'
             buildConfigField 'STRING', 'nullableField', 'NonNull-value', nullable: true
         }

         ios {
             buildConfigField 'STRING', 'name', 'valueForNative'
         }
     }*/
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)

            // Ktor Android engine
            implementation(libs.ktor.client.android)

            // Android-specific Koin
            implementation(libs.koin.android)

            // AndroidX
            implementation(libs.androidx.core)
            implementation(libs.androidx.appcompat)
            implementation(libs.androidx.activity.compose)

            // appcompat
            implementation(libs.androidx.activity.ktx)


            // Compose tooling
            implementation(libs.androidx.compose.ui.util)
            implementation(libs.androidx.compose.ui.tooling)
            implementation(libs.androidx.compose.ui.preview)

            // Maps + Location
            implementation(libs.maps.compose)
            implementation(libs.play.services.location)
            implementation(libs.play.services.maps)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtimeCompose)


            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.materialIconsExtended)
            implementation(compose.animation)
            implementation(compose.components.resources)

            // Logging
            implementation(libs.logger)

            // Coroutines
            implementation(libs.kotlinx.coroutines.core)

            // KotlinX Serialization
            implementation(libs.kotlinx.serialization.json)

            // Ktor (Multiplatform Core)
            implementation(libs.ktor.core)
            implementation(libs.ktor.json)
            implementation(libs.ktor.contentNegotiation)
            implementation(libs.ktor.logging)
            implementation(libs.ktor.logging.logback)

            // Koin
            implementation(libs.koin.core)
            implementation(libs.koin.test)
            implementation(libs.koin.compose)

            // Voyager Navigation
            implementation(libs.voyager.navigator)
            implementation(libs.voyager.koin)
            implementation(libs.voyager.tabs)
            implementation(libs.voyager.transitions)

            // Image loader
            implementation(libs.image.loader)

            // KVault (multiplatform settings)
            implementation(libs.settings)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.atiq.mp"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.atiq.mp"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

