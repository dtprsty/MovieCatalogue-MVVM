package com.prsty.moviecatalogue.ui.movie


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.prsty.moviecatalogue.R
import com.prsty.moviecatalogue.data.MovieEntity
import com.prsty.moviecatalogue.ui.DataViewModel
import com.prsty.moviecatalogue.ui.adapter.RVAdapter
import com.prsty.moviecatalogue.ui.detail.DetailActivity
import com.prsty.moviecatalogue.utils.calc
import kotlinx.android.synthetic.main.fragment_movie.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.support.v4.startActivity

/**
 * A simple [Fragment] subclass.
 *
 */
class MovieFragment : Fragment(), RVAdapter.RVAdapterListener, AnkoLogger{

    override fun OnItemClick(model: MovieEntity) {
        startActivity<DetailActivity>("extra_item" to model)
    }

    private lateinit var viewModel: DataViewModel
    private var data: MutableList<MovieEntity> = mutableListOf()
    private lateinit var adapter: RVAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DataViewModel::class.java)
        data = viewModel.getData(true)

        rv_data.setLayoutManager(
            GridLayoutManager(
                context, calc(context!!)
            )
        )
        adapter = RVAdapter(data, this)
        rv_data.adapter = adapter

    }


}
