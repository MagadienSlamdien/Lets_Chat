package com.hybridsoftsolutions.letschat.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hybridsoftsolutions.letschat.R;
import com.hybridsoftsolutions.letschat.models.Movie;

import java.util.List;

/**
 * Created by Magadien on 2018/08/16.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
    private List<Movie> movieList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, year, genre;

        public MyViewHolder(View view){
            super(view);
            title = view.findViewById(R.id.title);
            year = view.findViewById(R.id.year);
            genre = view.findViewById(R.id.genre);
        }
    }

    public MoviesAdapter(List<Movie> movieList){
        this.movieList = movieList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.title.setText(movie.getTitle());
        holder.year.setText(movie.getYear());
        holder.genre.setText(movie.getGenre());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
