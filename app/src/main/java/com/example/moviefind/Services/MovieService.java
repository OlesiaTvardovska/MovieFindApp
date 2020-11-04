package com.example.moviefind.Services;

import com.example.moviefind.Interfaces.IMDbApiRepository;
import com.example.moviefind.adapters.AutoSuggestAdapter;
import com.example.moviefind.models.MovieDetails.Movie;
import com.example.moviefind.models.MovieViewModel;
import com.example.moviefind.models.MovieSearch.AutoCompItem;
import com.example.moviefind.models.MovieSearch.AutoCompleteResultModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieService {

    private static IMDbApiRepository repo = ApiBuilder.getClient();

    public static void makeApiCall(String text, AutoSuggestAdapter adapter) {
        Call<AutoCompleteResultModel> apiCall = repo.getAutoCompleteSuggests(text);
        apiCall.enqueue(new Callback<AutoCompleteResultModel>() {
            @Override
            public void onResponse(Call<AutoCompleteResultModel> call,
                                   Response<AutoCompleteResultModel> response) {

                List<String> stringList = new ArrayList<>();
                AutoCompleteResultModel model = response.body();
                List<AutoCompItem> itemsList = model.getAutoCompItem();
                for (AutoCompItem str : itemsList) {
                    stringList.add(str.getL());
                }
                adapter.setData(stringList);
                adapter.setObjectsList(itemsList);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<AutoCompleteResultModel> call, Throwable t) {
                adapter.setData(new ArrayList<>());
                t.printStackTrace();
            }
        });
    }

    public static MovieViewModel getMovieDetails(String tconst, MovieViewModel movieModel){
        Call<Movie> apiCall = repo.getMovieDetails(tconst);
        apiCall.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call,
                                   Response<Movie> response) {
                movieModel.setMovie(response.body());
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                movieModel.setMovie(new Movie());
                t.printStackTrace();
            }
        });
        return movieModel;
    }
}
