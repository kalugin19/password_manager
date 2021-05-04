package com.kalugin19.passstore.view.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.NavAction
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import com.google.android.material.textfield.TextInputLayout
import com.kalugin19.passstore.R
import com.kalugin19.passstore.databinding.FragmentAddRecordBinding
import com.kalugin19.passstore.util.passgenerator.inflater
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AddRecordFragment : Fragment() {

    @Inject
    lateinit var navController: NavController

    @Inject
    lateinit var viewModel: AddRecordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAddRecordBinding.inflate(requireContext().inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.closeScreen.observe(viewLifecycleOwner) {
            navController.popBackStack()
        }
        return binding.root
    }

    companion object {
        const val RECORD_ID = "recordId"
    }
}