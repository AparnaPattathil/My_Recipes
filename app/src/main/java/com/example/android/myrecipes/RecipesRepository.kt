package com.example.android.myrecipes

class RecipesRepository : RecipeInterface {
    private val recipes: MutableList<Recipe> = mutableListOf()

    override suspend fun fetchAllRecipes(): List<Recipe> {
        return recipes
    }

    override suspend fun storeRecipe(recipe: Recipe) {
        recipes.add(recipe)
    }
}