package com.uas.miqbalkhalakas.movieapps.service

import com.uas.miqbalkhalakas.movieapps.MovieResponse

import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    @GET("/3/movie/popular?api_key=672bdc2cacf7d1a06275a00cf41f2888")
    fun getMovieList(): Call<MovieResponse>

}