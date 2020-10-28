package com.example.moviefind.models;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviefind.Interfaces.NewsRepository;
import com.example.moviefind.Services.ApiBuilder;
import com.example.moviefind.models.News.News;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BingNewsViewModel extends ViewModel {
    public MutableLiveData<News> news = new MutableLiveData<News>();
    News newsModel;
    private NewsRepository newsRepository;

    public BingNewsViewModel(){
        newsRepository = ApiBuilder.getNewsApiClient();
        news = new MutableLiveData<News>();

        //request to imdb api
        init();
    }

    public MutableLiveData<News> getNewsMutableLiveData() {
        return news;
    }

    public void init(){
        Call<News> newsCall = newsRepository.getNews("en-us", "Off",
                "Entertainment_MovieAndTV", "Raw");
        newsCall.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                News ne = response.body();
                news.setValue(response.body());
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                news.setValue(new News());
            }
        });
    }
}
