package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubRepository
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubUser

interface IGithubUserReposCache {
    fun putUserRepos (user: GithubUser, repositories: List<GithubRepository>): Completable
    fun getUserRepos (user: GithubUser): Single<List<GithubRepository>>
}