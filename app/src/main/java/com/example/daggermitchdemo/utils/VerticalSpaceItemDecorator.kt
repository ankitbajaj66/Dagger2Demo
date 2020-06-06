package com.example.daggermitchdemo.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 *Created by Ankit Bajaj on 06-06-2020.
 */
class VerticalSpaceItemDecorator(private val verticalSpace: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = verticalSpace
    }
}