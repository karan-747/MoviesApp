package com.example.moviesapp.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentMoviesBinding
import com.example.moviesapp.di.Injector
import com.example.moviesapp.presentation.MoviesVMFactory
import com.example.moviesapp.presentation.MoviesViewModel
import com.example.moviesapp.presentation.MyRvAdapter
import javax.inject.Inject


class MoviesFragment : Fragment(R.layout.fragment_movies) {

    @Inject
     lateinit var moviesVMFactory: MoviesVMFactory
     private lateinit var viewModel:MoviesViewModel
     private lateinit var  binding :FragmentMoviesBinding
     private lateinit var myAdapter: MyRvAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_movies,container,false)
        (requireContext().applicationContext as Injector).createMovieSubComponent().inject(this)

        viewModel = ViewModelProvider(this,moviesVMFactory)[MoviesViewModel::class.java]

        initRecyclerView()
        binding.floatingActionButton.setOnClickListener {
            refreshMoviesList()
        }

        return binding.root
    }

    private fun refreshMoviesList() {
        binding.progressBar.visibility = View.VISIBLE
        viewModel.updateMovies().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                myAdapter.updateMovieslist(it)
                binding.progressBar.visibility = View.GONE
            }else{
                binding.progressBar.visibility = View.GONE
                Toast.makeText(requireContext(),"No Data Available",Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initRecyclerView() {
        myAdapter = MyRvAdapter()
        binding.rvMovies.adapter = myAdapter
        binding.rvMovies.layoutManager = LinearLayoutManager(requireContext())

        displayPopularMovies()

    }



    private fun displayPopularMovies() {
        binding.progressBar.visibility = View.VISIBLE
        viewModel.getMovies().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                myAdapter.updateMovieslist(it)
                binding.progressBar.visibility = View.GONE
            }else{
                binding.progressBar.visibility = View.GONE
                Toast.makeText(requireContext(),"No Data Available",Toast.LENGTH_SHORT).show()
            }
        })
    }

}