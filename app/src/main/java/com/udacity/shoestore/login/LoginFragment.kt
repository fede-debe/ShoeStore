package com.udacity.shoestore.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import timber.log.Timber

class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)


        binding.loginButton.setOnClickListener{

            if (binding.enterEmailText.text!!.isNotEmpty() && binding.enterPasswordText.text!!.isNotEmpty()){
                val username = binding.enterEmailText.text.toString()
                val action = LoginFragmentDirections.actionLoginFragmentToInstructionFragment(username)
                findNavController().navigate(action)
            }else {
                Toast.makeText(context, "Enter Email and Password", Toast.LENGTH_SHORT).show()
            }
        }

        binding.signUpButton.setOnClickListener {
            if (binding.enterEmailText.text!!.isNotEmpty() && binding.enterPasswordText.text!!.isNotEmpty()){
                val username = binding.enterEmailText.text.toString()
                val action = LoginFragmentDirections.actionLoginFragmentToInstructionFragment(username)
                findNavController().navigate(action)
            }else{
                Toast.makeText(context, "Enter Email and Password", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}