import org.gradle.api.artifacts.dsl.RepositoryHandler
import java.net.URI

object Versions {
    const val target_sdk = 29
    const val min_sdk = 21
    const val build_tools = "29.0.0"
    const val version_code = 1
    const val version_name = "1.0.0"

    const val gradle = "3.4.2"
    const val kotlin = "1.3.50"
    const val core_ktx = "1.0.2"

    const val appcompat = "1.0.2"
    const val junit = "4.12"
    const val espresso_core = "3.2.0"
    const val runner = "1.2.0"

    const val arch_version = "2.2.0-alpha01"
    const val arch_room_version = "2.1.0-rc01"
    const val paging_version = "2.1.0"
    const val work_version = "2.1.0"

    const val constraint_layout = "1.1.3"

    const val glide = "4.8.0"

    const val retrofit = "2.6.0"
    const val okhttp_logging_interceptor = "3.9.0"

    const val timber = "4.7.1"
    const val material = "1.0.0-rc01"

    const val gson = "2.8.5"
    const val arouter_api = "1.5.0"
    const val arouter_compiler = "1.2.2"
}

object Deps {
    const val gradle_plugin = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlin_core = "androidx.core:core-ktx:${Versions.core_ktx}"

    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val junit = "junit:junit:${Versions.junit}"
    const val runner = "com.android.support.test:runner:${Versions.runner}"
    const val espresso_core = "com.android.support.test.espresso:espresso-core:${Versions.espresso_core}"

    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"

    const val arch_lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.arch_version}"
    const val arch_viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.arch_version}"
    const val arch_livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.arch_version}"
    const val arch_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.arch_version}"
    const val arch_room_runtime = "androidx.room:room-runtime:${Versions.arch_room_version}"
    const val arch_room_compiler = "androidx.room:room-compiler:${Versions.arch_room_version}"
    const val arch_room = "androidx.room:room-ktx:${Versions.arch_room_version}"
    const val paging_runtime = "androidx.paging:paging-runtime:${Versions.paging_version}"
    const val work_runtime = "androidx.work:work-runtime-ktx:${Versions.work_version}"

    const val glide_runtime = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    const val retrofit_runtime = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofit_adapter_rxjava2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val okhttp_logging_interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_logging_interceptor}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    const val arouter_api = "com.alibaba:arouter-api:${Versions.arouter_api}"
    const val arouter_compiler = "com.alibaba:arouter-compiler:${Versions.arouter_compiler}"

    val addRepos: (handler: RepositoryHandler) -> Unit = {
        it.google()
        it.jcenter()
        it.maven { url = URI("https://oss.sonatype.org/content/repositories/snapshots") }
    }
}
