package com.jt17.bottomnavtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.jt17.bottomnavtest.databinding.BottomSheetBinding
import com.jt17.bottomnavtest.models.Result

class ModalBottomSheet(val itemData: Result.Member) : BottomSheetDialogFragment() {
    private var _binding: BottomSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BottomSheetBinding.inflate(inflater, container, false)
    return binding.root
    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemData.also {
            binding.imageView.setImageResource(it.image)
            binding.textView.text = it.description
            binding.pizzaName.text = it.title
        }
    }
}