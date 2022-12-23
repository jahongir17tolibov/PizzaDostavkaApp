package com.jt17.bottomnavtest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jt17.bottomnavtest.R
import com.jt17.bottomnavtest.databinding.AddOrdersItemBinding
import com.jt17.bottomnavtest.fragment.FavouritesFragment
import com.jt17.bottomnavtest.models.MenuModel

class FavouritesAdapter : RecyclerView.Adapter<FavouritesAdapter.ItemHolder>() {

    inner class ItemHolder(val b: AddOrdersItemBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(result: MenuModel, pos: Int) {
            b.fvName.text = result.title
            b.fvPrice.text = result.price
            b.fvImg.setImageResource(result.img ?: R.drawable.ic_launcher_background)

            b.deleteBtn.setOnClickListener {
                removeAt(pos)
            }
        }
    }

    var baseList: ArrayList<MenuModel> = arrayListOf()

//    private val subAdapter by lazy { FavouritesAdapter() }

    fun newList(list: ArrayList<MenuModel>) {
        baseList = list
        notifyDataSetChanged()
    }

    fun removeAt(pos: Int) {
        baseList.removeAt(pos)
//        notifyItemRemoved(pos)
        notifyDataSetChanged()
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

        holder.bind(itemData, position)

    }

    override fun getItemCount(): Int = baseList.size
}