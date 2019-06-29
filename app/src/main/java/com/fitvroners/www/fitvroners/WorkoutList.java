package com.fitvroners.www.fitvroners;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;


public class WorkoutList extends AppCompatActivity implements OnWorkoutClickListener<Workout> {

    private RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_list);

        LoadAllWorkouts loadAllWorkouts = new LoadAllWorkouts(this);
        loadAllWorkouts.execute();
    }

    @Override
    public void onWorkoutCLick(Workout w) {
        Intent workoutInfo = new Intent(this, WorkoutInfo.class);
        workoutInfo.putExtra("workoutId", w.getId());
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
            WorkoutService mvs = new WorkoutService();
            List<Workout> workouts = mvs.getAll();
            return workouts;
        }
        @Override
        protected void onPostExecute(List<Workout> workouts){
            list = findViewById(R.id.list);

            RecyclerView.Adapter<WorkoutListAdapter.WorkoutListViewHolder> adapter = new WorkoutListAdapter(workouts, onWorkoutClickListener);

            RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
            list.setLayoutManager(manager);
            list.setHasFixedSize(true);
            list.setAdapter(adapter);
        }
    }
}