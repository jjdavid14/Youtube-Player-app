package com.jamiejdavid.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity
    implements View.OnClickListener
{
    private String GOOGLE_API_KEY = "AIzaSyB7BxLjMivftbbl1PsTDIjJylIcIqHZ9mg";
    private String YOUTUBE_VIDEO_ID = "EvzXps-qqO8";
    private String YOUTUBE_PLAYLIST_ID = "Lwcu5oSKcJ8&list=PLwSb0WB_WcrdYOBtVzM-p3RJhF24Rvvry";
    private Button btnPlayVideo;
    private Button btnPlayPlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnPlayVideo = (Button)findViewById(R.id.btnPlayVideo);
        btnPlayPlaylist = (Button)findViewById(R.id.btnPlayPlaylist);
        btnPlayVideo.setOnClickListener(this);
        btnPlayPlaylist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this,GOOGLE_API_KEY,YOUTUBE_VIDEO_ID);
                break;
            case R.id.btnPlayPlaylist:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this,GOOGLE_API_KEY,YOUTUBE_PLAYLIST_ID);
                break;
            default:
        }

        if(intent != null) {
            startActivity(intent);
        }
    }
}
