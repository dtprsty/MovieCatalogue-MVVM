package com.prsty.moviecatalogue.utils

import android.content.Context

fun calc(context: Context): Int {
    val displayMetrics = context.resources.displayMetrics
    val dpWidth = displayMetrics.widthPixels / displayMetrics.density
    return (dpWidth / 180).toInt()
}