package com.example.moviefind;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.moviefind.adapters.RecyclerViewAdapter;
import com.example.moviefind.models.BingNewsViewModel;
import com.example.moviefind.models.ItemModel;
import com.example.moviefind.models.News.News;
import com.example.moviefind.models.News.Value;
import com.example.moviefind.models.NewsModel;
import com.example.moviefind.models.NewsViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {
    private BingNewsViewModel bingNewsViewModel;
    private RecyclerView recyclerView;

    private ProgressBar progressBar;

    RecyclerViewAdapter recyclerViewAdapter;

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

        String pattern = "EEEE, MMMM dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        TextView dateView = viewFragment.findViewById(R.id.currentDate);
        dateView.setText(simpleDateFormat.format(new Date()));

        progressBar =  (ProgressBar) viewFragment.findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);

        return viewFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        recyclerView = view.findViewById(R.id.rv_main);
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        bingNewsViewModel = new BingNewsViewModel();
        bingNewsViewModel.getNewsMutableLiveData().observe(this, new Observer<News>() {
            @Override
            public void onChanged(News newsModel) {
                recyclerViewAdapter = new RecyclerViewAdapter(getActivity(), (ArrayList<Value>) newsModel.getValue());
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(recyclerViewAdapter);
                progressBar.setVisibility(View.GONE);
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }
}