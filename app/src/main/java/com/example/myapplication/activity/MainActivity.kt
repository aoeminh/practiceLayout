package com.example.myapplication.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.Fragment
import android.view.View
import android.widget.RelativeLayout
import com.example.myapplication.R
import com.example.myapplication.behavior.BottomNavigationBehavior
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
        val layoutParamBotNavigation =  bot_navi_main.layoutParams as CoordinatorLayout.LayoutParams
        layoutParamBotNavigation.behavior = BottomNavigationBehavior()
        bot_navi_main.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.item_top -> {
                    loadFragment(TopFragment.newInstance())
                    showFab()
                }
                R.id.item_message -> {
                    hideFab()
                    loadFragment(MessageFragment.newInstance())
                }
                R.id.item_noti->{
                    hideFab()
                    loadFragment(NotificationFragment.newInstance())
                }
                R.id.item_timeline ->{
                    hideFab()
                    loadFragment(TimelineFragment.newInstance())
                }

            }
            return@setOnNavigationItemSelectedListener true
        }


    }

    fun hideFab(){
        if(fab.visibility == View.VISIBLE){
            fab?.hide()
        }

    }

    fun showFab(){
        if(fab.visibility == View.INVISIBLE || fab.visibility == View.GONE){
            fab?.show()

        }
    }

    fun loadFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main,fragment)
        transaction.commit()
    }
}
