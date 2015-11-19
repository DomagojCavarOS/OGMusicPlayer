package com.d42gmail.cavar.ogmusicplayer;

/**
 * Created by Enigma on 19.11.2015..
 */
public class Song {
    long Id;
    int Icon;
    String Title;
    String Artist;


    public Song(long id, int icon, String title, String artist) {
        Id = id;
        Icon=icon;
        Title = title;
        Artist = artist;
    }

    public Song(long id, String title, String artist) {
        Id = id;
        Icon=R.drawable.musicicon;
        Title = title;
        Artist = artist;
    }

    public long getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }

    public String getTitle() {
        return Title;

    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }
}
