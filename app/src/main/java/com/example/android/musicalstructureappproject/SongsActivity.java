package com.example.android.musicalstructureappproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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


        listView.setOnItemClickListener(new OnItemClickListener() {
            /**
             * Method to identify ListView item clicked and launch NowPlayingActivity
             */
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Get the selected song.
                Song currentSong = (Song) adapterView.getItemAtPosition(position);
                // Extract strings from Song object.
                String mSongName = currentSong.getSongName();
                String mArtistName = currentSong.getArtistName();
                // Sending the name and artist of song to NowPlayingActivity.
                Intent songIntent = new Intent(this, NowPlaying.class);
                songIntent.putExtra("name", mSongName);
                songIntent.putExtra("artist", mArtistName);
                startActivity(songIntent);
            }

        });


    }
}



