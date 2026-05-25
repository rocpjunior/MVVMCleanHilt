plugins {
    alias(libs.plugins.android.application) apply false
    id("com.google.dagger.hilt.android") version "2.59.2" apply false
    id("com.android.library") version "9.1.1" apply false
    id("com.google.devtools.ksp") version "2.0.21-1.0.25" apply false
}