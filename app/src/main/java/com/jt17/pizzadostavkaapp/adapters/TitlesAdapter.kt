package com.jt17.pizzadostavkaapp.adapters

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jt17.pizzadostavkaapp.databinding.TopItemLyBinding
import com.jt17.pizzadostavkaapp.models.ChildModel

class TitlesAdapter(val list: List<ChildModel>, val itemCallBackTitleAdapter: itemCallBackTitleAdapter) : RecyclerView.Adapter<TitlesAdapter.ItemHolder>() {

    inner class ItemHolder(val bind: TopItemLyBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            TopItemLyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val itemTitle = list[position]
        holder.bind.menuTxt.run {
            this.text = itemTitle.str
            this.backgroundTintList = ColorStateList.valueOf(Color.WHITE)
            this.setTextColor(Color.YELLOW)
        }

        holder.itemView.setOnClickListener {
            itemTitle.clickPosition = !itemTitle.clickPosition
            whenOnClickChangeTitlesColor(holder.bind.menuTxt, itemTitle.clickPosition)
            itemCallBackTitleAdapter.itemClickListener(position, holder.itemView)
        }
    }

    override fun getItemCount(): Int = list.size


    private fun whenOnClickChangeTitlesColor(textview: TextView, position: Boolean) {
        textview.run {
            if (position) {
                this.backgroundTintList = ColorStateList.valueOf(Color.YELLOW)
                this.setTextColor(Color.WHITE)
            } else {
                this.backgroundTintList = ColorStateList.valueOf(Color.WHITE)
                this.setTextColor(Color.YELLOW)
            }
        }
    }
}

interface itemCallBackTitleAdapter {
    fun itemClickListener(position: Int, view: View)
}