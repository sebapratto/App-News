package com.sebapp.naranjaxchallenge.presentation.utils

import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat

/**
 *   16,junio,2022
 *
 * Created by
 *           Sebastian Pratto (Misiones, Arg.)
 */

fun Window.changeStatusBarColor(color: Int) {
    this.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    this.statusBarColor = ContextCompat.getColor(context, color)
}