package com.example.android.myrecipes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AllRecipesViewModel(private val repository: RecipesRepository) : ViewModel() {

    private val _recipes = MutableLiveData<List<Recipe>>()

    val recipes: LiveData<List<Recipe>>
        get() = _recipes

    suspend fun fetchAllRecipes() {
        val recipes = repository.fetchAllRecipes()
        _recipes.value = recipes
    }
}