package com.jt17.pizzadostavkaapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jt17.pizzadostavkaapp.databinding.ReccomItemBinding
import com.jt17.pizzadostavkaapp.models.BasedReccomModel

class ReccomAdapter : RecyclerView.Adapter<ReccomAdapter.ItemHolder>() {

    private val subAdapter by lazy { ReccomSubAdapter() }

    inner class ItemHolder(val b: ReccomItemBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(result: BasedReccomModel) {
            b.reccomTitle.text = result.favTitle

            b.reccomRecyc.run {
                layoutManager =
                    LinearLayoutManager(b.root.context, LinearLayoutManager.HORIZONTAL, false)
                adapter = subAdapter
            }
            subAdapter.newList(result.faavlist)
        }
    }

    var baseList: List<BasedReccomModel> = emptyList()

    fun newList(list: List<BasedReccomModel>) {
        baseList = list
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            ReccomItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val itemData = baseList[position]
        holder.bind(itemData)
    }

    override fun getItemCount(): Int = baseList.size

}