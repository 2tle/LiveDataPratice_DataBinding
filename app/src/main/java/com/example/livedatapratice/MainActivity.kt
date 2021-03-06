package com.example.livedatapratice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.livedatapratice.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val firstFragment by lazy { FirstFragment() }
    private val secondFragment by lazy { SecondFragment() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        changeFragment(firstFragment)
        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.firstfm -> {
                    changeFragment(firstFragment)
                    true
                }
                R.id.secondfm ->{
                    changeFragment(secondFragment)
                    true
                }
                else -> false
            }
        }
    }


    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fm, fragment).commit()

    }
}
