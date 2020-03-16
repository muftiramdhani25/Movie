package net.growdev.movie.adapters;

import android.widget.ImageView;

import net.growdev.movie.models.Movie;

public interface MovieItemClickListener {

    void onMovieClick(Movie movie, ImageView movieImageView); // we will need the imageview to make shared animation between two activity
}
