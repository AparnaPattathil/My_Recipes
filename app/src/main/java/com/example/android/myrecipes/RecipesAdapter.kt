package com.example.android.myrecipes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.myrecipes.databinding.RecipeDetailsItemBinding

class RecipesAdapter(private val recipes: List<Recipe>) :
    RecyclerView.Adapter<RecipesAdapter.RecipesViewHolder>() {

    override fun getItemCount(): Int = recipes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RecipesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recipe_details_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        holder.recipeDetailsItemBinding.recipe = recipes[position]
    }

    inner class RecipesViewHolder(
        val recipeDetailsItemBinding: RecipeDetailsItemBinding
    ) : RecyclerView.ViewHolder(recipeDetailsItemBinding.root){
    }
}