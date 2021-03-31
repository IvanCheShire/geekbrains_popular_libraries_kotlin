package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.navigation

import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubRepository
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubUser
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.fragment.RepositoryFragment
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.fragment.UserFragment
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.fragment.UsersFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class UsersScreen() : SupportAppScreen() {
        override fun getFragment() = UsersFragment.newInstance()
    }
    class UserScreen(user: GithubUser): SupportAppScreen() {
        val user = user
        override fun getFragment() = UserFragment.newInstance(user = user)
    }
    class RepositoryScreen(val user: GithubRepository) : SupportAppScreen() {
        override fun getFragment() = RepositoryFragment.newInstance(user)
    }
}
