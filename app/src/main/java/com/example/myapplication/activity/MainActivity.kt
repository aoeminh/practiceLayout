package com.example.myapplication.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.Fragment
import android.view.View
import android.widget.RelativeLayout
import com.example.myapplication.behavior.BottomNavigationBehavior
import com.example.myapplication.fragment.MessageFragment
import com.example.myapplication.fragment.NotificationFragment
import com.example.myapplication.fragment.TimelineFragment
import com.example.myapplication.fragment.TopFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_fab.*
import android.animation.Animator
import android.R



class MainActivity : AppCompatActivity() {
    var isFABOpen = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.myapplication.R.layout.activity_main)
        initBottomMenu();

        fab.setOnClickListener {
            if (!isFABOpen) {
                showFABMenu()
            } else {
                closeFABMenu()
            }
        }

//        fabBGLayout.setOnClickListener { closeFABMenu() }
    }

    fun initBottomMenu(){
        bot_navi_main.selectedItemId = com.example.myapplication.R.id.item_top
        loadFragment(TopFragment.newInstance())
        val layoutParamBotNavigation =  bot_navi_main.layoutParams as CoordinatorLayout.LayoutParams
        layoutParamBotNavigation.behavior = BottomNavigationBehavior()
        bot_navi_main.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                com.example.myapplication.R.id.item_top -> {
                    loadFragment(TopFragment.newInstance())
                    showFab()
                }
                com.example.myapplication.R.id.item_message -> {
                    hideFab()
                    loadFragment(MessageFragment.newInstance())
                }
                com.example.myapplication.R.id.item_noti->{
                    hideFab()
                    loadFragment(NotificationFragment.newInstance())
                }
                com.example.myapplication.R.id.item_timeline ->{
                    hideFab()
                    loadFragment(TimelineFragment.newInstance())
                }

            }
            return@setOnNavigationItemSelectedListener true
        }


    }

    private fun showFABMenu() {
        isFABOpen = true

        fab.animate().rotationBy(45F)
        fabLayout1.animate().translationY(-resources.getDimension(com.example.myapplication.R.dimen.standard_55))
        fabLayout2.animate().translationY(-resources.getDimension(com.example.myapplication.R.dimen.standard_100))
        fabLayout3.animate().translationY(-resources.getDimension(com.example.myapplication.R.dimen.standard_145))
        fabLayout1.visibility = View.VISIBLE
        fabLayout2.visibility = View.VISIBLE
        fabLayout3.visibility = View.VISIBLE
    }

     fun closeFABMenu() {
        isFABOpen = false
        fab.animate().rotation(0f)
        fabLayout1.animate().translationY(0f)
        fabLayout2.animate().translationY(0f)
        fabLayout3.animate().translationY(0f)
        fabLayout3.animate().translationY(0f).setListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animator: Animator) {

            }

            override fun onAnimationEnd(animator: Animator) {
                if (!isFABOpen) {
                    fabLayout1.visibility = View.GONE
                    fabLayout2.visibility = View.GONE
                    fabLayout3.visibility = View.GONE
                }
            }

            override fun onAnimationCancel(animator: Animator) {

            }

            override fun onAnimationRepeat(animator: Animator) {

            }
        })
    }

    override fun onBackPressed() {
        if (isFABOpen) {
            closeFABMenu()
        } else {
            super.onBackPressed()
        }
    }

    fun hideFab(){
        if(fab.visibility == View.VISIBLE){
            fab?.hide()
            closeFABMenu()
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
        transaction.replace(com.example.myapplication.R.id.frame_main,fragment)
        transaction.commit()
    }
}
