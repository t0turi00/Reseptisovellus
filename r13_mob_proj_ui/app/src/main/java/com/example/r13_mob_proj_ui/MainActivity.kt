package com.example.r13_mob_proj_ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.r13_mob_proj_ui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageButton.setOnClickListener {
            startAc1()
        }
        binding.imageButton2.setOnClickListener {
            startAc2()
        }
        binding.imageButton3.setOnClickListener {
            startAc3()
        }
        binding.imageButton4.setOnClickListener {
            startAc4()
        }
        binding.buAdd.setOnClickListener {
            startAdder()
        }
    }
    fun startAc1() {
        val intent = Intent(this, reseptiview2::class.java)
        startActivity(intent)
    }
    fun startAc2() {
        val intent = Intent(this, reseptiview::class.java)
        startActivity(intent)
    }
    fun startAc3() {
        val intent = Intent(this, reseptiview3::class.java)
        startActivity(intent)
    }
    fun startAc4() {
        val intent = Intent(this, reseptiview4::class.java)
        startActivity(intent)
    }
    fun startAdder() {
        val intent = Intent(this, AddDataView::class.java)
        startActivity(intent)
    }
}