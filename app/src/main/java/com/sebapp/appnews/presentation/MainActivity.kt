package com.sebapp.appnews.presentation

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import appnews.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 *   16,junio,2022
 *
 * Created by
 *           Sebastian Pratto (Misiones, Arg.)
 */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setWindowStyle()

    }

    /** Set window style */

    private fun setWindowStyle() {

        val window = getWindow()
        window.statusBarColor = Color.TRANSPARENT
        window.navigationBarColor = Color.TRANSPARENT

        if(android.os.Build.VERSION.SDK_INT > 29){
            window.setDecorFitsSystemWindows(false)
        }else{
            window.addFlags(WindowManager.LayoutParams.FIRST_SYSTEM_WINDOW)
        }

    }

}