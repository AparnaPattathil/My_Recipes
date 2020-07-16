package com.example.android.myrecipes

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

class AddRecipesViewModel(private val repository: RecipesRepository) : ViewModel() {
    private lateinit var job: Job

    var recipeName: String = ""
    var recipeDescription: String = ""


    fun storeRecipe() {
        job = Coroutines.ioThenMain(
            { repository.storeRecipe(Recipe(recipeName, recipeDescription)) },
            {
                Recipe(recipeName, recipeDescription)
            }
        )
    }
}
