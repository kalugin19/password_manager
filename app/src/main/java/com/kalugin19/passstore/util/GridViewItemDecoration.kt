package com.kalugin19.passstore.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GridViewItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (parent.layoutManager is GridLayoutManager) {

            val spanCount = (parent.layoutManager as GridLayoutManager).spanCount
            val childPosition = parent.getChildLayoutPosition(view)
            val padding = 30

            outRect.left = when (childPosition % spanCount) {
                0 -> padding
                else -> padding / 2
            }

            outRect.right = padding / 2
            outRect.bottom = padding / 2


            outRect.top = when (parent.getChildLayoutPosition(view)) {
                in 0 until spanCount -> padding
                else -> 0
            }
        }

    }

}