package com.ronhya.spike.csv.static

import java.util.ArrayList
import java.util.concurrent.TimeUnit.DAYS
import java.util.concurrent.TimeUnit.HOURS
import java.util.concurrent.TimeUnit.MICROSECONDS
import java.util.concurrent.TimeUnit.MILLISECONDS
import java.util.concurrent.TimeUnit.MINUTES
import java.util.concurrent.TimeUnit.NANOSECONDS
import java.util.concurrent.TimeUnit.SECONDS

class TestCode {

    fun test() {
        val myList: ArrayList<String> = arrayListOf("hola")
        var x = DAYS
        x = HOURS
        x = MINUTES
        x = MILLISECONDS
        x = SECONDS
        x = NANOSECONDS
        x = MICROSECONDS
    }

    fun update(
        firstName: String,
        lastName: String,
        country: String,
        age: Int,
        size: Long,
        hobbies: String
    ) {
        println("firstName: $firstName")
    }

    fun add() {
        println("run add")
    }
}
