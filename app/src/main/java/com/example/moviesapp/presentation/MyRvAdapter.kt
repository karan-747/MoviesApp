package com.example.moviesapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.data.MovieItem
import com.example.moviesapp.databinding.PreviewItemBinding

class MyRvAdapter :RecyclerView.Adapter<MyRvAdapter.MyViewHolder>() {
    private val moviesList = ArrayList<MovieItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = DataBindingUtil.inflate<PreviewItemBinding>(LayoutInflater.from(parent.context),
            R.layout.preview_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(moviesList[position])

    }

    fun updateMovieslist( newMoviesList: List<MovieItem>){
        moviesList.clear()
        moviesList.addAll(newMoviesList)
        notifyDataSetChanged()
    }



    inner class MyViewHolder(private val binding:PreviewItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(movieItem: MovieItem){
            binding.tvName.text = movieItem.movieName
            binding.tvDesc.text = movieItem.movieDescription
            binding.tvdate.text = movieItem.movieReleaseDate
            binding.tvRatings.text =  "${movieItem.movieRating}/10"
            val posterURL = "https://image.tmdb.org/t/p/w500/${movieItem.posterPath}"

            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)


        }
    }
}