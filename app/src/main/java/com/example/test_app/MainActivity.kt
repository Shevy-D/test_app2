package com.example.test_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.test_app.constance.Constance
import com.example.test_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    private var login: String = "empty"
    private var password: String = "empty"
    private var name: String = "empty"
    private var lastName: String = "empty"
    private var secondName: String = "empty"
    private var avatarImageId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == Constance.REQUEST_CODE_SIGN_IN){

            val l = data?.getStringExtra(Constance.LOGIN)
            val p = data?.getStringExtra(Constance.PASSWORD)
            if (login == l && password == p){

                bindingClass.imAvatar.visibility = View.VISIBLE
                bindingClass.imAvatar.setImageResource(avatarImageId)
                val textInfo = "$name $lastName $secondName"
                bindingClass.tvInfo.text = textInfo
                bindingClass.bHide.visibility = View.GONE
                bindingClass.bExit.text = "Выйти"
            } else {
                bindingClass.imAvatar.visibility = View.VISIBLE
                bindingClass.imAvatar.setImageResource(R.drawable.ic_launcher_background)
                bindingClass.tvInfo.text = "Такого аккаунта не существует"
            }

        } else if (requestCode == Constance.REQUEST_CODE_SIGN_UP){

            login = data?.getStringExtra(Constance.LOGIN)!!
            password = data.getStringExtra(Constance.PASSWORD)!!
            name = data.getStringExtra(Constance.NAME)!!
            lastName = data.getStringExtra(Constance.LAST_NAME)!!
            secondName = data.getStringExtra(Constance.SECOND_NAME)!!
            avatarImageId = data.getIntExtra(Constance.AVATAR_ID, 0)
            bindingClass.imAvatar.visibility = View.VISIBLE
            bindingClass.imAvatar.setImageResource(avatarImageId)
            val textInfo = "$name $lastName $secondName"
            bindingClass.tvInfo.text = textInfo
            bindingClass.bHide.visibility = View.GONE
            bindingClass.bExit.text = "Выйти"

        }
    }

    fun onClickSignIn(view: View){

        if (bindingClass.imAvatar.isVisible && bindingClass.tvInfo.text.toString() != "Такого аккаунта не существует"){
            bindingClass.imAvatar.visibility = View.INVISIBLE
            bindingClass.tvInfo.text = ""
            bindingClass.bHide.visibility = View.VISIBLE
            bindingClass.bExit.text = getString(R.string.sign_in)

        } else {
            val intent = Intent(this, SignInUpActivity::class.java)
            intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN_STATE)
            startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_IN)
        }

    }

    fun onClickSignUp(view: View){

        val intent = Intent(this, SignInUpActivity::class.java)
        intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_UP_STATE)
        startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_UP)

    }
}