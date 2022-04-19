package com.example.r13_projekti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.r13_projekti.adapter.RecipeAdapter
import com.example.r13_projekti.model.Recipe
import com.example.r13_projekti.viewmodel.RecipeViewModel
import com.google.firebase.Timestamp

class MainActivity : AppCompatActivity(), RecipeAdapter.OnItemClickListener {

    private lateinit var name: EditText
    private lateinit var price: EditText
    private lateinit var description: EditText
    private lateinit var submit: Button
    private lateinit var rvList: RecyclerView

    private lateinit var recipeAdapter: RecipeAdapter
    private lateinit var list: ArrayList<Recipe>

    private var selected: Recipe = Recipe()

    private val recipeViewModel: RecipeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initElement()
        initViewModel()
    }

    private fun initElement() {
        name = findViewById(R.id.name)
        price = findViewById(R.id.price)
        description = findViewById(R.id.description)
        submit = findViewById(R.id.submit)
        rvList = findViewById(R.id.rvList)

        list = ArrayList()

        submit.setOnClickListener {
            create()
        }

        // Get list
        recipeViewModel.getList()

    }

    private fun initViewModel() {
        recipeViewModel.createLiveData.observe(this, {
            onCreate(it)
        })

        recipeViewModel.updateLiveData.observe(this, {
            onUpdate(it)
        })

        recipeViewModel.deleteLiveData.observe(this, {
            onDelete(it)
        })

        recipeViewModel.getListLiveData.observe(this, {
            onGetList(it)
        })
    }

    private fun onCreate(it: Boolean) {
        if (it) {
            recipeViewModel.getList()
            resetText()
        }
    }

    private fun onUpdate(it: Boolean) {
        if (it) {
            recipeViewModel.getList()
            resetText()
        }
    }

    private fun onDelete(it: Boolean) {
        if (it) {
            recipeViewModel.getList()
            resetText()
        }
    }

    private fun onGetList(it: List<Recipe>) {
        list = ArrayList()
        list.addAll(it)

        recipeAdapter = RecipeAdapter(list, this)

        rvList.adapter = recipeAdapter
        rvList.layoutManager = LinearLayoutManager(baseContext)

        recipeAdapter.notifyDataSetChanged()
    }

    private fun create() {
        val recipe = Recipe(
            selected.id,
            name.text.toString(),
            price.text.toString().toDouble(),
            description.text.toString(),
            selected.create_date ?: Timestamp.now(),
            selected.update_date
        )
        if (recipe.id != null) {
            recipeViewModel.update(recipe)
        } else {
            recipeViewModel.create(recipe)
        }
    }

    private fun resetText() {
        selected = Recipe()

        name.text = null
        price.text = null
        description.text = null
    }

    override fun onClick(item: Recipe, position: Int) {
        selected = item
        selected.update_date = Timestamp.now()

        name.setText(selected.name)
        price.setText(selected.price.toString())
        description.setText(selected.description)
    }

    override fun onDelete(item: Recipe, position: Int) {
        recipeViewModel.delete(item.id!!)
    }
}