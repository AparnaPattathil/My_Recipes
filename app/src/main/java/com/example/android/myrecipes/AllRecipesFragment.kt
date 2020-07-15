package com.example.android.myrecipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.all_recipes_fragment.*

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
        viewModel = ViewModelProviders.of(this, factory).get(AllRecipesViewModel::class.java)
        viewModel.fetchAllRecipes()
        viewModel.recipes.observe(viewLifecycleOwner, Observer { recipes ->
            recycler_view_recipes.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = RecipesAdapter(recipes)
            }

        })
    }
}