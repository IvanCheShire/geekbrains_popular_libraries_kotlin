package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter

import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.CountersModel
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.MainView

class MainPresenter(val mainView: MainView) {
    val model = CountersModel()

    fun counterClick(id: Int){
        when(id){
            model.btn_counter1 -> {
                val nextValue = model.next(0)
                mainView.setButtonText(0, nextValue.toString())
            }
            model.btn_counter2 -> {
                val nextValue = model.next(1)
                mainView.setButtonText(1, nextValue.toString())
            }
            model.btn_counter3 -> {
                val nextValue = model.next(2)
                mainView.setButtonText(2, nextValue.toString())
            }
        }
    }
}