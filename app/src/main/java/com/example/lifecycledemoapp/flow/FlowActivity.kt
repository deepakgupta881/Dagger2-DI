package com.example.lifecycledemoapp.flow

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.lifecycledemoapp.R
import com.example.lifecycledemoapp.coroutines.CoroutineActivity
import com.example.lifecycledemoapp.livedataviewmodel.LiveDataViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.*
import java.util.*

class FlowActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "FlowActivity"
    }

    val viewModel: LiveDataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val btn: Button = findViewById(R.id.button)
        val btn2: Button = findViewById(R.id.button2)
        btn.setOnClickListener {

CoroutineScope(IO).launch {
    viewModel.incrementCounter(Random().nextInt(100) + 1)

}
/*
            lifecycleScope.launch {
                lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    sendNumbers().collect {
//                        delay(100)
                        withContext(Main) {
                            btn.text = it.toString()
                        }
                        Log.e(TAG, "$it")
                    }
                }
            }
*/


        }
/*
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.sharedFlow.collect {
                    delay(200)
                    withContext(Main) {
                        btn2.text = it.toString()
                    }
                    Log.e(TAG, "$it")
                }
            }
        }
*/


        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.stateFlow.collect {
                    delay(1000)
                    withContext(Main) {
                        btn.text = it.toString()
                    }
                    Log.e(TAG, "$it")
                }
            }
        }

    }


    fun numbers() = flowOf<Int>(1, 2, 3, 4, 5)

    // flow builders
    fun getNumber() = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).asFlow()


    // normal flow  - cold stream
    fun sendNumbers(): Flow<Int> = flow<Int> {
        val list = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        list.forEach {
//            kotlinx.coroutines.delay(it * 200L)
            emit(it)
            delay(1000)
//            emit(it*100)
            // it will not print until there is any subscriber
            Log.e(TAG, "in func $it")
        }
    }.buffer()
//        .filter { it % 3 == 0 }.map { it * 10 }
//        .flatMapMerge { getNumber() }
//        .transform { emit("emitting $it") }
//        .onCompletion { emit("completed") }


}