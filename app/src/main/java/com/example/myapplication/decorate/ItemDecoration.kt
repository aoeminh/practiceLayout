package com.example.myapplication.decorate

import android.support.v7.widget.RecyclerView
import android.R.attr.bottom
import android.R.attr.right
import android.R.attr.left
import android.R.attr.top
import android.content.Context
import android.graphics.Rect
import android.support.annotation.DimenRes
import android.view.View


class ItemDecoration(context: Context, @DimenRes itemOffsetId: Int): RecyclerView.ItemDecoration() {

    var mItemOffset = 0
    init {
        mItemOffset = context.resources.getDimensionPixelSize(itemOffsetId)
    }

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset)
    }
}