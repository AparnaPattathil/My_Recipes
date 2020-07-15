package com.example.android.myrecipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class AllRecipesFragment : Fragment() {

    private lateinit var factory: AllRecipesViewModelFactory
    private lateinit var viewModel: AllRecipesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.all_recipes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val repository = RecipesRepository()
        factory = AllRecipesViewModelFactory(repository)
        viewModel = ViewModelProvider(this).get(AllRecipesViewModel::class.java)
    }
}