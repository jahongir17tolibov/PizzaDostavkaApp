package com.jt17.bottomnavtest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jt17.bottomnavtest.R
import com.jt17.bottomnavtest.databinding.AddOrdersItemBinding
import com.jt17.bottomnavtest.fragment.FavouritesFragment
import com.jt17.bottomnavtest.models.MenuModel

class FavouritesAdapter : RecyclerView.Adapter<FavouritesAdapter.ItemHolder>() {

    inner class ItemHolder(val b: AddOrdersItemBinding) : RecyclerView.ViewHolder(b.root)

    var baseList: ArrayList<MenuModel> = arrayListOf()

    fun newList(list: ArrayList<MenuModel>) {
        baseList = list
        notifyDataSetChanged()
    }

    fun removeAt(pos: Int) {
        baseList.removeAt(pos)
        notifyItemRemoved(pos)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavouritesAdapter.ItemHolder {
        return ItemHolder(
            AddOrdersItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FavouritesAdapter.ItemHolder, position: Int) {
        val itemData = baseList[position]
        with(itemData) {
            holder.b.fvName.text = title
            holder.b.fvPrice.text = price
            holder.b.fvImg.setImageResource(img?: R.drawable.ic_launcher_background)
        }
    }

    override fun getItemCount(): Int = baseList.size
}