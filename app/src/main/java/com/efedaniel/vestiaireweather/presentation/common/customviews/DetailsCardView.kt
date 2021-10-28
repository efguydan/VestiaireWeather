package com.efedaniel.vestiaireweather.presentation.common.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.withStyledAttributes
import com.efedaniel.vestiaireweather.R
import com.google.android.material.card.MaterialCardView

/**
 * A compound View to abstract the cards on the Weather Details Fragment for easier
 * reuse
 */
class DetailsCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.custom_details_card, this)

        context.withStyledAttributes(attrs, R.styleable.DetailsCardView) {
            findViewById<TextView>(R.id.metricLabelTextView).text =
                getString(R.styleable.DetailsCardView_metricText)
            findViewById<ImageView>(R.id.metricImageView)
                .setImageDrawable(getDrawable(R.styleable.DetailsCardView_metricImage))
        }
    }

    /**
     * Exposed method to set the value of the metric
     */
    fun setMetricValue(value: String) {
        findViewById<TextView>(R.id.metricValueTextView).text = value
    }
}
