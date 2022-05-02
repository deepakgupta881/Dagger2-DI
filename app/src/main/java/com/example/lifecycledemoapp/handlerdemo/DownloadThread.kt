package com.example.lifecycledemoapp.handlerdemo

import android.annotation.SuppressLint
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.os.Message
import android.util.Log

class DownloadThread(val uiHandler: Handler) : HandlerThread("HandlerTh") {

    override fun onLooperPrepared() {
        super.onLooperPrepared()


        handler = object : Handler(Looper.myLooper()!!) {
            @SuppressLint("HandlerLeak")
            override fun handleMessage(@SuppressLint("HandlerLeak") msg: Message) {
                super.handleMessage(msg)
//                when (msg.what) {
//                    1 -> {
                Log.e("DownloadThread", msg.obj.toString())
                val message2 = Message.obtain()
                message2.arg1 = msg.obj as Int
                uiHandler.sendMessage(message2)

//                    }
//                }
            }


        }


    }

    var handler: Handler? = null
        get() {
            return field
        }
}