package com.example.test_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.test_app.constance.Constance
import com.example.test_app.databinding.ActivitySignUpInBinding

class SignInUpActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivitySignUpInBinding
    private var signState = "empty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySignUpInBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        signState = intent.getStringExtra(Constance.SIGN_STATE)!!
        if (signState == Constance.SIGN_IN_STATE){
            bindingClass.edName.visibility = View.GONE
            bindingClass.edLastName.visibility = View.GONE
            bindingClass.edSecondName.visibility = View.GONE
            bindingClass.bAvatar.visibility = View.INVISIBLE
        }
    }

    fun onClickDone(view: View){
        if (signState == Constance.SIGN_UP_STATE){

            val intent = Intent()
            intent.putExtra(Constance.LOGIN, bindingClass.edLogin.text.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPassword.text.toString())
            intent.putExtra(Constance.NAME, bindingClass.edName.text.toString())
            intent.putExtra(Constance.LAST_NAME, bindingClass.edLastName.text.toString())
            intent.putExtra(Constance.SECOND_NAME, bindingClass.edSecondName.text.toString())
            if (bindingClass.imAvatar2.isVisible) intent.putExtra(Constance.AVATAR_ID, R.drawable.second)
            setResult(RESULT_OK, intent)
            finish()

        }else if ( signState == Constance.SIGN_IN_STATE){

            intent.putExtra(Constance.LOGIN, bindingClass.edLogin.text.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPassword.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    fun onClickAvatar(view: View){

        bindingClass.imAvatar2.visibility = View.VISIBLE
    }

}