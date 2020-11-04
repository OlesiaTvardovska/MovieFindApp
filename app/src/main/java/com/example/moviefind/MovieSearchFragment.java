package com.example.moviefind;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.moviefind.Services.MovieService;
import com.example.moviefind.adapters.AutoSuggestAdapter;
import com.example.moviefind.databinding.FragmentMovieSearchBinding;
import com.example.moviefind.models.MovieViewModel;
import com.squareup.picasso.Picasso;

public class MovieSearchFragment extends Fragment {
    private static final int TRIGGER_AUTO_COMPLETE = 100;
    private static final long AUTO_COMPLETE_DELAY = 300;
    private MovieViewModel movieViewModel;
    private Handler handler;
    private AutoSuggestAdapter autoSuggestAdapter;

    public MovieSearchFragment() {
    }

    public static MovieSearchFragment newInstance() {
        MovieSearchFragment fragment = new MovieSearchFragment();
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
        FragmentMovieSearchBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_movie_search, container, false);
        View view = binding.getRoot();
        movieViewModel = new MovieViewModel(view.findViewById(R.id.image_view));
        binding.setViewmodel(movieViewModel);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // set view binding
        final AppCompatAutoCompleteTextView autoCompleteTextView =
                 view.findViewById(R.id.auto_complete_edit_text);
        autoSuggestAdapter = new AutoSuggestAdapter(getActivity(),
                android.R.layout.simple_dropdown_item_1line);
        autoCompleteTextView.setThreshold(2);
        autoCompleteTextView.setAdapter(autoSuggestAdapter);
        autoCompleteTextView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        MovieService.getMovieDetails(autoSuggestAdapter
                                .getSelectedItem(position).getId(), movieViewModel);
                        //close virtual keyboard
                        InputMethodManager inputManager = (InputMethodManager)
                                getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
                                InputMethodManager.HIDE_NOT_ALWAYS);
                        ((AutoCompleteTextView)getActivity().findViewById(R.id.auto_complete_edit_text))
                                .setText("");
                    }
                });
        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int
                    count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                handler.removeMessages(TRIGGER_AUTO_COMPLETE);
                handler.sendEmptyMessageDelayed(TRIGGER_AUTO_COMPLETE,
                        AUTO_COMPLETE_DELAY);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == TRIGGER_AUTO_COMPLETE) {
                    if (!TextUtils.isEmpty(autoCompleteTextView.getText())) {
                        MovieService.makeApiCall(autoCompleteTextView.getText().toString(), autoSuggestAdapter);
                    }
                }
                return false;
            }
        });
    }

    @BindingAdapter("android:src")
    public static void setImageDrawable(ImageView view, Uri imageUri) {
        view.setImageURI(imageUri);
    }
}