package ru.geekbrains.geekbrains_popular_libraries_kotlin.di.modules

import android.widget.ImageView
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.core.Scheduler
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.image.IImageLoader
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.network.INetworkStatus
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.image.GlideImageLoader
import javax.inject.Singleton

@Module
class ImageLoaderModule {

    @Singleton
    @Provides
    fun imageLoader(imageCache: IImageCache, networkStatus: INetworkStatus, uiScheduler: Scheduler): IImageLoader<ImageView> = GlideImageLoader(imageCache, networkStatus, uiScheduler)
}