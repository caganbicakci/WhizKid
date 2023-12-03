package com.caganbicakci.whizkid.domain.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class LearningItemDecoration(private val margin: Int) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {

        if (parent.getChildLayoutPosition(view) % 2 == 0) {
            outRect.left = margin
            outRect.bottom = margin
            outRect.top = margin
        } else {
            outRect.left = margin
            outRect.right = margin
            outRect.bottom = margin
            outRect.top = margin
        }
    }
}