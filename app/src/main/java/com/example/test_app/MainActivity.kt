package com.example.test_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    val lostArray = arrayOf(10000, 2300, 45000, 65000, 6500, 400)
    val earnArray = arrayOf(15000, 300, 345000, 5000, 16500, 3400)
    val resultArray = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val names = resources.getStringArray(R.array.names)

        for ((index, name) in names.withIndex()){

            resultArray.add("Имя: $name | прибыль = ${earnArray[index] - lostArray[index]}")
            Log.d("MyLog", "Статистика -/- ${resultArray[index]}")
        }
    }

}