package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.room.dao

import androidx.room.*
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.room.RoomCachedImage

@Dao
interface CachedImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(image: RoomCachedImage)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg images: RoomCachedImage)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(images: List<RoomCachedImage>)

    @Update
    fun update(image: RoomCachedImage)

    @Update
    fun update(vararg images: RoomCachedImage)

    @Update
    fun update(images: List<RoomCachedImage>)

    @Delete
    fun delete(image: RoomCachedImage)

    @Delete
    fun delete(vararg images: RoomCachedImage)

    @Delete
    fun delete(images: List<RoomCachedImage>)

    @Query("SELECT * FROM RoomCachedImage")
    fun getAll(): List<RoomCachedImage>

    @Query("SELECT * FROM RoomCachedImage WHERE url = :url ")
    fun getImageByUrl(url: String): RoomCachedImage

}