package com.example.moviefind.models.TopImdb;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviefind.Services.MovieService;
import com.example.moviefind.models.MovieViewModel;

import java.util.List;

public class TopImdbViewModel extends ViewModel {
    public MutableLiveData<List<MovieViewModel>> movies;

    public TopImdbViewModel(){
        movies = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<List<MovieViewModel>> getMoviesMutableLiveData() {
        return movies;
    }

    public void setList(List<ImdbItemModel> imdbList){
        imdbList.addAll(imdbList);
        notify();
    }

    public void init(){
        MovieService.getTopImdbMovies(movies);
    }
}
