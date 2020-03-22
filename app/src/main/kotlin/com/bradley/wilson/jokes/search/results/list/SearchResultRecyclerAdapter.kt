package com.bradley.wilson.jokes.search.results.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bradley.wilson.jokes.R
import com.bradley.wilson.jokes.home.DadJokeItem
import kotlinx.android.synthetic.main.item_view_dad_joke.view.*

class SearchResultRecyclerAdapter : RecyclerView.Adapter<SearchResultListViewHolder>() {

    private var searchItems: List<DadJokeItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultListViewHolder =
        SearchResultListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_view_dad_joke,
                parent,
                false
            )
        )

    override fun getItemCount() = searchItems.size

    override fun onBindViewHolder(holder: SearchResultListViewHolder, position: Int) {
        val dadJoke = searchItems[position]
        val title = "Joke #${position + 1} out of $itemCount"
        holder.bind(dadJoke, title)
    }

    fun updateData(updatedSearch: List<DadJokeItem>) {
        searchItems = updatedSearch
        notifyDataSetChanged()
    }
}

class SearchResultListViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(
        dadJokeItem: DadJokeItem,
        title: String
    ) {
        with(itemView) {
            itemViewJokeItemTitleTextView.text = title
            itemViewJokeItemJokeTextView.text = dadJokeItem.joke
        }
    }
}