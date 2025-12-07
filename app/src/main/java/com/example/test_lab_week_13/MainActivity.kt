package com.example.test_lab_week_13

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.databinding.DataBindingUtil
import com.example.test_lab_week_13.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val movieAdapter = MovieAdapter()

    // Inisialisasi ViewModel menggunakan by viewModels dan factory
    private val movieViewModel: MovieViewModel by viewModels {
        MovieViewModelFactory(MovieApplication.movieService)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Buat Binding Object dari layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Bind ViewModel ke layout
        binding.viewModel = movieViewModel
        binding.lifecycleOwner = this

        // Set RecyclerView layout manager dan adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = movieAdapter

        // Tidak perlu lagi lifecycleScope.launch
        // RecyclerView akan otomatis update melalui Data Binding dan BindingAdapter
    }
}
