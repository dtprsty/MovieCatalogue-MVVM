package com.prsty.moviecatalogue.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.prsty.moviecatalogue.R
import com.prsty.moviecatalogue.ui.adapter.ViewPagerAdapter
import com.prsty.moviecatalogue.ui.movie.MovieFragment
import com.prsty.moviecatalogue.ui.tv_show.TVShowFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        vp_main.setPagingEnabled(true)
        vp_main.offscreenPageLimit = 3
        setUpViewPager(vp_main)
        tab_main.setupWithViewPager(vp_main)
    }

    private fun setUpViewPager(viewPager: ViewPager){
        viewPagerAdapter.addFragment(MovieFragment(), "Movie")
        viewPagerAdapter.addFragment(TVShowFragment(), "TV Show")
        viewPager.adapter = viewPagerAdapter

    }
}
