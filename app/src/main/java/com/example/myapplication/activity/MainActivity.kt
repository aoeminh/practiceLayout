package com.example.myapplication.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.fragment.MessageFragment
import com.example.myapplication.fragment.NotificationFragment
import com.example.myapplication.fragment.TimelineFragment
import com.example.myapplication.fragment.TopFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBottomMenu();
    }

    fun initBottomMenu(){
        bot_navi_main.selectedItemId = R.id.item_top
        loadFragment(TopFragment.newInstance())
        bot_navi_main.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.item_top -> {
                    loadFragment(TopFragment.newInstance())
                }
                R.id.item_message -> loadFragment(MessageFragment.newInstance())
                R.id.item_noti-> loadFragment(NotificationFragment.newInstance())
                R.id.item_timeline -> loadFragment(TimelineFragment.newInstance())

            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    fun loadFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main,fragment)
        transaction.commit()
    }
}
