package com.example.lifecycledemoapp.livedataviewmodel

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecycledemoapp.R
import java.util.*

class LiveDataActivity : AppCompatActivity() {

    val viewModel: LiveDataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        val btn: Button = findViewById(R.id.button)
        btn.setOnClickListener {
            viewModel.setCount(Random().nextInt(100) + 1)
        }

        viewModel.count.observe(this) {
//            btn.text = it.toString()

            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()

        }


        viewModel.newValue.observe(this) {
            btn.text = it.toString()
        }

    }





    class MyAdapter(val context: Context) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_first,parent,false))
        }

        override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        }

        override fun getItemCount(): Int {
            return 0
        }


    }


}