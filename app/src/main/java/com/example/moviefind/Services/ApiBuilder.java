package com.example.moviefind.Services;

import com.example.moviefind.Interfaces.IMDbApiRepository;
import com.example.moviefind.Interfaces.NewsRepository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBuilder {
    private static Retrofit retrofit = null;
    public static IMDbApiRepository getClient() {

        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://rapidapi.p.rapidapi.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        //Creating object for our interface
        IMDbApiRepository api = retrofit.create(IMDbApiRepository.class);
        return api;
    }

    public static NewsRepository getNewsApiClient(){
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://bing-news-search1.p.rapidapi.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        //Creating object for our interface
        NewsRepository api = retrofit.create(NewsRepository.class);
        return api;
    }


}
