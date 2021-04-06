package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.navigation.IScreens
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.MainView
import ru.geekbrains.geekbrains_popular_libraries_kotlin.rxlearn.Creation
import ru.geekbrains.geekbrains_popular_libraries_kotlin.rxlearn.Operators
import javax.inject.Inject

class MainPresenter(): MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router

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
