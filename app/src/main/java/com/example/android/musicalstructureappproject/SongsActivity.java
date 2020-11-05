package com.example.android.musicalstructureappproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs);

        //create an ArrayList of String with the songs values
        ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song("In The End", "Linkin Park"));
        songs.add(new Song("Breaking The Habit", "Linkin Park"));
        songs.add(new Song("All Rise", "Blue"));
        songs.add(new Song("Curtain Falls", "Blue"));
        songs.add(new Song("Meet Me Halfway", "Black Eyed Peas"));
        songs.add(new Song("I Gotta A Feeling", "Black Eyed Peas"));
        songs.add(new Song("Period", "Chemistry"));
        songs.add(new Song("Superhero", "Chingy"));
        songs.add(new Song("Viva La Vida", "Coldplay"));
        songs.add(new Song("Give Your Heart A Break", "Demi Lovato"));


        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);


        /** Add onClickListener to allow user to click on any item list and it jumps to Now Playing
         * Screen with the name of the Song and Artist
         *  !!!!! Find a way to do this using Object Song !!!!!
         */
        // Find the View that shows the numbers category
        ListView nowPlaying = (ListView) findViewById(R.id.list);

        // Set a click listener on that View
        nowPlaying.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the songs View is clicked on.
            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent(SongsActivity.this, SongPlaying.class);
                startActivity(nowPlayingIntent);
            }

        });
    }

}
