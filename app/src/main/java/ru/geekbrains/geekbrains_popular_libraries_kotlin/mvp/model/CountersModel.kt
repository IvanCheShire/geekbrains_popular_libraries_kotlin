package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model

class CountersModel {

    val counters = mutableListOf(0, 0, 0)

    fun getCurrent(index: Int) = counters[index]

    fun next(index: Int): Int {
        counters[index]++
        return getCurrent(index)
    }
    val btn_counter1 = 1000037;
    val btn_counter2 = 1000036;
    val btn_counter3 = 1000041;

}