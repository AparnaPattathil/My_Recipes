package com.example.android.myrecipes

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.all_recipes_fragment.*

class AllRecipesFragment : Fragment() {

    private lateinit var factory: AllRecipesViewModelFactory
    private lateinit var viewModel: AllRecipesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.add_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_add -> {
            view!!.findNavController().navigate(R.id.action_allRecipesFragment_to_addRecipeFragment)
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}
