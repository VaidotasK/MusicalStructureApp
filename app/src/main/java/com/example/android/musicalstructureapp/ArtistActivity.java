package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ArtistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String currentArtistArtist = extras.getString("currentArtistArtist");

            TextView currentArtistArtistView = findViewById(R.id.artist_name);
            currentArtistArtistView.setText(currentArtistArtist);
        }

        ImageView returnButtonNowPlaying = findViewById(R.id.artist_back_image_view);
        returnButtonNowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnToArtistsIntent = new Intent(ArtistActivity.this, ArtistsActivity.class);
                startActivity(returnToArtistsIntent);
            }
        });

    }
}


