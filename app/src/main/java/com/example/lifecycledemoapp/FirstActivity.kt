package com.example.lifecycledemoapp

import android.os.*
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lifecycledemoapp.handlerdemo.DownloadThread

class FirstActivity : AppCompatActivity() {

    private val TAG = "FirstActivity"
    var downloadThread: DownloadThread? = null

    var handler: Handler = object : Handler(Looper.getMainLooper()) {

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            btn.setText(msg.obj.toString())

        }
    }

    private val runnable = Runnable {
        for (i in 1..100) {
            Log.e("Handler", i.toString())
            val message = Message.obtain()
            message.obj = i
            Thread.sleep(50)
            handler.sendMessage(message)
        }
    }
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        Log.e(TAG, "onCreate: ")

        btn = findViewById(R.id.button)
        downloadThread = DownloadThread(handler)
        downloadThread?.start()



        btn.setOnClickListener {
//            this.recreate()
//            startActivity(Intent(this, SecondActivity::class.java))


            /*  downloadThread!!.handlerTask!!.post {
           *//* runOnUiThread {
                val message =
                Toast.makeText(
                    this@FirstActivity,
                    "download ${msg} is finished",
                    Toast.LENGTH_SHORT
                ).show()
            }*//*

            downloadThread.handlerTask.o


        }*/


//            val message = Message.obtain()
//            message.what = 1
//            downloadThread!!.handler!!.sendMessage(message)
            downloadThread?.handler?.post(runnable)


        }


    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "onRestart: ")
    }


    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause: ")
    }


    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: ")
    }


}