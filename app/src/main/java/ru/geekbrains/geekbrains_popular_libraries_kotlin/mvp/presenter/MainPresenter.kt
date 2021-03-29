package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.navigation.IScreens
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.MainView
import ru.geekbrains.geekbrains_popular_libraries_kotlin.rxlearn.Creation
import ru.geekbrains.geekbrains_popular_libraries_kotlin.rxlearn.Operators

class MainPresenter(val router: Router, val screens: IScreens) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())


        //Creation().exec()
        //Operators().exec()
    }

    fun backClicked() {
        router.exit()
    }
}
