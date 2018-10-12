object Versions {
    const val minSdk = "21"
    const val targetSdk = "28"
    const val versionCode = 1
    const val versionName = "1.0"

    const val kotlin = "1.2.71"
    const val gradle = "3.2.0"
    const val fabric = "1.+"
    const val crashlytics = "2.9.5"
    const val timber = "4.7.1"

    const val appCompat = "1.0.0"
    const val fragment = "1.0.0"
    const val constraintLayout = "1.1.3"
    const val multidex = "2.0.0"

    const val lifecycle = "2.0.0"
    const val room = "2.0.0"
    const val anko = "0.10.7"
    const val retrofit = "2.3.0"
    const val parceler = "1.1.6"
    const val okHttp = "3.8.0"
    const val espresso = "3.0.2"
    const val rxjava = "2.0.2"
    const val rxandroid = "1.2.1"
    const val dagger2 = "2.12"
    const val junit = "4.12"
    const val runner = "1.0.2"
    const val material = "1.0.0"
    const val leakcanary = "1.6.1"
}

object LibsPrefix {
    const val anko = "org.jetbrains.anko:anko-"
    const val lifecycle = "androidx.lifecycle:lifecycle-"
    const val room = "androidx.room:room-"
    const val retrofit = "com.squareup.retrofit2:"
    const val okhttp3 = "com.squareup.okhttp3:"
    const val reactivex = "io.reactivex"
    const val dagger2 = "com.google.dagger:dagger"
    const val leakcanary = "com.squareup.leakcanary:leakcanary-"
}

object Libs {

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}@aar"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val leakcanary = "${LibsPrefix.leakcanary}android:${Versions.leakcanary}"
    const val leakcanaryFragment = "${LibsPrefix.leakcanary}support-fragment:${Versions.leakcanary}"

    const val multidex = "androidx.multidex:multidex:${Versions.multidex}"

    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val fragment = "androidx.fragment:fragment:${Versions.fragment}"
    const val design = "com.google.android.material:material:${Versions.material}"

    const val ankoSdk = "${LibsPrefix.anko}sdk${Versions.minSdk}:${Versions.anko}"
    const val ankoAppCompact = "${LibsPrefix.anko}appcompat-v7:${Versions.anko}"
    const val ankoSupportV4 = "${LibsPrefix.anko}support-v4:${Versions.anko}"

    const val lifecycleExtensions = "${LibsPrefix.lifecycle}extensions:${Versions.lifecycle}"
    const val lifecycleRuntime = "${LibsPrefix.lifecycle}runtime:${Versions.lifecycle}"
    const val lifecycleCompiler = "${LibsPrefix.lifecycle}compiler:${Versions.lifecycle}"
    const val lifecycleTesting = "androidx.arch.core:core-testing:${Versions.lifecycle}"

    const val roomRuntime = "${LibsPrefix.room}runtime:${Versions.room}"
    const val roomRxJava2 = "${LibsPrefix.room}rxjava2:${Versions.room}"
    const val roomCompiler = "${LibsPrefix.room}compiler:${Versions.room}"
    const val roomTesting = "androidx.room:room-testing:${Versions.room}"

    const val retrofit = "${LibsPrefix.retrofit}retrofit:${Versions.retrofit}"
    const val retrofitConverterGson = "${LibsPrefix.retrofit}converter-gson:${Versions.retrofit}"
    const val retrofitRxJava2 = "${LibsPrefix.retrofit}adapter-rxjava2:${Versions.retrofit}"

    const val okhttp3 = "${LibsPrefix.okhttp3}okhttp:${Versions.okHttp}"
    const val okhttp3Interceptor = "${LibsPrefix.okhttp3}logging-interceptor:${Versions.okHttp}"

    const val rxjava2RxAndroid = "${LibsPrefix.reactivex}.rxjava2:rxandroid:${Versions.rxjava}"
    const val rxjava2Rxjava = "${LibsPrefix.reactivex}.rxjava2:rxjava:${Versions.rxjava}"
    const val rxandroid = "${LibsPrefix.reactivex}:rxandroid:${Versions.rxandroid}"

    const val dagger2 = "${LibsPrefix.dagger2}:${Versions.dagger2}"
    const val dagger2Compiler = "${LibsPrefix.dagger2}-compiler:${Versions.dagger2}"
    const val dagger2Android = "${LibsPrefix.dagger2}-android:${Versions.dagger2}"
    const val dagger2AndroidSupport = "${LibsPrefix.dagger2}-android-support:${Versions.dagger2}"
    const val dagger2Processor = "${LibsPrefix.dagger2}-android-processor:${Versions.dagger2}"


    const val junit = "junit:junit:${Versions.junit}"
    const val runner = "com.android.support.test:runner:${Versions.runner}"
    const val espresso = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
}

object ClassPaths {
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val fabricPlugin = "io.fabric.tools:gradle:${Versions.fabric}"
}