package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.room.db

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE RoomGithubRepository ADD COLUMN htmlUrl TEXT NOT NULL DEFAULT('')")
    }
}