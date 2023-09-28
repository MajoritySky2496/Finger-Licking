package com.example.finger_licking.util

import android.app.Application
import com.example.finger_licking.di.dataModule
import com.example.finger_licking.di.interactorModule
import com.example.finger_licking.di.repositoryModule
import com.example.finger_licking.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(dataModule, repositoryModule, interactorModule, viewModelModule)
        }
    }

}