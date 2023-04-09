package com.jt17.pizzadostavkaapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jt17.pizzadostavkaapp.databinding.FavFragmentItemBinding
import com.jt17.pizzadostavkaapp.models.FavAllModel
import kotlinx.android.synthetic.main.fav_fragment_item.view.*

class FavAllAdapter : RecyclerView.Adapter<FavAllAdapter.ItemHolder>() {

    private val subFavAdapter by lazy { FavouritesAdapter() }
    private val subRecAdapter by lazy { ReccomAdapter() }

    inner class ItemHolder(val b: FavFragmentItemBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(result: FavAllModel) {
            b.favoriteListRec.run {
                layoutManager = LinearLayoutManager(b.root.context)

                edgeEffectFactory = BounceEdgeEffectFactory()

                adapter = subFavAdapter
            }

            b.recommendRec.run {
                layoutManager = LinearLayoutManager(b.root.context)

                adapter = subRecAdapter
            }
            subFavAdapter.newList(result.menuMList)
            subRecAdapter.newList(result.baseRecList)
        }
    }

    var baseList: ArrayList<FavAllModel> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun newList(list: ArrayList<FavAllModel>) {
        baseList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            FavFragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val itemData = baseList[position]


        holder.bind(itemData)

//        removeItembySwipe(holder.b.root.context,holder.itemView.favorite_list_rec)

    }

//    private fun removeItembySwipe(context: Context, recyclerView: RecyclerView) {
//        val swipeHelper = object : SwipeToDelete(context) {
//            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                subFavAdapter.removeAt(viewHolder.adapterPosition)
//            }
//        }
//        val itemTouchHelper = ItemTouchHelper(swipeHelper)
//        itemTouchHelper.attachToRecyclerView(recyclerView)
//    }

    override fun getItemCount(): Int = baseList.size

}