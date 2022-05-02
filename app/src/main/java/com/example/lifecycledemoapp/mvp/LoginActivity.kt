package com.example.lifecycledemoapp.mvp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lifecycledemoapp.R

class LoginActivity : AppCompatActivity(), LoginContractor.View {

    lateinit var loginPresenter: LoginPresenter
    override fun success() {
        Toast.makeText(this, "Wooo valid credentials", Toast.LENGTH_SHORT).show()

    }

    override fun error(errorMsg: String) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        loginPresenter = LoginPresenter(this)
        val btn = findViewById<Button>(R.id.button).setOnClickListener {
            loginPresenter.login("admin@gmail.com","123")
        }


    }

}