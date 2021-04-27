package com.udacity.shoestore.shoesList

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.databinding.NewShoesObjectBinding
import com.udacity.shoestore.models.Shoe

class ShoesListFragment : Fragment() {

    private val sharedViewModel: ShoesListSharedViewModel by activityViewModels()
    private lateinit var binding: FragmentShoesListBinding
    private lateinit var shoeBinding: NewShoesObjectBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

       binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_list, container, false)

        sharedViewModel.shoes.observe(viewLifecycleOwner, { items ->
            items?.let {
                displayListOfShoes(it)
            }
        })

        binding.floatingButtonAddNewModel.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoesListFragment_to_addNewShoeFragment)

        )
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun displayListOfShoes(shoes: List<Shoe>) {
         shoes.forEach { displaySingleShoe(it) }
    }

    private fun displaySingleShoe(shoe: Shoe){
        shoeBinding = DataBindingUtil.inflate(layoutInflater, R.layout.new_shoes_object, null, false)

        shoeBinding.apply {
            tvName.text = shoe.name
            tvSize.text = shoe.size
            tvCompany.text = shoe.company
            tvDescription.text = shoe.description
            ibDeleteShoe.setOnClickListener { onDeleteShoe(it, shoe) }

        }
        binding.shoesListLayout.addView(shoeBinding.root)
    }

    private fun onDeleteShoe(view: View, shoe: Shoe) {
        val parentLinearLayout = binding.shoesListLayout
        parentLinearLayout.removeView(view.parent as View)
        sharedViewModel.deleteItem(shoe)
    }
}

