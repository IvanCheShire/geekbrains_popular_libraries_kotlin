package ru.geekbrains.geekbrains_popular_libraries_kotlin.di

import dagger.Component
import ru.geekbrains.geekbrains_popular_libraries_kotlin.di.modules.*
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.MainPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.RepositoryPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.UserPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.UsersPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.activity.MainActivity
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.adapter.UsersRVAdapter
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AppModule::class,
    ApiModule::class,
    NavigationModule::class,
    CacheModule::class,
    RepoModule::class,
    ImageLoaderModule::class
])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(usersPresenter: UsersPresenter)
    fun inject(currentUserPresenter: UserPresenter)
    fun inject(repositoryPresenter: RepositoryPresenter)
    fun inject(usersRvAdapter: UsersRVAdapter)
}