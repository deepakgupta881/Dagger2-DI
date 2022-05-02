package com.example.lifecycledemoapp.daggerDI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lifecycledemoapp.R
import javax.inject.Inject

class DaggerActivity : AppCompatActivity() {

    @Inject
    lateinit var userRegistrationService: UserRegistrationService

    companion object {
        const val TAG: String = "DaggerActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val component =
            DaggerUserComponent.factory().create(55)

        component.inject(this)


//        val emailService=
//            DaggerUserComponent.builder().build()


        userRegistrationService.registerUser("deepak@gmail.com", "123")
        userRegistrationService.sendEmail()
//        emailService.sendEmail("deepak@gmail.com", "123")
    }
}