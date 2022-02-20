package com.example.test_app

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.test_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.btResult.setOnClickListener {
            Log.d("testlog", "ID picture = ${R.drawable.ic_launcher_background}")
            val resultValue = bindingClass.edValue.text.toString()
            bindingClass.imPhoto.visibility = View.VISIBLE
            Log.d("testlog", "Result = $resultValue")
            when(resultValue){
                Constance.DIRECTOR -> {
                    bindingClass.tvResult.visibility = View.VISIBLE
                    val tempText = "Получите ваши ${Constance.DIRECTOR_SALARY}"
                    if (bindingClass.edPassword.text.toString() == Constance.DIRECTOR_PASSWORD){
                        bindingClass.tvResult.text = tempText
                        bindingClass.imPhoto.setImageResource(R.drawable.first)
                    } else {
                        bindingClass.imPhoto.visibility = View.VISIBLE
                        bindingClass.tvResult.text = "Неверный пароль"
                        bindingClass.imPhoto.setImageResource(R.drawable.ic_launcher_background)
                    }
                }

                Constance.ENGINEER -> {
                    bindingClass.tvResult.visibility = View.VISIBLE
                    val tempText = "Получите ваши ${Constance.ENGINEER_SALARY}"
                    if (bindingClass.edPassword.text.toString() == Constance.ENGINEER_PASSWORD){
                        bindingClass.tvResult.text = tempText
                        bindingClass.imPhoto.setImageResource(R.drawable.second)
                    } else {
                        bindingClass.imPhoto.visibility = View.VISIBLE
                        bindingClass.tvResult.text = "Неверный пароль"
                        bindingClass.imPhoto.setImageResource(R.drawable.ic_launcher_background)
                    }
                }

                Constance.CLEANER -> {
                    bindingClass.tvResult.visibility = View.VISIBLE
                    val tempText = "Получите ваши ${Constance.CLEANER_SALARY}"
                    if (bindingClass.edPassword.text.toString() == Constance.CLEANER_PASSWORD){
                        bindingClass.tvResult.text = tempText
                        bindingClass.imPhoto.setImageResource(R.drawable.third)
                    } else {
                        bindingClass.imPhoto.visibility = View.VISIBLE
                        bindingClass.tvResult.text = "Неверный пароль"
                        bindingClass.imPhoto.setImageResource(R.drawable.ic_launcher_background)
                    }
                }
                else -> {
                    bindingClass.imPhoto.visibility = View.VISIBLE
                    bindingClass.tvResult.visibility = View.VISIBLE
                    bindingClass.tvResult.text = "Нет такого работника"
                    bindingClass.imPhoto.setImageResource(R.drawable.ic_launcher_background)
                }
            }
        }


    }
}