package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.list

interface RepoItemView: IItemView {
    fun setName(text: String)
    fun setDescription(text: String)
}