package com.example.r13_mob_proj_ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.r13_mob_proj_ui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.imageButton2.setOnClickListener {
            startAc()
        }
    }
    fun startAc() {
        val intent = Intent(this, reseptiview::class.java)
        startActivity(intent)
    }
}