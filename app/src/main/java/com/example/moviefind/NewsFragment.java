package com.example.moviefind;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.moviefind.adapters.RecyclerViewAdapter;
import com.example.moviefind.models.ItemModel;
import com.example.moviefind.models.NewsModel;
import com.example.moviefind.models.NewsViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {

    private NewsModel newsList;
    private NewsViewModel newsViewModel;
    private RecyclerView recyclerView;

    private ProgressBar progressBar;

    RecyclerViewAdapter recyclerViewAdapter;

    public NewsFragment() {
        newsList = new NewsModel();
    }

    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewFragment = inflater.inflate(R.layout.fragment_news, container, false);
        progressBar =  (ProgressBar) viewFragment.findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);

        return viewFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // Set up progress before call

        recyclerView = view.findViewById(R.id.rv_main);
        newsViewModel = new NewsViewModel();
        newsViewModel.getNewsMutableLiveData().observe(this, new Observer<NewsModel>() {
            @Override
            public void onChanged(NewsModel newsItemList) {
                recyclerViewAdapter = new RecyclerViewAdapter(getActivity(), (ArrayList<ItemModel>) newsItemList.getItems());
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(recyclerViewAdapter);
                progressBar.setVisibility(View.GONE);
            }
        });


        super.onViewCreated(view, savedInstanceState);
    }
}