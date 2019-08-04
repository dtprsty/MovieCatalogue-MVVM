package com.prsty.moviecatalogue.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.prsty.moviecatalogue.R
import com.prsty.moviecatalogue.data.MovieEntity
import kotlinx.android.synthetic.main.item_movie.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class RVAdapter(var items: MutableList<MovieEntity> = mutableListOf(), var listener: RVAdapterListener) :
    RecyclerView.Adapter<RVAdapter.RVAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapterViewHolder {
        return RVAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_movie,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RVAdapterViewHolder, position: Int) {
        listener.let { holder.bind(it, items[position]) }
    }

    interface RVAdapterListener {
        fun OnItemClick(model: MovieEntity)
    }

    class RVAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(listener: RVAdapterListener, model: MovieEntity) {

            itemView.txt_movie_name.text = model.movieName
            itemView.txt_year.text = model.releaseDate
            Glide.with(itemView.img_poster.getContext())
                .load(model.imgPoster)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.img_placeholder)
                        .centerCrop()
                )
                .into(itemView.img_poster)
            itemView.card_movie.onClick {
                listener.OnItemClick(model)
            }
        }
    }
}