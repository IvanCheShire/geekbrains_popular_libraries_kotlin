package ru.geekbrains.geekbrains_popular_libraries_kotlin.di.modules

import androidx.room.Room
import androidx.room.Room.*
import dagger.Module
import dagger.Provides
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.cache.IGithubUserReposCache
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.cache.IGithubUsersCache
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.room.db.Database
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.App
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.cache.RoomGithubUserReposCache
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.cache.RoomGithubUsersCache
import javax.inject.Singleton

@Module
class CacheModule {

    @Singleton
    @Provides
    fun database(app: App): Database = databaseBuilder(app, Database::class.java, Database.DB_NAME).build()

    @Singleton
    @Provides
    fun usersCache(database: Database): IGithubUsersCache = RoomGithubUsersCache(database)

    fun userReposCache(database: Database): IGithubUserReposCache = RoomGithubUserReposCache(database)

    @Singleton
    @Provides
    fun imageCache(database: Database, app: App): IImageCache = RoomImageCache(database, app)

}


}