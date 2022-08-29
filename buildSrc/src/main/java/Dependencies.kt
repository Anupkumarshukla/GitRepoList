object Dependencies {

    //kotlin

    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_STDLIB}"

    //lifecycle
    const val VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
    const val LIVE_DATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"
    const val LIFE_CYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"

    //google material
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"

    //androidX
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val ACTIVITY_KTX = "androidx.activity:activity-ktx:${Versions.ACTIVITY_KTX}"

    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"


    //coroutines
    const val KOTLINX_COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    const val KOTLINX_COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    const val GSON = "com.google.code.gson:gson:${Versions.GSON}"


    //retrofit
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val GSON_CONVERTOR = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"


    const val COIL = "io.coil-kt:coil:${Versions.COIL}"
    const val MULTIDEX = "androidx.multidex:multidex:${Versions.MULTIDEX}"
    const val ANNOTATION = "androidx.annotation:annotation:1.2.0"

    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"

    //hilt
    const val HILT = "com.google.dagger:hilt-android:${Versions.HILT_ANDROID}"
    const val KAPT_HILT_COMPILER = "com.google.dagger:hilt-compiler:${Versions.HILT_COMPILER}"

    //paging
    const val PAGING_RUNTIME = "androidx.paging:paging-runtime:${Versions.PAGING_VERSION}"

    //test
    const val TEST_JUNIT = "junit:junit:${Versions.JUNIT}"
    const val TEST_JUNIT_EXT = "androidx.test.ext:junit:${Versions.EXT_JUNIT}"
    const val TEST_JUNIT_ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
}