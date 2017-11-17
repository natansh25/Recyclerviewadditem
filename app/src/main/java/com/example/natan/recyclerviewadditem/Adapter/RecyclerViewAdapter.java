package com.example.natan.recyclerviewadditem.Adapter;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.natan.recyclerviewadditem.Movies;
import com.example.natan.recyclerviewadditem.R;

import java.util.List;

/**
 * Created by natan on 11/17/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<Movies> mMovieList;

    public RecyclerViewAdapter(List<Movies> movieList) {
        this.mMovieList=movieList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_dialog, parent, false);
        
        
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Movies movie = mMovieList.get(position);
        holder.enterName.setText(movie.getMovieName());
        

    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public TextView enterName;

        public MyViewHolder(View itemView) {
            super(itemView);

            // matches with the id

            enterName = itemView.findViewById(R.id.name);

        }
    }
}
