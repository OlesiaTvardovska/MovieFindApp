package com.example.moviefind;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import com.example.moviefind.adapters.MoviesAdapter;
import com.example.moviefind.models.MovieViewModel;
import com.example.moviefind.models.TopImdb.TopImdbViewModel;

import java.util.ArrayList;
import java.util.List;

public class TopImdbFragment extends Fragment {

    private RecyclerView recyclerView;
    private TopImdbViewModel viewModel;
    private MoviesAdapter moviesAdapter;

    public TopImdbFragment() {
        viewModel = new TopImdbViewModel();
    }

    public static TopImdbFragment newInstance() {
        TopImdbFragment fragment = new TopImdbFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_top_imdb, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.imdb_recycler_view);
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        viewModel = new TopImdbViewModel();
        viewModel.getMoviesMutableLiveData().observe(this, new Observer<List<MovieViewModel>>() {
            @Override
            public void onChanged(List<MovieViewModel> movieModel) {
                moviesAdapter = new MoviesAdapter(getActivity(),
                                    (ArrayList<MovieViewModel>) movieModel);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(moviesAdapter);
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

}

