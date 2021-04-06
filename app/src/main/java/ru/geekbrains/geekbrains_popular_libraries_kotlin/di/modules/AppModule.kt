package ru.geekbrains.geekbrains_popular_libraries_kotlin.di.modules

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.App

@Module
class AppModule(val app: App) {

    @Provides
    fun uiScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    fun app(): App{
        return app
    }
}