package com.example.myapplication.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.fragment.TopFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bot_navi_main.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.item_top -> {
                    loadFragment(TopFragment.newInstance())
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
    }

    fun loadFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
