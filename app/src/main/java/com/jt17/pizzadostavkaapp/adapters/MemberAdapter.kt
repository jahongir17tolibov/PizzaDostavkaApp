package com.jt17.pizzadostavkaapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jt17.pizzadostavkaapp.databinding.PizzaMenuItemBinding
import com.jt17.pizzadostavkaapp.models.Result

class MemberAdapter(val list: List<com.jt17.pizzadostavkaapp.models.Result.Member>, val itemCallback: itemCallback) :
    RecyclerView.Adapter<MemberAdapter.ItemHolder>() {

    inner class ItemHolder(val bind: PizzaMenuItemBinding) : RecyclerView.ViewHolder(bind.root) {
        fun binder(result: com.jt17.pizzadostavkaapp.models.Result.Member) {
            bind.pizzasImg.setImageResource(result.image)
            bind.namePizz.text = result.title
            bind.infoPizz.text = result.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            PizzaMenuItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val itemData = list[position]
        holder.binder(itemData)

        holder.itemView.setOnClickListener {
            itemCallback.putBottomSheet(itemData)
        }
    } 

    override fun getItemCount(): Int = list.size

}


interface itemCallback {
    fun putBottomSheet(itemData: Result.Member)
}