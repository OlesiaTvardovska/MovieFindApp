package com.example.moviefind.models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviefind.Interfaces.IMDbApiRepository;
import com.example.moviefind.Services.ApiBuilder;

public class NewsViewModel extends ViewModel {
    public MutableLiveData<NewsModel> news = new MutableLiveData<NewsModel>();
    private IMDbApiRepository imdbRepository;

    public NewsViewModel(){
        imdbRepository = ApiBuilder.getClient();
    }

    public LiveData<NewsModel> getNews() {
        if (news == null) {
            news = new MutableLiveData<NewsModel>();
            loadNews();
        }
        return news;
    }

    private void loadNews(){
        news = (MutableLiveData<NewsModel>) imdbRepository.getNewsList("tt0944947", 25);
    }
}
