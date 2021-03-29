package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubRepository

interface IGithubUserReposRepo {
    fun getUserRepos(url: String): Single<List<GithubRepository>>
}