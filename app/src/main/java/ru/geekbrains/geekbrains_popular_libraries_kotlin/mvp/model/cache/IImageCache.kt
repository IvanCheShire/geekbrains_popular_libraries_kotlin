package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface IImageCache {
    fun getImageBytes(url: String): Single<ByteArray>
    fun putImage(url: String, bytes: ByteArray?): Completable
}