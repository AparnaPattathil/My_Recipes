package com.example.android.myrecipes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

class AllRecipesViewModel(private val repository: RecipesRepository) : ViewModel() {

    private lateinit var job: Job

    private val _recipes = MutableLiveData<List<Recipe>>()

    val recipes: LiveData<List<Recipe>>
        get() = _recipes

    fun fetchAllRecipes() {
        job = Coroutines.ioThenMain(
            { repository.fetchAllRecipes() },
            {
                _recipes.value = it
            }
        )
    }



    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}