package com.example.test_app

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class TestActivity2: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layuot_test2)
    }

    fun onClickClose(view: View) {
        finish()
    }
}