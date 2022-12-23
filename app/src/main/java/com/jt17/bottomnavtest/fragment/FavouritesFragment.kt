package com.jt17.bottomnavtest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jt17.bottomnavtest.R
import com.jt17.bottomnavtest.adapters.FavAllAdapter
import com.jt17.bottomnavtest.adapters.FavouritesAdapter
import com.jt17.bottomnavtest.adapters.ReccomAdapter
import com.jt17.bottomnavtest.adapters.SwipeToDelete
import com.jt17.bottomnavtest.databinding.FragmentFavouritesBinding
import com.jt17.bottomnavtest.models.BasedReccomModel
import com.jt17.bottomnavtest.models.FavAllModel
import com.jt17.bottomnavtest.models.MenuModel
import com.jt17.bottomnavtest.viewmodels.BaseViewModel
import kotlinx.android.synthetic.main.fav_fragment_item.view.*
import kotlinx.android.synthetic.main.reccom_item.view.*


class FavouritesFragment : Fragment() {
    private var _binding: FragmentFavouritesBinding? = null
    private val binding get() = _binding!!

    private val falAllAdapter by lazy { FavAllAdapter() }
    private val favoritesAdapter by lazy { FavouritesAdapter() }
    private val reccomAdapter by lazy { ReccomAdapter() }

    private lateinit var baseViewModel: BaseViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavouritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        baseViewModel = ViewModelProvider(requireActivity())[BaseViewModel::class.java]

        initRecycler()
        initDemoRecyclerList()


    }

    private fun initDemoRecyclerList() {
        //create demo menu list
        val menuList = arrayListOf<MenuModel>()
        for (j in 1..9) {
            menuList.add(MenuModel(R.drawable.ic_account, "name $j\nWWW", "more info $j"))
        }
        baseViewModel.responseList.value = menuList

        //create demo recommend list
        val recommendList = arrayListOf<BasedReccomModel>()
        for (i in 1..3) {
            recommendList.add(BasedReccomModel("title $i", menuList))
        }
        val favAllList = arrayListOf<FavAllModel>()
        favAllList.add(FavAllModel(recommendList, menuList))
        //set adapter list
        falAllAdapter.newList(favAllList)

    }

    private fun initRecycler() {

        binding.allRecyc.run {
            layoutManager = LinearLayoutManager(requireContext())

            adapter = falAllAdapter

        }

    }

//    fun removeItembySwipe() {
//        val swipeHelper = object : SwipeToDelete(requireContext()) {
//            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                favoritesAdapter.removeAt(viewHolder.adapterPosition)
//            }
//        }
//        val itemTouchHelper = ItemTouchHelper(swipeHelper)
////        itemTouchHelper.attachToRecyclerView()
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}