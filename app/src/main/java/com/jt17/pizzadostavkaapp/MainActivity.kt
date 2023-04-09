package com.jt17.pizzadostavkaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.jt17.pizzadostavkaapp.databinding.ActivityMainBinding
import com.jt17.pizzadostavkaapp.fragment.DiscountFragment
import com.jt17.pizzadostavkaapp.fragment.FavouritesFragment
import com.jt17.pizzadostavkaapp.fragment.MenuFragment
import com.jt17.pizzadostavkaapp.fragment.ProfileFragment

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
                R.id.discount -> {
                    changeFormat(DiscountFragment())
                }
                R.id.favouriites -> {
                    changeFormat(FavouritesFragment())
                }
                R.id.profile -> {
                    changeFormat(ProfileFragment())
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