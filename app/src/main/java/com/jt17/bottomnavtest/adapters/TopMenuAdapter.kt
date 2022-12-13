package com.jt17.bottomnavtest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jt17.bottomnavtest.databinding.TopItemLyBinding

class TopMenuAdapter(val list: List<TopList>) : RecyclerView.Adapter<TopMenuAdapter.itemHolder>() {

    inner class itemHolder(val bind: TopItemLyBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemHolder {
        return itemHolder(
            TopItemLyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: itemHolder, position: Int) {
        val itemData = list[position]

        holder.bind.menuTxt.text = itemData.str

    }

    override fun getItemCount(): Int = list.size

}

data class TopList(
    val str: String
)