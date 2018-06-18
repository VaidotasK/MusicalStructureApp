package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ArtistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);

        // Create a list of artists
        ArrayList<Song> artists = new ArrayList<Song>();
        artists.add(new Song("Addicted", "Simple Plan",
                "No pads, no helmets...just balls",
                R.drawable.album_artwork_simple_plan_no_pads_no_helmets_just_balls_48px));
        artists.add(new Song("My Alien", "Simple Plan"));
        artists.add(new Song("Zoe Jane", "Staind", "14 shades of grey",
                R.drawable.album_artwork_staind_14_shades_of_grey_48px));
        artists.add(new Song("So Far Away", "Staind", "14 shades of grey",
                R.drawable.album_artwork_staind_14_shades_of_grey_48px));
        artists.add(new Song("All I Want", "Staind", "The illusion of progress",
                R.drawable.album_artwork_staind_the_illusion_of_progress_48px));
        artists.add(new Song("Save Me", "Staind", "The illusion of progress",
                R.drawable.album_artwork_staind_the_illusion_of_progress_48px));
        artists.add(new Song("I Promised Myslef", "BassHunter"));
        artists.add(new Song("Freefall", "Armin van Buuren ft. BullySongs"));
        artists.add(new Song("So Far Away ", "Avenged Sevenfold"));
        artists.add(new Song("Runaway", "Avril Lavigne"));

        // Create an {@link ArtistsAdapter}, whose data source is a list of {@link Artists}s. The
        // adapter knows how to create list items for each item in the list.
        ArtistsAdapter adapter = new ArtistsAdapter(this, artists);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called artists_list_view, which is declared in the
        // activity_artists.xml layout file.
        ListView listView = findViewById(R.id.artists_list_view);

        // Make the {@link ListView} use the {@link ArtistsAdapter} which was created above, so that the
        // {@link ListView} will display list items for each {@link Song} in the list.
        listView.setAdapter(adapter);

//        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
//        // There should be a {@link ListView} with the view ID called artists_list_view, which is declared in the
//        // activity_artists.xml layout file.
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent artistIntent = new Intent(ArtistsActivity.this, ArtistActivity.class);
//                startActivity(artistIntent);
//            }
//        });

        // Image with ID songs_back_image_view, in activity_songs.xml, return to main activity
        ImageView returnButtonArtists = findViewById(R.id.artists_back_image_view);
        returnButtonArtists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnToMenuIntent = new Intent(ArtistsActivity.this, MainActivity.class);
                startActivity(returnToMenuIntent);
            }
        });

    }
}
