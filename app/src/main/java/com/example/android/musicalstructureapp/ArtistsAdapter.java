package com.example.android.musicalstructureapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Garra on 2018-05-23.
 */


public class ArtistsAdapter extends ArrayAdapter<Song> {

    /**
     * Create a new {@link ArtistsAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param artists
     */
    public ArtistsAdapter(Context context, ArrayList<Song> artists) {
        super(context, 0, artists);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.artists_list_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        final Song currentSong = getItem(position);

        //TODO code to delete dublicate artists - show artist only once

        // Find the TextView in the artists_list_item.xml layout with the ID artists_artist_text_view.
        TextView artistTextView = listItemView.findViewById(R.id.artists_artist_text_view);
        // Get the Song Artist  from the currentSong object and set this text on
        // the artist TextView.
        artistTextView.setText(currentSong.getArtist());

        // Find the ImageView in the song_list_item.xml layout with the album_artwork_image_view ID .
        ImageView imageView = listItemView.findViewById(R.id.artists_artWork_image_view);
        // Check if an image is provided for this song or not
        if (currentSong.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentSong.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise show default image and (set visibility to VISIBLE)
            imageView.setImageResource(R.drawable.icon_album_artwork_default_48px);
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        }

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistIntent = new Intent(getContext(), ArtistActivity.class);

                artistIntent.putExtra("currentArtistSong", currentSong.getSongTitle());
                artistIntent.putExtra("currentArtistArtist", currentSong.getArtist());

                if (currentSong.hasAlbumTitle()) {
                    artistIntent.putExtra("currentArtistAlbumTitle", currentSong.getAlbumTitle());
                } else {
                    artistIntent.putExtra("currentAlbumTitle", "Unknown");
                }


                if (currentSong.hasImage()) {
                    artistIntent.putExtra("currentArtistArtWork", currentSong.getImageResourceId());
                } else {
                    artistIntent.putExtra("currentArtistArtWork", R.drawable.icon_album_artwork_default_48px);
                }

                getContext().startActivity(artistIntent);

            }
        });

        return listItemView;
    }


}