package com.d42gmail.cavar.ogmusicplayer;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    ArrayList<Song> songlist =new ArrayList<Song>();
    ImageView banner;
    TextView songInformation;
    SeekBar seekBar;
    ImageButton shufle,list,back,ffd,play;
    ListView listView;
    SongAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        banner= (ImageView) findViewById(R.id.imageView);
        songInformation= (TextView) findViewById(R.id.textView);
        seekBar= (SeekBar) findViewById(R.id.seekBar);
        shufle= (ImageButton) findViewById(R.id.imageButton2);
        list= (ImageButton) findViewById(R.id.imageButton);
        back= (ImageButton) findViewById(R.id.imageButton5);
        play= (ImageButton) findViewById(R.id.imageButton4);
        ffd= (ImageButton) findViewById(R.id.imageButton3);
        listView= (ListView) findViewById(R.id.listView);

        play.setBackgroundResource(R.drawable.play);
        back.setBackgroundResource(R.drawable.back);
        ffd.setBackgroundResource(R.drawable.ffd);


        adapter=new SongAdapter(getApplicationContext(),songlist);
        listView.setAdapter(adapter);
        getSongList();
        Collections.sort(songlist, new Comparator<Song>() {
            @Override
            public int compare(Song lhs, Song rhs) {
                return (lhs).getTitle().compareTo(rhs.getTitle());
            }
        });
        adapter.notifyDataSetChanged();



    }
    public void getSongList() {
        ContentResolver myMusicResolver = getContentResolver();
        Uri musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor musicCursor = myMusicResolver.query(musicUri, null, null, null, null);
        if(musicCursor!=null && musicCursor.moveToFirst()){
            int titleColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media.TITLE);
            int idColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media._ID);
            int artistColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media.ARTIST);
            do {
                long thisId = musicCursor.getLong(idColumn);
                String thisTitle = musicCursor.getString(titleColumn);
                String thisArtist = musicCursor.getString(artistColumn);
                songlist.add(new Song(thisId, thisTitle, thisArtist));
                adapter.notifyDataSetChanged();
            }
            while (musicCursor.moveToNext());
        }
    }
}
