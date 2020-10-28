package com.example.moviefind.adapters;

import android.app.Activity;
import android.content.ClipData;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviefind.models.ItemModel;
import com.example.moviefind.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity context;
    ArrayList<ItemModel> newsItemList;

    public RecyclerViewAdapter(Activity context, ArrayList<ItemModel> newsItemList) {
        this.context = context;
        this.newsItemList = newsItemList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.news_item,parent,false);
        return new RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ItemModel newsItem = newsItemList.get(position);
        RecyclerViewViewHolder viewHolder= (RecyclerViewViewHolder) holder;

        viewHolder.txtView_title.setText(newsItem.getHead());
        viewHolder.txtView_description.setText(newsItem.getBody());

        //To set image we use extra lib - for performance issues
        Glide.with(viewHolder.itemView).load(Uri.parse(newsItem.getImage().getUrl())).into(viewHolder.image_news_view);

        holder.itemView.setOnClickListener(v -> {
            // Get the current state of the item
            boolean expanded = newsItem.getExpanded();
            // Change the state
            newsItem.setExpanded(!expanded);
            viewHolder.txtView_description.setVisibility(newsItem.getExpanded() == true ? View.VISIBLE
                    : View.GONE);
            // Notify the adapter that item has changed
            notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount() {
        return newsItemList.size();
    }

    class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        TextView txtView_title;
        TextView txtView_description;
        ImageView image_news_view;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);

            txtView_title = itemView.findViewById(R.id.txtView_title);
            txtView_description = itemView.findViewById(R.id.txtView_description);
            image_news_view = itemView.findViewById(R.id.image_news_view);
            txtView_description.setVisibility(
                    txtView_description.getWindowVisibility() == View.VISIBLE
                            ? View.VISIBLE : View.GONE);
        }
    }
}