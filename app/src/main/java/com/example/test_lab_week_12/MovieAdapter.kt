package com.example.test_lab_week_12

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test_lab_week_12.databinding.ItemMovieBinding
import com.example.test_lab_week_12.model.Movie

// Hapus 'private val' dari konstruktor, kita akan kelola list di dalam class
class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    // Buat variabel untuk menyimpan daftar film. Awalnya kosong.
    private var movies: List<Movie> = emptyList()

    // --- INI SOLUSINYA ---
    // Buat fungsi untuk mengganti daftar film dan memberitahu adapter untuk refresh.
    // Ini adalah pengganti dari `addMovies` yang Anda coba panggil.
    fun updateMovies(newMovies: List<Movie>) {
        this.movies = newMovies
        notifyDataSetChanged() // Memberitahu RecyclerView bahwa data telah berubah
    }

    inner class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    // getItemCount sekarang menggunakan properti 'movies' dari dalam class
    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        // Logika onBindViewHolder tidak perlu diubah
        val movie = movies[position]
        holder.binding.movieTitle.text = movie.title

        val baseImageUrl = "https://image.tmdb.org/t/p/w500"
        val fullPosterUrl = baseImageUrl + movie.posterPath

        Glide.with(holder.itemView.context)
            .load(fullPosterUrl)
            .into(holder.binding.moviePoster)
    }
}
