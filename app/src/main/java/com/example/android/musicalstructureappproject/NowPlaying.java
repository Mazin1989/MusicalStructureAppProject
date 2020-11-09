package com.example.android.musicalstructureappproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class NowPlaying extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        String songNamePlaying = "";
        String artistNamePlaying = "";

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null) {
            songNamePlaying = bundle.getString("name");
            artistNamePlaying = bundle.getString("artist");
        }

        TextView songPlaying = (TextView) findViewById(R.id.now_playing_song);
        songPlaying.setText(songNamePlaying);

        TextView artistPlaying = (TextView) findViewById(R.id.now_playing_artist);
        artistPlaying.setText(artistNamePlaying);


    }

}


