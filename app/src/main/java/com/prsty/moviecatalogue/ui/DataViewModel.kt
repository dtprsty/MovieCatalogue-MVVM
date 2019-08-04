package com.prsty.moviecatalogue.ui

import androidx.lifecycle.ViewModel
import com.prsty.moviecatalogue.data.MovieEntity
import com.prsty.moviecatalogue.utils.generateDummyMovies
import com.prsty.moviecatalogue.utils.generateDummyTvShows

class DataViewModel : ViewModel() {

    fun getData(isMovie: Boolean = true): MutableList<MovieEntity> {

        if(isMovie){
            return generateDummyMovies()
        }else {
            return generateDummyTvShows()
        }
    }
}