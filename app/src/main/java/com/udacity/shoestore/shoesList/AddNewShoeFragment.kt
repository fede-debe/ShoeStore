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

class AddNewShoeFragment : Fragment() {

    private val sharedViewModel: ShoesListSharedViewModel by activityViewModels()

    private lateinit var binding: FragmentAddNewShoeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_new_shoe, container, false)


        sharedViewModel.name.observe(viewLifecycleOwner, Observer { newName ->
            binding.shoesName.setText(newName)
        })

        sharedViewModel.size.observe(viewLifecycleOwner, Observer{ newSize ->
            binding.shoesSize.setText(newSize)
        })

        sharedViewModel.company.observe(viewLifecycleOwner, Observer { newCompany ->
            binding.shoesCompany.setText(newCompany)
        })

        sharedViewModel.description.observe(viewLifecycleOwner, Observer { newDescription ->
            binding.shoesDescription.setText(newDescription)
        })

        binding.buttonAddNewShoes.setOnClickListener{

            sharedViewModel.addNewShoeToWarehouse(
                binding.shoesName.text.toString(),
                binding.shoesSize.text.toString(),
                binding.shoesCompany.text.toString(),
                binding.shoesDescription.text.toString())

            findNavController().navigate(AddNewShoeFragmentDirections.actionAddNewShoeFragmentToShoesListFragment())
        }

        return binding.root
    }

}