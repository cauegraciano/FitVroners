package com.fitvroners.www.fitvroners;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openMovies(View view)  {
        Intent movieList = new Intent(this, MovieList.class);
        startActivity(movieList);
    }
}
