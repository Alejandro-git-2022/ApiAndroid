package com.example.retrofitrecyclerview.network;

import com.example.retrofitrecyclerview.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiMovie {

        @GET("movies/list.php")
    Call<List<Movie>> getMovies();

    @GET("movies/{id}")
    public Call<Movie> getMovieById(@Path("id") int id);

    @GET("movies/search")
    Call<List<Movie>> searchMoviesByName(@Query("name") String name);

    @GET("movies/search")
    public Call<List<Movie>> searchMoviesByTitulo(@Query("titulo") String titulo);



}
