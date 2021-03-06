package com.example.android.musicalstructureappproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        //create an ArrayList of Song with the song values (song name & artist name)
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
        songs.add(new Song("Burning Sword", "Falcom"));
        songs.add(new Song("Again", "Yui"));


        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);


        /**
         * Method to identify ListView item clicked and launch NowPlayingActivity
         */

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Get the selected song.
                Song currentSong = (Song) adapterView.getItemAtPosition(position);
                // Extract strings from Song object.
                String mSongName = currentSong.getSongName();
                String mArtistName = currentSong.getArtistName();
                // Sending the name and artist of song to NowPlayingActivity.
                Intent songIntent = new Intent(SongsActivity.this, NowPlaying.class);
                songIntent.putExtra("name", mSongName);
                songIntent.putExtra("artist", mArtistName);
                startActivity(songIntent);
            }
        });

    }
}



