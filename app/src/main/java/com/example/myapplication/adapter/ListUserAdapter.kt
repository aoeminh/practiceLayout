package com.example.myapplication.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.fragment.TopFragment
import com.example.myapplication.model.User
import kotlinx.android.synthetic.main.item_list_user_grid.view.*
import kotlinx.android.synthetic.main.item_list_user_main.view.*


class ListUserAdapter(var context: Context?, var listUser: MutableList<User>, var listType: Int) :
    RecyclerView.Adapter<ListUserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        if (listType == TopFragment.TYPE_LIST) {
            val view = LayoutInflater.from(context)
                .inflate(R.layout.item_list_user_main, parent, false)
            Log.d("MinhNQ","TYPE_LIST")
            return LinnearViewHolder(view)
        } else if (listType == TopFragment.TYPE_GRID) {
            val view = LayoutInflater.from(context)
                .inflate(R.layout.item_list_user_grid, parent, false)
            Log.d("MinhNQ","TYPE_GRID")
            return GridViewHolder(view)
        } else {
            val view = LayoutInflater.from(context)
                .inflate(R.layout.item_list_user_main, parent, false)
            Log.d("MinhNQ","else")
            return LinnearViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        if (viewHolder is LinnearViewHolder) {
            var lnViewHolder = viewHolder
            lnViewHolder.itemView.tv_name_item_list_top?.text = listUser[position].name
        } else if (viewHolder is GridViewHolder) {
            var gridViewHolder = viewHolder as GridViewHolder
        }

    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    fun setType(type: Int){
        this.listType = type
        notifyDataSetChanged()
    }

    open class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        open var imgAvatar: ImageView? = null

    }

    class LinnearViewHolder(item: View) : ViewHolder(item) {
        var tvName: TextView? = null
    }

    class GridViewHolder(item: View) : ViewHolder(item) {

    }


}