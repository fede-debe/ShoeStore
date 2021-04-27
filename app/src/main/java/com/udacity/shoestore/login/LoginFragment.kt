package com.udacity.shoestore.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.loginButton.setOnClickListener{

            if (binding.enterUsernameText.text!!.isNotEmpty() && binding.enterPasswordText.text!!.isNotEmpty()){
                val username = binding.enterUsernameText.text.toString()
                val action = LoginFragmentDirections.actionLoginFragmentToInstructionFragment(username)
                findNavController().navigate(action)
            }else {
                Toast.makeText(context, "Enter Username and Password", Toast.LENGTH_SHORT).show()
            }
        }

        binding.signUpButton.setOnClickListener {
            if (binding.enterUsernameText.text!!.isNotEmpty() && binding.enterPasswordText.text!!.isNotEmpty()){
                val username = binding.enterUsernameText.text.toString()
                val action = LoginFragmentDirections.actionLoginFragmentToInstructionFragment(username)
                findNavController().navigate(action)
            }else{
                Toast.makeText(context, "Enter Username and Password", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}