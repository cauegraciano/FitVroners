package com.fitvroners.www.fitvroners;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WorkoutListAdapter extends RecyclerView.Adapter<WorkoutListAdapter.WorkoutListViewHolder> {

    List<Workout> workouts;
    OnWorkoutClickListener onWorkoutClickListener;

    WorkoutListAdapter(List<Workout> workouts, OnWorkoutClickListener onWorkoutClickListener) {
        this.workouts = workouts;
        this.onWorkoutClickListener = onWorkoutClickListener;
    }

    @Override
    public WorkoutListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View workoutitem = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.workout_item_list, viewGroup, false);
        return new WorkoutListViewHolder(workoutitem);
    }

    @Override
    public void onBindViewHolder( WorkoutListViewHolder workoutListViewHolder, int i) {
        final Workout w = this.workouts.get(i);
        workoutListViewHolder.title.setText(w.getTitle());
        workoutListViewHolder.treino.setText(w.getTreino());
        workoutListViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onWorkoutClickListener.onWorkoutCLick(w);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (this.workouts != null) {
            return this.workouts.size();
        }
        return 0;
    }

    public class WorkoutListViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView treino;

        public WorkoutListViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.xtitle);
            this.treino = itemView.findViewById(R.id.xworkout);
        }
    }
}