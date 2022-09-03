package com.example.simpleviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simpleviewmodel.databinding.ActivityMainBinding
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    lateinit var mainActivityViewModel: ViewModel
    lateinit var data:CountValues
    private lateinit var manager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        mainActivityViewModel = ViewModelProvider(this).get(ViewModel::class.java)
        data = CountValues( mainActivityViewModel.getInitialCountA())
        binding.item = data

        binding.btnAdd.setOnClickListener(View.OnClickListener {
            mainActivityViewModel.getCurrentCountA()
            binding.item = data
           data = CountValues(mainActivityViewModel.getInitialCountA())
   })

        manager = LinearLayoutManager(this)
        mainActivityViewModel.getFruitList()?.observe(this, Observer {
            Log.d("TAG",it.size.toString())
            binding.recyclerview.apply {
                adapter = DataAdapter(it)
                layoutManager=manager
            }
        })
    }

}