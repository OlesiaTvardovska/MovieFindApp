package com.example.moviefind.Services;

import android.database.Observable;

import androidx.lifecycle.MutableLiveData;

import com.example.moviefind.Interfaces.IMDbApiRepository;
import com.example.moviefind.adapters.AutoSuggestAdapter;
import com.example.moviefind.models.MovieDetails.Image;
import com.example.moviefind.models.MovieDetails.Movie;
import com.example.moviefind.models.MovieViewModel;
import com.example.moviefind.models.MovieSearch.AutoCompItem;
import com.example.moviefind.models.MovieSearch.AutoCompleteResultModel;
import com.example.moviefind.models.TopImdb.ImdbItemModel;
import com.example.moviefind.models.TopImdb.TopImdbViewModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
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

    public static void getTopImdbMovies(MutableLiveData<List<MovieViewModel>> movieModelList){
        ReentrantLock locker = new ReentrantLock();
        Call<List<ImdbItemModel>> apiCall = repo.getTopRatedMovies();
        apiCall.enqueue(new Callback<List<ImdbItemModel>>() {
            @Override
            public void onResponse(Call<List<ImdbItemModel>> call,
                                   Response<List<ImdbItemModel>> response) {
                List<MovieViewModel> moviesList = new ArrayList<>();
                List<ImdbItemModel> idsList = response.body().subList(0,3);
                for (ImdbItemModel model : idsList) {
                    Call<Movie> movieCall = repo.getMovieDetails(model.getId()
                            .replace("/", "")
                            .replace("title", ""));
                    MovieViewModel moviesModel = new MovieViewModel();
                    movieCall.enqueue(new Callback<Movie>() {
                        @Override
                        public void onResponse(Call<Movie> call, Response<Movie> response) {
                            locker.lock();
                            moviesModel.setMovie(response.body());
                            moviesList.add(moviesModel);
                            movieModelList.setValue(moviesList);
                            locker.unlock();
                        }

                        @Override
                        public void onFailure(Call<Movie> call, Throwable t) {
                            t.printStackTrace();
                        }
                    });

                }
                //movieModelList.setValue(moviesList);
            }

            @Override
            public void onFailure(Call<List<ImdbItemModel>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
