package com.fitvroners.www.fitvroners;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WorkoutListAdapter extends RecyclerView.Adapter<WorkoutListAdapter.MovieListViewHolder> {

    List<Movie> movies;
    OnWorkoutClickListener onWorkoutClickListener;

    WorkoutListAdapter(List<Movie> movies, OnWorkoutClickListener onWorkoutClickListener) {
        this.movies = movies;
        this.onWorkoutClickListener = onWorkoutClickListener;
    }

    @Override
    public MovieListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View movieItem = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.workout_item_list, viewGroup, false);
        return new MovieListViewHolder(movieItem);
    }

    @Override
    public void onBindViewHolder( MovieListViewHolder movieListViewHolder, int i) {
        final Movie m = this.movies.get(i);
        movieListViewHolder.year.setText(Integer.toString(m.getYear()));
        movieListViewHolder.title.setText(m.getTitle());
        movieListViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onWorkoutClickListener.onMovieClick(m);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (this.movies != null) {
            return this.movies.size();
        }
        return 0;
    }

    public class MovieListViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView year;

        public MovieListViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.xtitle);
            this.year = itemView.findViewById(R.id.xyear);
        }
    }
}
