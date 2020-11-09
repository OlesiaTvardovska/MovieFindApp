package com.example.moviefind.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviefind.R;
import com.example.moviefind.models.MovieDetails.Movie;
import com.example.moviefind.models.MovieViewModel;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity context;
    ArrayList<MovieViewModel> moviesList;

    public MoviesAdapter(Activity context, ArrayList<MovieViewModel> movies) {
        this.context = context;
        this.moviesList = movies;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.movie_item,parent,false);
        return new RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MovieViewModel movieItem = moviesList.get(position);
        RecyclerViewViewHolder viewHolder= (RecyclerViewViewHolder) holder;

        viewHolder.txtView_title.setText(movieItem.movie.get().getTitle());

/*        holder.itemView.setOnClickListener(v -> {
            // Get the current state of the item
            boolean expanded = newsItem.getExpanded();
            // Change the state
            newsItem.setExpanded(!expanded);
            viewHolder.txtView_description.setVisibility(newsItem.getExpanded() == true ? View.VISIBLE
                    : View.GONE);
            // Notify the adapter that item has changed
            notifyItemChanged(position);
        });*/
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        TextView txtView_title;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            txtView_title = itemView.findViewById(R.id.movie_title);
        }
    }
}