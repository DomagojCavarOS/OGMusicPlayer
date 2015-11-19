package com.d42gmail.cavar.ogmusicplayer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Enigma on 19.11.2015..
 */
public class SongAdapter extends BaseAdapter {
    Context ctx;
    ArrayList<Song> Songlist1;

    public SongAdapter(Context ctx, ArrayList<Song> songlist1) {
        this.ctx = ctx;
        Songlist1 = songlist1;
    }

    @Override
    public int getCount() {
        return Songlist1.size();
    }

    @Override
    public Object getItem(int position) {
        return Songlist1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView=View.inflate(ctx,R.layout.songlayout,null);
        }

        Song current=Songlist1.get(position);
        ImageView Avatar= (ImageView) convertView.findViewById(R.id.imagelist);
        TextView Title= (TextView) convertView.findViewById(R.id.titlelist);
        TextView Artist= (TextView) convertView.findViewById(R.id.artisttitle);

        Avatar.setImageResource(current.getIcon());
        Title.setText(""+current.getTitle());
        Artist.setText(""+current.getArtist());



        return convertView;
    }
}
