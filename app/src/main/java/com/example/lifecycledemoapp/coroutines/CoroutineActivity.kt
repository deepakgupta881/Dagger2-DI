package com.example.lifecycledemoapp.coroutines

import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.lifecycledemoapp.R
import com.example.lifecycledemoapp.SecondActivity
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

class CoroutineActivity : AppCompatActivity() {

    companion object {
        const val TAG: String = "CoroutineActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val btn: Button = findViewById(R.id.button)
        btn.setOnClickListener {
            requestAPi()
        }


    }

    private fun requestAPi() {
        val job = CoroutineScope(IO).launch {
            val time = measureTimeMillis {

                val result1 = async {
                    getResultFromFirstApi()
                }

//                result1.await()
                val result2 = async {
                    getResultFromSecondApi()
                }

//                result2.await()
                Log.e(TAG, "completed ${result1.await()} ${result2.await()}")

            }

            Log.e(TAG, "completed in $time ${Thread.currentThread().name}")
//            startActivity(Intent(this@CoroutineActivity, SecondActivity::class.java))
        }
//        Thread.sleep(220)
//        startActivity(Intent(this@CoroutineActivity, SecondActivity::class.java))
//        finish()

//        job.cancel()
    }


    private suspend fun getResultFromFirstApi() {
        for (i in 1..50) {
            Log.e(TAG, "$i")
            delay(100)
        }
        delay(2000)
        Log.e(TAG, "first completed")
    }


    private suspend fun getResultFromSecondApi() {
        for (i in 50..100) {
            Log.e(TAG, "$i")
            delay(100)
        }
        delay(2000)
        Log.e(TAG, "second completed")
    }

}