package com.fitvroners.www.fitvroners;

import android.app.LoaderManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class ResultWorkout extends AppCompatActivity {

    private HashMap<String, String> answers = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
//        WorkoutsInterface q = new WorkoutsInterface();

        answers = (HashMap) i.getExtras().get("answers");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_workout);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Treino criado!", Toast.LENGTH_LONG).show();
    }

    protected void backToMenu(View v) {
        Button btnClicked = (Button) v;
        Intent backToMenu = new Intent (this, InitialMenu.class);
        startActivity(backToMenu);
    }

}
