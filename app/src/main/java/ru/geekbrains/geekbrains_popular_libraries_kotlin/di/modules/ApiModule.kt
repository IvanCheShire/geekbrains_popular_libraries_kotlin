package ru.geekbrains.geekbrains_popular_libraries_kotlin.di.modules

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.api.IDataSource
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.network.INetworkStatus
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.App
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.network.AndroidNetworkStatus
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


@Module
class ApiModule {

    @Named("baseUrl")
    @Provides
    fun baseUrl() = "https://api.github.com"

    @Singleton
    @Provides
    fun api(@Named("baseUrl") baseUrl: String, gson: Gson, client: OkHttpClient): IDataSource = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(IDataSource::class.java)

    @Singleton
    @Provides
    fun gson() = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .excludeFieldsWithoutExposeAnnotation()
        .create()

    @Singleton
    @Provides
    fun client() = OkHttpClient.Builder()
        .callTimeout(30, TimeUnit.SECONDS)
        .addNetworkInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.HEADERS })
        .build()

    @Singleton
    @Provides
    fun networkStatus(app: App): INetworkStatus = AndroidNetworkStatus(app)

}