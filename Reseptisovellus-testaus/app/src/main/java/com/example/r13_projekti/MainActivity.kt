package com.example.r13_projekti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.r13_projekti.adapter.RecipeAdapter
import com.example.r13_projekti.databinding.ActivityMainBinding
import com.example.r13_projekti.model.Recipe
import com.example.r13_projekti.viewmodel.RecipeViewModel
import com.google.firebase.Timestamp

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.buAdd.setOnClickListener {
            startAdder()
        }
    }



    private fun startAdder() {
        val intent = Intent(this, ReseptiAdder::class.java)
        startActivity(intent)
    }
}