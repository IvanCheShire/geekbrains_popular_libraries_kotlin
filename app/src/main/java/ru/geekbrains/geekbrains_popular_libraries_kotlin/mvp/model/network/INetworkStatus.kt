package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.network


import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface INetworkStatus {
    fun isOnline(): Observable<Boolean>
    fun inOnlineSingle(): Single<Boolean>
}