package com.fitvroners.www.fitvroners;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WorkoutInfo extends AppCompatActivity {

    String workoutId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_info);
        Intent previousWorkout = getIntent();
        String previousId = previousWorkout.getExtras().getString(("workoutId"));
        LoadWorkout loadWorkout = new LoadWorkout(previousId);
        loadWorkout.execute();
    }

    class LoadWorkout extends AsyncTask<Void, Void, Workout> {

        String workoutId = "";

        LoadWorkout(String id) {
            super();
            this.workoutId = id;
        }

        @Override
        protected Workout doInBackground(Void... voids) {
            WorkoutService wks = new WorkoutService();
            Workout workout = wks.getById(this.workoutId);
            return workout;
        }

        @Override
        protected void onPostExecute(Workout workout) {

            TextView title = findViewById(R.id.title);
            TextView duration = findViewById(R.id.duration);
            TextView calories = findViewById(R.id.calories);
            TextView user = findViewById(R.id.user);
            TextView workoutElm = findViewById(R.id.workout);

            title.setText("Titulo: " + workout.getTitle());
            duration.setText("Duração: " + workout.getDuration());
            calories.setText("Calorias: " + workout.getCalories());
            user.setText("Usuario: " + workout.getUser());
            workoutElm.setText("Treino: " + workout.getTreino());
        }
    }

    class DeleteWorkout extends AsyncTask<Void, Void, Void> {

        String workoutId = "";

        DeleteWorkout(String id) {
            super();
            this.workoutId = id;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            WorkoutService wks = new WorkoutService();
            wks.deleteWorkout(this.workoutId);
            return null;
        }

        protected void onPostExecute() {
//            Intent workoutList = new Intent(WorkoutInfo.class, WorkoutList.class);
//            startActivity(workoutList);
            System.out.println("concluido");
        }
    }

    protected void delete(View view) {

        Intent previousWorkout = getIntent();
        String previousId = previousWorkout.getExtras().getString(("workoutId"));

        DeleteWorkout deleteWorkout = new DeleteWorkout(previousId);
        deleteWorkout.execute();

    }

}
