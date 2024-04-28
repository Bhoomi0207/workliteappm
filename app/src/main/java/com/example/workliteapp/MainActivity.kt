package com.example.workliteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // Set the initial fragment
        setCurrentFragment(HomeFragment())

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> setCurrentFragment(HomeFragment())
                R.id.nav_gift -> setCurrentFragment(rFragment())
                R.id.nav_add -> setCurrentFragment(cardFragment())
                R.id.nav_pay -> setCurrentFragment(PayFragment())
                R.id.nav_profile -> setCurrentFragment(ProfileFragment())
             //   R.id.nav_complain -> setCurrentFragment(ComplaintFragment())
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
            commit()
        }
    }
}
