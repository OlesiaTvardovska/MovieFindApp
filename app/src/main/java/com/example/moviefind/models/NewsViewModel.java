package com.example.moviefind.models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviefind.Interfaces.IMDbApiRepository;
import com.example.moviefind.Services.ApiBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {
    public MutableLiveData<NewsModel> news = new MutableLiveData<NewsModel>();
    NewsModel newsModel;
    private IMDbApiRepository imdbRepository;

    public NewsViewModel(){
        imdbRepository = ApiBuilder.getClient();
        news = new MutableLiveData<NewsModel>();

        //request to imdb api
        init();
    }

    public MutableLiveData<NewsModel> getNewsMutableLiveData() {
        return news;
    }

    public void init(){
        Call<NewsModel>  newsCall = imdbRepository.getNewsList("tt0944947", 5);
        newsCall.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                news.setValue(response.body());
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                news.setValue(new NewsModel());
            }
        });
    }

}
