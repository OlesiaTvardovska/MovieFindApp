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
            "x-rapidapi-key: ecab589a9dmsh7ca3069808d7725p109f06jsn2bda857dd501"
    })
    @GET("title/get-news")
    Call<NewsModel> getNewsList(
            @Query("tconst") String tconst,
            @Query("limit") Integer limit);


    @Headers({
            "x-rapidapi-host: imdb8.p.rapidapi.com",
            "x-rapidapi-key: ecab589a9dmsh7ca3069808d7725p109f06jsn2bda857dd501",
            "useQueryString: true"
    })
    @GET("title/auto-complete")
    Call<AutoCompleteResultModel> getAutoCompleteSuggests(@Query("q") String q);


    @Headers({
            "x-rapidapi-key: ecab589a9dmsh7ca3069808d7725p109f06jsn2bda857dd501",
            "x-rapidapi-host: imdb8.p.rapidapi.com",
            "useQueryString: true"
    })
    @GET("title/get-details")
    Call<Movie>  getMovieDetails(@Query("tconst") String tconst);

    @Headers({
            "x-rapidapi-key: ecab589a9dmsh7ca3069808d7725p109f06jsn2bda857dd501",
            "x-rapidapi-host: imdb8.p.rapidapi.com",
            "useQueryString: true"
    })
    @GET("title/get-top-rated-movies")
    Call<List<ImdbItemModel>> getTopRatedMovies();
}
