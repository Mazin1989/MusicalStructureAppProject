package com.example.android.musicalstructureappproject;

public class Song {

    private String mSongName;
    private String mArtistName;

    //Object class to be used when adding values in the ArrayList songs
    public Song(String songName, String artistName) {
        mSongName = songName;
        mArtistName = artistName;
    }

    //method to get song name
    public String getSongName() {
        return mSongName;
    }

    //method to get artist name
    public String getArtistName() {
        return mArtistName;
    }

}
