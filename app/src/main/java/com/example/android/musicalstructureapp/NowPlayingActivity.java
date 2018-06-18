package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        //TODO save current song state, when song is chosen, and when back to activity nowplayig continue to show it

        //TODO code to change button image form play to pause

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String currentSong = extras.getString("currentSong");
            String currentAuthor = extras.getString("currentAuthor");
            String currentAlbumTitle = extras.getString("currentAlbumTitle");
            int currentArtWork = extras.getInt("currentArtWork");

            TextView currentSongView = findViewById(R.id.currentTitle);
            currentSongView.setText(currentSong);

            TextView currentAuthorView = findViewById(R.id.currentArtist);
            currentAuthorView.setText(currentAuthor);

            TextView currentAlbumTitleTextView = findViewById(R.id.currentAlbum);
            currentAlbumTitleTextView.setText(currentAlbumTitle);

            ImageView currentArtWorkImageView = findViewById(R.id.current_artwork_nowPlaying);
            currentArtWorkImageView.setImageResource(currentArtWork);
        }

        ImageView returnButtonNowPlaying = findViewById(R.id.nowPlaying_back_image_view);
        returnButtonNowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnToMenuIntent = new Intent(NowPlayingActivity.this, MainActivity.class);
                startActivity(returnToMenuIntent);
            }
        });

    }
}
