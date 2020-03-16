package net.growdev.movie.utils;

import net.growdev.movie.R;
import net.growdev.movie.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Movie> getPopulerMovies(){

        List<Movie> lslMovies = new ArrayList<>();
        lslMovies.add(new Movie("Black Panther", R.drawable.black, R.drawable.cover ));
        lslMovies.add(new Movie("Mortal Machine", R.drawable.cewek, R.drawable.cover ));
        lslMovies.add(new Movie("Fantastic Beast", R.drawable.sulap ));
        lslMovies.add(new Movie("Venom", R.drawable.venom ));
        lslMovies.add(new Movie("Black Panther", R.drawable.black ));
        lslMovies.add(new Movie("Mortal Machine", R.drawable.cewek ));
        lslMovies.add(new Movie("Fantastic Beast", R.drawable.sulap ));
        lslMovies.add(new Movie("Venom", R.drawable.venom ));

        return lslMovies;
    }

    public static List<Movie> getWeekMovies(){

        List<Movie> lslMovies = new ArrayList<>();
        lslMovies.add(new Movie("Venom", R.drawable.venom ));
        lslMovies.add(new Movie("Fantastic Beast", R.drawable.sulap ));
        lslMovies.add(new Movie("Mortal Machine", R.drawable.cewek ));
        lslMovies.add(new Movie("Black Panther", R.drawable.black ));
        lslMovies.add(new Movie("Venom", R.drawable.venom ));
        lslMovies.add(new Movie("Fantastic Beast", R.drawable.sulap ));
        lslMovies.add(new Movie("Mortal Machine", R.drawable.cewek, R.drawable.cover ));
        lslMovies.add(new Movie("Black Panther", R.drawable.black, R.drawable.cover ));

        return lslMovies;


    }
}
