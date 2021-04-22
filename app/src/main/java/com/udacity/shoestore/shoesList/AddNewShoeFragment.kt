package com.udacity.shoestore.shoesList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentAddNewShoeBinding
import com.udacity.shoestore.models.Shoe

class AddNewShoeFragment : Fragment() {

    private val sharedViewModel: ShoesListSharedViewModel by activityViewModels()
    private lateinit var binding: FragmentAddNewShoeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = FragmentAddNewShoeBinding.inflate(inflater, container, false)

        binding.shoesListSharedViewModel = sharedViewModel
        sharedViewModel.createNewShoeObject()

        sharedViewModel.eventCloseScreen.observe(viewLifecycleOwner, Observer { close ->
            close?.let {
                if (it) {
                    findNavController().navigateUp()
                    sharedViewModel.onEventCloseComplete()
                }
            }
        })


        return binding.root
    }
}