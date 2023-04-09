package com.jt17.pizzadostavkaapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jt17.pizzadostavkaapp.R
import com.jt17.pizzadostavkaapp.databinding.ReccomSubItemBinding
import com.jt17.pizzadostavkaapp.models.MenuModel

class ReccomSubAdapter : RecyclerView.Adapter<ReccomSubAdapter.ItemHolder>() {

    inner class ItemHolder(val b: ReccomSubItemBinding) : RecyclerView.ViewHolder(b.root)
        var baseList: List<MenuModel> = emptyList()

        fun newList(list: List<MenuModel>) {
            baseList = list
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            ReccomSubItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val itemData = baseList[position]

        with(itemData) {
            holder.b.recommendNam.text = title
            holder.b.recommendPriceBtn.text = price
            holder.b.recommendImg.setImageResource(img?: R.drawable.ic_launcher_background)
        }


    }

    override fun getItemCount(): Int = baseList.size

}