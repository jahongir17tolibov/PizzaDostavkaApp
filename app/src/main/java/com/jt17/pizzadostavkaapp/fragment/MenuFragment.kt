package com.jt17.pizzadostavkaapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.ahmadhamwi.tabsync.TabbedListMediator
import com.google.android.material.tabs.TabLayout
import com.jt17.pizzadostavkaapp.ModalBottomSheet
import com.jt17.pizzadostavkaapp.R
import com.jt17.pizzadostavkaapp.adapters.*
import com.jt17.pizzadostavkaapp.databinding.FragmentMenuBinding
import com.jt17.pizzadostavkaapp.models.Result

class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    lateinit var recylerview: RecyclerView
    lateinit var tabLayout: TabLayout

    private var menuList = mutableListOf<com.jt17.pizzadostavkaapp.models.Result>()
    private var menuSubList = mutableListOf<com.jt17.pizzadostavkaapp.models.Result.Member>()
    private var tabTitleList = listOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.parentRecyclerView.layoutManager = LinearLayoutManager(requireContext())
//
//
//
//        binding.parentRecyclerView.adapter = MenuAdapter(mylist)
//
//        binding.titleLayout.layoutManager =
//            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//
//        binding.titleLayout.adapter = TopMenuAdapter(menulist)

//        val snapHelper = LinearSnapHelper()
//        snapHelper.attachToRecyclerView(binding.titleLayout)

        initViews()
        initLists()
        initTabLayout()
        initRecyc()
        initMediator()

    }

    private fun initMediator() {
        TabbedListMediator(
            recylerview,
            tabLayout,
            tabTitleList.indices.toList(),
            true
        ).attach()
    }

    private fun initLists() {
        for (i in 1..6) {
            menuSubList.add(
                com.jt17.pizzadostavkaapp.models.Result.Member(
                    R.drawable.ic_launcher_background,
                    "Menu Title $i",
                    "descripton$i"
                )
            )
        }
        for (i in 1..4) {
            menuList.add(Result("Menu title $i", menuSubList))
        }
        tabTitleList = menuList.map { it.title }
    }

    private fun initViews() {
        recylerview = binding.parentRecyclerView
        tabLayout = binding.tabLayout
    }

    private fun initTabLayout() {
        tabTitleList.forEachIndexed { index, name ->
            tabLayout.addTab(tabLayout.newTab().setText(name))

            val textview =
                LayoutInflater.from(requireContext()).inflate(R.layout.tab_title, null) as TextView
            tabLayout.getTabAt(index)?.customView = textview
        }
    }

    private fun initRecyc() {

        recylerview.adapter = MenuAdapter(menuList, object : itemCallback {

            override fun putBottomSheet(itemData: Result.Member) {
                val modalBottomSheet = ModalBottomSheet(itemData)
                modalBottomSheet.show(
                    requireActivity().supportFragmentManager,
                    ModalBottomSheet.TAG
                )

            }
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}