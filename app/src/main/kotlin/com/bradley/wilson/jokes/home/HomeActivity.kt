package com.bradley.wilson.jokes.home

import android.app.SearchManager
import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.bradley.wilson.jokes.R
import com.bradley.wilson.jokes.core.extension.fragmentTransaction
import com.bradley.wilson.jokes.search.SearchResultsActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(R.layout.activity_home) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(activityHomeToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        fragmentTransaction { replace(R.id.activityHomeLayoutContainer, HomeFragment()) }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        // Associate searchable configuration with the SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.toolbarSearchItem).actionView as SearchView).apply {
            setSearchableInfo(
                searchManager.getSearchableInfo(
                    ComponentName(application.applicationContext, SearchResultsActivity::class.java)
                )
            )
        }
        return true
    }
}
