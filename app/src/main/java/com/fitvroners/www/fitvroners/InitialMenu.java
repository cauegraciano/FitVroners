package com.fitvroners.www.fitvroners;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class InitialMenu extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_menu);

    }

    public void openWorkoutsList(View v) {
        Intent openWorkoutsList = new Intent (this, WorkoutList.class);
        startActivity(openWorkoutsList);
    }

    public void openCreateWorkout(View v) {
        Intent openCreateWorkout = new Intent (this, CreateWorkoutDuration.class);
        startActivity(openCreateWorkout);
    }

    public void openHistory(View v) {
        Intent openHist = new Intent (this, History.class);
        startActivity(openHist);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
