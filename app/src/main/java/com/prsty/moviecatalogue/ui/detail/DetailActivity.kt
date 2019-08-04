package com.prsty.moviecatalogue.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.prsty.moviecatalogue.R
import com.prsty.moviecatalogue.data.MovieEntity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val item = intent.getParcelableExtra<MovieEntity>("extra_item")

        Glide.with(img_poster.getContext())
            .load(item.imgPoster)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.img_placeholder)
                    .centerCrop()
            )
            .into(img_poster)

        txt_movie_name.text = item.movieName
        txt_year.text = item.releaseDate
        txt_overview.text = item.description
        txt_ratings.text = item.rating
        txt_votes.text = item.voter.toString()

    }
}
