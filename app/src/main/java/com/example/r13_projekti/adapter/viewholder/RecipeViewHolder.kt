package com.example.r13_projekti.adapter.viewholder

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.r13_projekti.R
import com.example.r13_projekti.model.Recipe

class RecipeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val nameText: TextView = itemView.findViewById(R.id.nameText)
    private val priceText: TextView = itemView.findViewById(R.id.priceText)
    private val descriptionText: TextView = itemView.findViewById(R.id.descriptionText)
    private val createDateText: TextView = itemView.findViewById(R.id.createDateText)
    private val updateDateText: TextView = itemView.findViewById(R.id.updateDateText)

    fun bindItem(recipe: Recipe) {
        itemView.apply {
            nameText.text = recipe.name
            priceText.text = recipe.price.toString()
            descriptionText.text = recipe.description
            createDateText.text = recipe.create_date!!.toDate().toString()

            if (recipe.update_date != null) {
                updateDateText.text = recipe.update_date!!.toDate().toString()
            }
        }
    }
}