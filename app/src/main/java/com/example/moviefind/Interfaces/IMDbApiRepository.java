package com.example.moviefind.Interfaces;

import com.example.moviefind.models.MovieDetails.Movie;
import com.example.moviefind.models.MovieSearch.AutoCompleteResultModel;
import com.example.moviefind.models.NewsModel;
import com.example.moviefind.models.TopImdb.ImdbItemModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface IMDbApiRepository {

    @Headers({
            "x-rapidapi-host: imdb8.p.rapidapi.com",
            "x-rapidapi-key: 61e7afc311msh20a94f13b4a2b9fp1c7680jsnf331b5e14471"
    })
    @GET("title/get-news")
    Call<NewsModel> getNewsList(
            @Query("tconst") String tconst,
            @Query("limit") Integer limit);


    @Headers({
            "x-rapidapi-host: imdb8.p.rapidapi.com",
            "x-rapidapi-key: f1faf8fe6cmsh55a247daa37e779p1d2cc0jsnd043e0b6ecd6",
            "useQueryString: true"
    })
    @GET("title/auto-complete")
    Call<AutoCompleteResultModel> getAutoCompleteSuggests(@Query("q") String q);


    @Headers({
            "x-rapidapi-key: f1faf8fe6cmsh55a247daa37e779p1d2cc0jsnd043e0b6ecd6",
            "x-rapidapi-host: imdb8.p.rapidapi.com",
            "useQueryString: true"
    })
    @GET("title/get-details")
    Call<Movie>  getMovieDetails(@Query("tconst") String tconst);

    @Headers({
            "x-rapidapi-key: f1faf8fe6cmsh55a247daa37e779p1d2cc0jsnd043e0b6ecd6",
            "x-rapidapi-host: imdb8.p.rapidapi.com",
            "useQueryString: true"
    })
    @GET("title/get-top-rated-movies")
    Call<List<ImdbItemModel>> getTopRatedMovies();
}
