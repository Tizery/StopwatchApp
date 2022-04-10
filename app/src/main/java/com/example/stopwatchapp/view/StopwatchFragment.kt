package com.example.stopwatchapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.stopwatchapp.app
import com.example.stopwatchapp.databinding.FragmentStopwatchBinding
import com.example.stopwatchapp.viewmodel.StopwatchViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

class StopwatchFragment : Fragment() {

    private var _binding: FragmentStopwatchBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: StopwatchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStopwatchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, app.stopwatchViewModelFactory)
            .get(StopwatchViewModel::class.java)

        setListeners()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.ticker.collect {
                    binding.textTime.text = it
                }
            }
        }
    }

    private fun setListeners() {
        binding.buttonStart.setOnClickListener {
            viewModel.onStartClicked()
        }
        binding.buttonPause.setOnClickListener {
            viewModel.onPauseClicked()
        }
        binding.buttonStop.setOnClickListener {
            viewModel.onStopClicked()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}