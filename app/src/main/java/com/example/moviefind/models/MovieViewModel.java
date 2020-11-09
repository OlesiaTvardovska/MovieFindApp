package com.example.moviefind.models;

import android.net.Uri;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.moviefind.Services.MovieService;
import com.example.moviefind.models.MovieDetails.Movie;

public class MovieViewModel extends ViewModel {

    public ObservableField<Movie> movie = new ObservableField<>();
    private ImageView imageView;

    public MovieViewModel(){}
    public MovieViewModel(ImageView imageView){
        this.imageView = imageView;
    }

    public void setMovie(Movie movieM){
        if(imageView != null){
            loadImage(imageView, Uri.parse(movieM.getImage().getUrl()));
        }
        movie.set(movieM);

    }

    @BindingAdapter("profileImage")
    public void loadImage(ImageView view, Uri imageUrl) {
        if(movie != null){
            Glide.with(view.getContext())
                    .load(imageUrl)
                    .into(view);
        }
    }
}
