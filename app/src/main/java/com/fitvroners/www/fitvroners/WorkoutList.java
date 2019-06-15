package com.fitvroners.www.fitvroners;

import android.content.Intent;
import android.graphics.Movie;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.List;

public class WorkoutList extends AppCompatActivity implements onWorkoutClickListener<Workout> {

    private RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_list);

        LoadAllWorkouts loadAllWorkouts = new LoadAllWorkouts(this);
        loadAllWorkouts.execute();
    }

    @Override
    public void onWorkoutClick(Workout workout) {
        Intent workoutInfo = new Intent(this, WorkoutInfo.class);
        workoutInfo.putExtra("workoutId", workout.getId());
        startActivity(workoutInfo);
        // Toast.makeText(this,movie.getId(),Toast.LENGTH_SHORT).show();
    }

    class LoadAllWorkouts extends AsyncTask<Void, Void, List<Workout>> {

        OnWorkoutClickListener onWorkoutClickListener;

        LoadAllWorkouts(OnWorkoutClickListener onWorkoutClickListener){
            super();
            this.onWorkoutClickListener = onWorkoutClickListener;
        }

        @Override
        protected List<Workout> doInBackground(Void... voids) {
            WorkoutService wks = new WorkoutService();
            List<Workout> workouts = wks.getAll();
            return workouts;
        }
        @Override
        protected void onPostExecute(List<Movie> movies){
            list = findViewById(R.id.list);

            RecyclerView.Adapter<WorkoutListAdapter.MovieListViewHolder> adapter = new WorkoutListAdapter(movies, onWorkoutClickListener);

            RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
            list.setLayoutManager(manager);
            list.setHasFixedSize(true);
            list.setAdapter(adapter);


        }
    }
}
