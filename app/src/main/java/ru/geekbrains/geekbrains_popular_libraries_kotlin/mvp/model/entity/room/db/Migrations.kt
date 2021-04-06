package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.room.db

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE RoomGithubRepository ADD COLUMN htmlUrl TEXT NOT NULL DEFAULT('')")
    }
}

val MIGRATION_3_4 = object : Migration(3, 4) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("CREATE TABLE IF NOT EXISTS `RoomCachedImage` (`url` TEXT NOT NULL, `path` TEXT NOT NULL, PRIMARY KEY(`url`))")
    }
}