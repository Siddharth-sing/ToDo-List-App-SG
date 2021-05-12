package com.example.todolistinkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistinkotlin.databinding.ItemTolistBinding

/**
 *   Created by Siddharth Singh Baghel as a Task assigned by Spider G
 **/

class ListAdapter(private val listData: List<ToDoListData>, private val onClick: OnItemClick) :
    RecyclerView.Adapter<ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding: ItemTolistBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_tolist, parent, false)
        return ListViewHolder(binding, onClick)
    }
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindData(listData[position])
    }
    override fun getItemCount(): Int = listData.size

}

class ListViewHolder(val binding: ItemTolistBinding, val onClick: OnItemClick) : RecyclerView.ViewHolder(binding.root),
    View.OnClickListener {
    override fun onClick(view: View?) {
        view?.let {
            onClick.onItemClick(it, adapterPosition)
        }
    }


    fun bindData(toDoListData: ToDoListData) {
        binding.toDoList = toDoListData
        binding.isRead = toDoListData.isShow==1
        binding.root.setOnClickListener(this)
    }
}
