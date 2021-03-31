package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubRepository (
    @Expose val name: String,
    @Expose val description: String?,
    @Expose val id: String? = null,
    @Expose val forksCount: String? = null,
    @Expose val fullName: String? = null,
    @Expose val htmlUrl: String? = null
) : Parcelable