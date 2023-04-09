package com.jt17.pizzadostavkaapp.adapters.tests

import android.view.LayoutInflater
import android.view.ViewGroup
import com.jt17.pizzadostavkaapp.databinding.SlideImgItemBinding
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter(private val baselist: List<Int>) :
    SliderViewAdapter<SliderAdapter.itemHolder>() {
    inner class itemHolder(val bind: SlideImgItemBinding) :
        SliderViewAdapter.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup?): itemHolder {
        return itemHolder(
            SlideImgItemBinding.inflate(
                LayoutInflater.from(parent?.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(viewHolder: itemHolder, position: Int) {
        val itemImage = baselist[position]
        viewHolder.bind.imgSlider.setImageResource(itemImage)
    }

    override fun getCount(): Int = baselist.size
}