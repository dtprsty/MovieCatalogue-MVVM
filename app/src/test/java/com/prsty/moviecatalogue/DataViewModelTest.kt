package com.prsty.moviecatalogue

import com.prsty.moviecatalogue.ui.DataViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test


class DataViewModelTest {
    private var viewModel: DataViewModel? = null

    @Before
    fun setUp() {
        viewModel = DataViewModel()
    }

    @Test
    fun getMovies() {
        val modelEntities = viewModel?.getData(true)
        assertNotNull(modelEntities)
        assertEquals(17, modelEntities?.size)
    }

    @Test
    fun getTvShows() {
        val modelEntities = viewModel?.getData(false)
        assertNotNull(modelEntities)
        assertEquals(20, modelEntities?.size)
    }


    //Jika tanpa menggunakan parameter, harus nya menampilkan data movie
    @Test
    fun getMoviesDefault() {
        val modelEntities = viewModel?.getData()
        assertNotNull(modelEntities)
        assertEquals(17, modelEntities?.size)
    }
}