package com.example.android.myrecipes

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController

class AddRecipeFragment : Fragment() {

    private lateinit var factory: AddRecipesViewModelFactory
    private lateinit var viewModel: AddRecipesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_recipe, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val repository = RecipesRepository()
        factory = AddRecipesViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(AddRecipesViewModel::class.java)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.save_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_save -> {
            view!!.findNavController()
                .navigate(R.id.action_addRecipeFragment_to_allRecipesFragment)
            viewModel.storeRecipe()

            true
        }
        else -> super.onOptionsItemSelected(item)
    }

}