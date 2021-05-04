package com.kalugin19.passstore.view.records

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.kalugin19.passstore.databinding.FragmentRecordsBinding
import com.kalugin19.passstore.util.passgenerator.inflater
import com.kalugin19.passstore.view.records.adapter.RecordsAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class RecordsFragment : Fragment() {

    @Inject
    lateinit var recordsViewModel: RecordsViewModel

    @Inject
    lateinit var navigator: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentRecordsBinding.inflate(requireContext().inflater, container, false)
            .apply {
                lifecycleOwner = this@RecordsFragment
                viewModel = recordsViewModel
                navController = navigator
            }
            .root
    }

}