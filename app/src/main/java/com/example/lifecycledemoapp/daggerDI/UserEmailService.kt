package com.example.lifecycledemoapp.daggerDI

import android.util.Log
import javax.inject.Inject

interface NotificationService {
    fun send(to: String, from: String)
}

class EmailService @Inject constructor() : NotificationService {
    override fun send(to: String, from: String) {
        Log.e(DaggerActivity.TAG, "email sent")
    }
}

class SMSService @Inject constructor(val retry:Int) : NotificationService {
    override fun send(to: String, from: String) {
        Log.e(DaggerActivity.TAG, "sms sent $retry")
    }
}