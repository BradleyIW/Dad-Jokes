package com.bradley.wilson.jokes.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import com.bradley.wilson.jokes.R
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val homeViewModel by viewModel<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeRandomJoke()
        observeErrors()
    }

    private fun observeErrors() {

    }

    private fun observeRandomJoke() {
        homeViewModel.randomDadJokeLiveData.observe(viewLifecycleOwner) {
            homeFragmentRandomJokeTextView.text = it
        }
        lifecycleScope.launchWhenResumed {
            homeViewModel.getRandomDadJoke()
        }
    }

}