package com.sebapp.naranjaxchallenge.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sebapp.naranjaxchallenge.databinding.ActivityMainBinding
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
    }


}