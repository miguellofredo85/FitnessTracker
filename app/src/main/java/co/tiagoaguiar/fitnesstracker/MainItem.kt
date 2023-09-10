package co.tiagoaguiar.fitnesstracker

import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MainItem(
    val id: Int,
    @StringRes val textId: Int,
    @DrawableRes val drawable: Int,
    val color: Int
)
