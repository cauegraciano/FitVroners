package com.fitvroners.www.fitvroners;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

public class CreateWorkoutDuration extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_workout_duration);
        Intent i = getIntent();
    }

    public void inputAnswer(View v) {
        Button btnClicked = (Button) v;
        String getAnswer = btnClicked.getText().toString();
        HashMap<String, String> answers = new HashMap<String, String>();
        answers.put("resposta1", getAnswer);

        Intent addAnswer = new Intent(this, CreateWorkoutIntensity.class);
        addAnswer.putExtra("answers", answers);
        startActivity(addAnswer);
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
