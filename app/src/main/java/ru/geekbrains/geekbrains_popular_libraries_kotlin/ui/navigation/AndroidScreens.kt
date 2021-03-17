package ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.navigation.IScreens

import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.fragment.NewFragment
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.fragment.UsersFragment

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }

    override fun users(GithubUser user) = FragmentScreen { NewFragment.newInstance()}//Не поняла, каким образом передать из презентера user
}