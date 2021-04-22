package com.udacity.shoestore.shoesList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.databinding.NewShoesObjectBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

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
        return binding.root
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
            ibDeleteShoe.setOnClickListener { onDeleteShoe(it) }

        }
        binding.shoesListLayout.addView(shoeBinding.root)

    }

    private fun onDeleteShoe(view: View) {
        val parentLinearLayout = binding.shoesListLayout
        parentLinearLayout.removeView(view.parent as View)
    }




}

