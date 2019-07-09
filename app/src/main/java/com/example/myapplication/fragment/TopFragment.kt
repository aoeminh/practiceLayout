package com.example.myapplication.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.activity.MainActivity
import com.example.myapplication.adapter.ListUserAdapter
import com.example.myapplication.model.User
import kotlinx.android.synthetic.main.fragment_top.*

class TopFragment : BaseFragment() {

    var text: String? = null
    var mainActivity: MainActivity? = null
    var listAdapter: ListUserAdapter? = null
    var listUser: MutableList<User> = arrayListOf()
    var typeList: Int = 1

    companion object {
        val TYPE_LIST = 1
        val TYPE_GRID = 2

        fun newInstance(): Fragment {
            var fragment = TopFragment()
            val bundle = Bundle()
            bundle.putString("test", "Top")
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }


        if (activity is MainActivity) {
            mainActivity = activity as MainActivity
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_top, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dumpData()
        listAdapter = ListUserAdapter(context, listUser, TYPE_LIST)
        rv_top_fragment.apply {
            layoutManager = LinearLayoutManager(mainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = listAdapter

        }

        img_change_recyclerview_type.setOnClickListener {
            typeList++
            if (typeList > 2) typeList = 1
            listAdapter?.setType(typeList)
        }

    }

    fun dumpData() {
        listUser.add(User("Peter"))
        listUser.add(User("John"))
        listUser.add(User("David"))
        listUser.add(User("Ironman"))
        listUser.add(User("Pick"))
        listUser.add(User("Babylon"))
        listUser.add(User("Persian"))
        listUser.add(User("Shang"))
        listUser.add(User("Choson"))
        listUser.add(User("Cartha"))
        listUser.add(User("Minoan"))
        listUser.add(User("Hittle"))
    }
}