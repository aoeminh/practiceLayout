package com.example.myapplication.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R

class MessageFragment : BaseFragment() {

    companion object{
        fun  newInstance(): Fragment{
            var fragment = MessageFragment()
            val bundle = Bundle()
            bundle.putString("test","Top")
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_message,container,false)
        return view
    }



}