package com.example.moviefind.Interfaces;

import com.example.moviefind.models.News.News;
import com.example.moviefind.models.NewsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface NewsRepository {

    @Headers({
            "x-rapidapi-host: bing-news-search1.p.rapidapi.com",
            "x-rapidapi-key: 61e7afc311msh20a94f13b4a2b9fp1c7680jsnf331b5e14471",
            "x-bingapis-sdk true",
            "useQueryString true"
    })
    @GET("news")
    Call<News> getNews (
            @Query("category") String category,
            @Query("safeSearch") String safeSearch);
}
