package org.example.project.di

import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module


actual val platformModule: Module
    get() = module {
//        single<HttpClientEngine> { OkHttp.create() }
//        single { DatabaseFactory(androidApplication()) }
    }