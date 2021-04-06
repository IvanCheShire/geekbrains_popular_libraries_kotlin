package ru.geekbrains.geekbrains_popular_libraries_kotlin.ui

import android.app.Application
import ru.geekbrains.geekbrains_popular_libraries_kotlin.di.modules.AppModule
import ru.terrakok.cicerone.Cicerone
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.room.db.Database

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent =  DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}
