package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo

import io.reactivex.rxjava3.schedulers.Schedulers
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.api.IDataSource

class RetrofitGithubUserReposRepo(val api: IDataSource) : IGithubUserReposRepo {

    override fun getUserRepos(url: String) = api.getUserRepos(url).subscribeOn(Schedulers.io())

}