package com.udacity.shoestore.shoesList

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesListBinding

class ShoesListFragment : Fragment() {

    private val sharedViewModel: ShoesListSharedViewModel by activityViewModels()

    private lateinit var binding: FragmentShoesListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

       binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_list, container, false)


        binding.floatingButtonAddNewModel.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoesListFragment_to_addNewShoeFragment)
        )
        return binding.root
    }


}

