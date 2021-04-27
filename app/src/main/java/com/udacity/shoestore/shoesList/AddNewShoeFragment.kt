package com.udacity.shoestore.shoesList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentAddNewShoeBinding

class AddNewShoeFragment : Fragment() {

    private val sharedViewModel: ShoesListSharedViewModel by activityViewModels()
    private lateinit var binding: FragmentAddNewShoeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = FragmentAddNewShoeBinding.inflate(inflater, container, false)

        binding.shoesListSharedViewModel = sharedViewModel
        sharedViewModel.createNewShoeObject()

        sharedViewModel.eventCloseScreen.observe(viewLifecycleOwner, { close ->
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