package com.bradley.wilson.jokes.search

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bradley.wilson.jokes.R
import com.bradley.wilson.jokes.core.extension.empty
import com.bradley.wilson.jokes.core.extension.fragmentTransaction

class SearchResultsActivity : AppCompatActivity(R.layout.activity_search_results) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent?) {
        if (Intent.ACTION_SEARCH == intent?.action) {
            val query = intent.getStringExtra(SearchManager.QUERY) ?: String.empty()
            val fragment = SearchResultsFragment.newInstance(query)
            fragmentTransaction { replace(R.id.activitySearchResultsLayoutContainer, fragment) }
        } else finish()
    }
}
