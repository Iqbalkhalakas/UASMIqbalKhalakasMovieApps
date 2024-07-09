package com.uas.miqbalkhalakas.movieapps

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.uas.miqbalkhalakas.movieapps.databinding.FragmentMovieBinding
import com.uas.miqbalkhalakas.movieapps.service.MovieApiInterface
import com.uas.miqbalkhalakas.movieapps.service.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieFragment : Fragment() {
    private val movies = arrayListOf<Movie>()
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvMoviesList.layoutManager = LinearLayoutManager(context)
        binding.rvMoviesList.setHasFixedSize(true)
        getMovieData { movies: List<Movie> ->
            binding.rvMoviesList.adapter = MovieAdapter(movies)
        }
        showRecyclerView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.i("tes", "gagal")
                // Handle failure
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                Log.i("tes", "sukses")
                callback(response.body()?.movies ?: emptyList())
            }
        })
    }

    private fun showRecyclerView() {
        binding.rvMoviesList.layoutManager = LinearLayoutManager(context)
        binding.rvMoviesList.adapter = MovieAdapter(movies)
    }
}