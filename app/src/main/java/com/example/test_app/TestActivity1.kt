package com.example.test_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TestActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test1)
    }

    fun onClickGoMain(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}