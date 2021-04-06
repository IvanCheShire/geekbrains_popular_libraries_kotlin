package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.room.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.room.RoomCachedImage
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.room.RoomGithubRepository
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.room.RoomGithubUser
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.room.dao.CachedImageDao
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.room.dao.RepositoryDao
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.room.dao.UserDao

@androidx.room.Database(entities = [RoomGithubUser::class, RoomGithubRepository::class, RoomCachedImage::class], version = 4)
abstract class Database : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val repositoryDao: RepositoryDao
    abstract val cachedImageDao: CachedImageDao

    companion object {
        const val DB_NAME = "database.db"
        private var instance: Database? = null

    }

}