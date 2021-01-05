package dependencies.dependencies

import dependencies.Versions

object Dependencies {

    /** default */
    val kotlin_standard_library = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val kotlin_reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    val material_dialogs = "com.afollestad.material-dialogs:core:${Versions.material_dialogs}"
    val material_dialogs_input = "com.afollestad.material-dialogs:input:${Versions.material_dialogs}"

    /** other */

    // di
    val koin = "org.koin:koin-android:${Versions.koin_version}"
    val koin_lifecycle = "org.koin:koin-android-scope:${Versions.koin_version}"
    val koin_viewModel = "org.koin:koin-android-viewmodel:${Versions.koin_version}"
    val dagger = "com.google.dagger:dagger:${Versions.dagger}"

    // database
    val room_runtime = "androidx.room:room-runtime:${Versions.room}"
    val room_ktx = "androidx.room:room-ktx:${Versions.room}" // for coroutine support

    // network
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit2_version}"
    val retrofit_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit2_version}"
    val retrofit_moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit2_version}"
    val retrofit_coroutine_adapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofit2_coroutine_adapter_version}"
    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp_version}"
    val okhttp_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_version}"
    val network_response = "com.github.haroldadmin:NetworkResponseAdapter:${Versions.network_response_version}"

    // image
    val glide = "com.github.bumptech.glide:glide:${Versions.glide_version}"

    // coroutine
    val kotlin_coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines_version}"
    val kotlin_coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines_version}"
    val kotlin_coroutines_play_services = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutines_play_services}"

    // lifecycle
    val lifecycle_viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
    val lifecycle_livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
    val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle_version}"
    val lifecycle_coroutines = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"

    //fragment
    val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment_version}"

    // navigation
    val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.nav_components}"
    val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.nav_components}"
    val navigation_runtime = "androidx.navigation:navigation-runtime:${Versions.nav_components}"
    val navigation_dynamic = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.nav_components}"

    // firebase
    val firebase_firestore = "com.google.firebase:firebase-firestore-ktx:${Versions.firebase_firestore}"
    val firebase_auth = "com.google.firebase:firebase-auth:${Versions.firebase_auth}"
    val firebase_analytics = "com.google.firebase:firebase-analytics-ktx:${Versions.firebase_analytics}"
    val firebase_crashlytics = "com.google.firebase:firebase-crashlytics:${Versions.firebase_crashlytics}"

    // other
    val play_core = "com.google.android.play:core:${Versions.play_core}"
    val leak_canary = "com.squareup.leakcanary:leakcanary-android:${Versions.leak_canary}"
    val markdown_processor = "com.yydcdut:markdown-processor:${Versions.markdown_processor}"

    // test


}
