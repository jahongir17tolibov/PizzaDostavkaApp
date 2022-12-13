package com.jt17.bottomnavtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jt17.bottomnavtest.databinding.ActivityMainBinding
import com.jt17.bottomnavtest.fragment.FavouritesFragment
import com.jt17.bottomnavtest.fragment.MenuFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeFormat(MenuFragment())

        binding.bottomNav.setOnItemSelectedListener{

            when(it.itemId) {
                R.id.menu_id -> {
                    changeFormat(MenuFragment())
                }
                R.id.favouriites -> {
                    changeFormat(FavouritesFragment())
                }
            }
            true
        }
    }

    private fun changeFormat(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.Main_framer, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}