package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.cache

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpAppCompatActivity
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.room.RoomCachedImage
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.room.db.Database
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

class RoomImageCache(val db: Database, val context: Context) : IImageCache{

    override fun getImageBytes(url: String): Single<ByteArray> {
        return Single.fromCallable {
            val path = db.cachedImageDao.getImageByUrl(url).path
            val bitmap = BitmapFactory.decodeFile(path)
            convertToByteArray(bitmap)
        }.subscribeOn(Schedulers.io())
    }

    override fun putImage(url: String, bytes: ByteArray?): Completable {
        return Completable.fromCallable {
            //here save to file
            bytes?.let {
                val path = saveImageToFile(bytes, context)
                val image = RoomCachedImage(url, path)
                db.cachedImageDao.insert(image)
            }
        }.subscribeOn(Schedulers.io())
    }

    fun saveImageToFile(imageByteArray: ByteArray, context: Context): String {
        val wrapper = ContextWrapper(context)
        val file = wrapper.getDir("Img", MvpAppCompatActivity.MODE_PRIVATE)
        val savingFile = File(file, "${UUID.randomUUID()}.png")
        val fos = FileOutputStream(savingFile)
        fos.write(imageByteArray)
        fos.flush()
        fos.close()
        val path = savingFile.absolutePath
        return path
    }


    fun convertToByteArray(imageBitmap: Bitmap): ByteArray {
        val out = ByteArrayOutputStream()
        try {
            imageBitmap?.compress(Bitmap.CompressFormat.PNG, 100, out)
            out.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return out.toByteArray()
    }
}