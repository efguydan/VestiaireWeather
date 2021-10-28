package com.efedaniel.vestiaireweather.presentation.common.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView

/**
 * Helper method to show a view
 */
fun View.show() {
    visibility = View.VISIBLE
}

/**
 * Helper method to hide a view
 */
fun View.hide() {
    visibility = View.GONE
}

/**
 * Helper method to inflate a Layout file
 */
inline fun <reified T> ViewGroup.inflate(@LayoutRes layoutRes: Int): T {
    return LayoutInflater.from(context).inflate(layoutRes, this, false) as T
}

/**
 * Helper method to monitor changes to a Nested Scroll View's scroll state.
 */
fun NestedScrollView.onScrollChanged(scrollListener: (Int) -> Unit) =
    setOnScrollChangeListener(
        NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->
            scrollListener(scrollY)
        }
    )

/**
 * Helper method to monitor changes to a Recycler View's scroll state.
 */
fun RecyclerView.onScrollChanged(scrollListener: (Int) -> Unit) =
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(
            recyclerView: RecyclerView,
            dx: Int,
            dy: Int
        ) {
            super.onScrolled(recyclerView, dx, dy)
            scrollListener(computeVerticalScrollOffset())
        }
    })

/**
 * Helper method to change the elevation of a view
 */
fun View.invalidateElevation(scrollY: Int) {
    val expectedScrollY = measuredHeight / 2
    val maxElevation = 8f

    var calculatedElevation = (scrollY.toFloat() / expectedScrollY.toFloat()) * maxElevation
    if (calculatedElevation.isNaN()) calculatedElevation = 0f

    elevation = calculatedElevation
        .coerceAtLeast(0f)
        .coerceAtMost(maxElevation)
}
