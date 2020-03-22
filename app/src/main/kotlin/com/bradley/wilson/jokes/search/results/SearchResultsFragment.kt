package com.bradley.wilson.jokes.search.results

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import com.bradley.wilson.jokes.R
import com.bradley.wilson.jokes.core.extension.empty
import com.bradley.wilson.jokes.core.extension.withArgs
import com.bradley.wilson.jokes.search.SearchViewModel
import com.bradley.wilson.jokes.search.results.list.SearchResultRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_search_results.*
import org.koin.android.viewmodel.ext.android.viewModel

class SearchResultsFragment : Fragment(R.layout.fragment_search_results) {

    private val searchViewModel: SearchViewModel by viewModel()

    private val searchResultListAdapter: SearchResultRecyclerAdapter by lazy {
        SearchResultRecyclerAdapter()
    }

    private val searchTerm by lazy {
        arguments?.getString(SEARCH_QUERY_BUNDLE_KEY) ?: String.empty()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialiseSearchList()
        observeSearchData()
    }

    private fun initialiseSearchList() {
        searchResultsFragmentRecyclerView.apply {
            adapter = searchResultListAdapter
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun observeSearchData() {
        searchViewModel.searchResultsLiveData.observe(viewLifecycleOwner) {
            searchResultListAdapter.updateData(it)
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