package com.example.retrofitrecyclerview;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitrecyclerview.adapter.MovieAdapter;
import com.example.retrofitrecyclerview.model.Movie;
import com.example.retrofitrecyclerview.network.ApiCliente;
import com.example.retrofitrecyclerview.network.ApiMovie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movies;
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_movies);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        showMovies();
    }

    public void showMovies() {
        Call<List<Movie>> call = ApiCliente.getRetrofit().create(ApiMovie.class).getMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (response.isSuccessful()) {
                    movies = response.body();
                    movieAdapter = new MovieAdapter(movies, getApplicationContext());
                    recyclerView.setAdapter(movieAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de conexion", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void searchMovieById(int id) {
        Call<Movie> call = ApiCliente.getRetrofit().create(ApiMovie.class).getMovieById(id);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful()) {
                    Movie movie = response.body();
                    // Manejar la respuesta
                } else {
                    // Manejar error de respuesta
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                // Manejar error de conexión
            }
        });
    }

    public void searchMoviesByName(String name) {
        Call<List<Movie>> call = ApiCliente.getRetrofit().create(ApiMovie.class).searchMoviesByName(name);
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body();
                    // Manejar la lista de películas encontradas
                } else {
                    // Manejar error de respuesta
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                // Manejar error de conexión
            }
        });
    }



    public void searchMoviesByTitulo(String titulo) {
        Call<List<Movie>> call = ApiCliente.getRetrofit().create(ApiMovie.class).searchMoviesByTitulo(titulo);
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body();
                    // Manejar la lista de películas encontradas por título
                } else {
                    // Manejar error de respuesta
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                // Manejar error de conexión
            }
        });
    }



}
