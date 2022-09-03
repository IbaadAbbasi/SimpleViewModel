package com.example.simpleviewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleviewmodel.databinding.ItemsBinding

class DataAdapter(private val list: List <DataModel>):
    RecyclerView.Adapter<DataAdapter.Data>() {

    inner class Data(val binding:ItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DataModel){
            binding.listItem=item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Data {
      val inflater =LayoutInflater.from(parent.context)
        val item = ItemsBinding.inflate(inflater,parent,false)
        return Data(item)
    }

    override fun onBindViewHolder(holder: Data, position: Int) {
         holder.bind(list[position])
    }

    override fun getItemCount(): Int {
      return  list.size
    }
}