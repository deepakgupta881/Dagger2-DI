package com.example.lifecycledemoapp.design

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lifecycledemoapp.R

class DesignPatternActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        Log.e("DesignPatternActivity", "onCreate: ")

        val btn: Button = findViewById(R.id.button)
        val btn2: Button = findViewById(R.id.button2)

//        btn.text = Singleton.toString()

        // give same instance always  - check by decompiling the bytecode
//        btn2.text = Singleton.toString()


        btn2.setOnClickListener {
//         btn.text=   DialogFactory.createDialog(DialogType.DIALOG_MESSAGE).toString()
            val user=UserBuilder.Builder().age(20).build()
            btn.text=user.age.toString()

        }


    }






}