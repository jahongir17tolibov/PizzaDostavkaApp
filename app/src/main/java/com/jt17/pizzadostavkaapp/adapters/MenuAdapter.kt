package com.jt17.pizzadostavkaapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jt17.pizzadostavkaapp.databinding.ParentPizzaMenuItemBinding
import com.jt17.pizzadostavkaapp.models.Result

class MenuAdapter(val list: List<Result>, val itemCallback: itemCallback) :
    RecyclerView.Adapter<MenuAdapter.itemHolder>() {

    inner class itemHolder(val bind: ParentPizzaMenuItemBinding) :
        RecyclerView.ViewHolder(bind.root) {
        fun binding(result: com.jt17.pizzadostavkaapp.models.Result) {

            val bottm_sh = object : itemCallback {
                override fun putBottomSheet(itemData: Result.Member) {
                    itemCallback.putBottomSheet(itemData)
                }

            }

            bind.parentMenuText.text = result.title
            val subMemadapter = MemberAdapter(result.members, bottm_sh)
            bind.recycMenu.run {
                layoutManager =
                    LinearLayoutManager(bind.root.context, LinearLayoutManager.VERTICAL, false)
                adapter = subMemadapter

                edgeEffectFactory = BounceEdgeEffectFactory()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemHolder {
        return itemHolder(
            ParentPizzaMenuItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: itemHolder, position: Int) {
        val itemData = list[position]
        holder.binding(itemData)

    }

    override fun getItemCount(): Int = list.size

}
