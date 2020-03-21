package com.bradley.wilson.jokes.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.bradley.wilson.jokes.R
import com.bradley.wilson.jokes.core.extension.empty
import com.bradley.wilson.jokes.core.extension.withArgs
import org.koin.android.viewmodel.ext.android.viewModel

class SearchResultsFragment : Fragment(R.layout.fragment_search_results) {

    private val searchViewModel: SearchViewModel by viewModel()

    private val searchTerm by lazy {
        arguments?.getString(SEARCH_QUERY_BUNDLE_KEY) ?: String.empty()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeSearchData()
    }

    private fun observeSearchData() {
        searchViewModel.searchResultsLiveData.observe(viewLifecycleOwner) {
            //Update list here
        }
        searchViewModel.onSearchQueryEntered(searchTerm)
    }

    companion object {
        private const val SEARCH_QUERY_BUNDLE_KEY = "searchQueryBundleKey"

        fun newInstance(searchQuery: String) =
            SearchResultsFragment().withArgs {
                putString(SEARCH_QUERY_BUNDLE_KEY, searchQuery)
            }
    }
}