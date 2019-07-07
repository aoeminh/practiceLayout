package com.example.myapplication.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.model.User

enum class ListType {
    LINNEAR, GRID
}

class ListUserAdapter(var context: Context?, var listUser: MutableList<User>, var listType: ListType) :
    RecyclerView.Adapter<ListUserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        if (listType == ListType.LINNEAR) {
            val view = LayoutInflater.from(context)
                .inflate(R.layout.item_list_user_main, parent, false)
            return LinnearViewHolder(view)
        } else if (listType == ListType.GRID) {
            val view = LayoutInflater.from(context)
                .inflate(R.layout.item_list_user_grid, parent, false)
            return GridViewHolder(view)
        } else {
            val view = LayoutInflater.from(context)
                .inflate(R.layout.item_list_user_main, parent, false)
            return LinnearViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        if (viewHolder is LinnearViewHolder) {
            var lnViewHolder = viewHolder as LinnearViewHolder
            lnViewHolder.imgAvatar?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ava_user))
            lnViewHolder.tvName?.text = listUser[position].name
        } else if (viewHolder is GridViewHolder) {
            var gridViewHolder = viewHolder as GridViewHolder
            gridViewHolder.imgAvatar?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ava_user))
        }

    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
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