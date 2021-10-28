package com.efedaniel.vestiaireweather.presentation.common

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import com.efedaniel.vestiaireweather.R
import com.efedaniel.vestiaireweather.presentation.common.customviews.DetailsCardView

@BindingAdapter("coilImage")
fun ImageView.loadCoilImage(url: String?) {
    url?.let {
        load(it) {
            crossfade(true)
            transformations(RoundedCornersTransformation(16F))
            placeholder(R.color.placeholder)
        }
    }
}

@BindingAdapter(
    requireAll = false,
    value = ["visible", "occupying"]
)
fun setVisibility(view: View, visible: Boolean, occupying: Boolean = false) {

    // Load resource based on occupying state.
    val res = when (occupying) {
        true -> View.INVISIBLE
        false -> View.GONE
    }

    // Update view visibility.
    view.visibility = if (visible) View.VISIBLE else res
}

@BindingAdapter("metricValue")
fun DetailsCardView.setMetricValueAdapter(value: String) {
    setMetricValue(value)
}
