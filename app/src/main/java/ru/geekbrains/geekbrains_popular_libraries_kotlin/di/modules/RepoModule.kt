package ru.geekbrains.geekbrains_popular_libraries_kotlin.di.modules

import dagger.Module
import dagger.Provides
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.api.IDataSource
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.cache.IGithubUserReposCache
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.cache.IGithubUsersCache
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.network.INetworkStatus
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo.IGithubUserReposRepo
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo.IGithubUsersRepo
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo.RetrofitGithubUserReposRepo
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo.RetrofitGithubUsersRepo
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun usersRepo(api: IDataSource, cache: IGithubUsersCache, networkStatus: INetworkStatus): IGithubUsersRepo = RetrofitGithubUsersRepo(api, networkStatus, cache)

    @Singleton
    @Provides
    fun userReposRepo(api: IDataSource, networkStatus: INetworkStatus, cache: IGithubUserReposCache): IGithubUserReposRepo = RetrofitGithubUserReposRepo(api, networkStatus, cache)
}