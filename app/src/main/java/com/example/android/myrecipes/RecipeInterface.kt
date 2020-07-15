package com.example.android.myrecipes

interface RecipeInterface {

    suspend fun fetchAllRecipes(): List<Recipe>

    suspend fun storeRecipe(recipe: Recipe)
}