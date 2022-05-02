package com.example.lifecycledemoapp.daggerDI

import android.util.Log
import javax.inject.Inject
import javax.inject.Named

interface UserRegistrationInterface {
    fun saveUser(email: String, pass: String)
}

class SQLRepository @Inject constructor() : UserRegistrationInterface {
    override fun saveUser(email: String, pass: String) {
        Log.e(DaggerActivity.TAG, "USer saved in sql")
    }
}

class FirebaseRepository
@Inject constructor() : UserRegistrationInterface {
    override fun saveUser(email: String, pass: String) {
        Log.e(DaggerActivity.TAG, "USer saved in firebase")
    }
}