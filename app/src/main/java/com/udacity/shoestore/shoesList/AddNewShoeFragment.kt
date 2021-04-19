package com.udacity.shoestore.shoesList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentAddNewShoeBinding

class AddNewShoeFragment : Fragment() {

    private val viewModel: ShoesListSharedViewModel by activityViewModels()
    private lateinit var binding: FragmentAddNewShoeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_new_shoe, container, false)

        binding.buttonAddNewShoes.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_addNewShoeFragment_to_shoesListFragment)
        )

        return binding.root
    }

}