package net.growdev.movie.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import net.growdev.movie.models.Movie;
import net.growdev.movie.adapters.MovieAdapter;
import net.growdev.movie.adapters.MovieItemClickListener;
import net.growdev.movie.R;
import net.growdev.movie.models.Slide;
import net.growdev.movie.adapters.SliderPagerAdapter;
import net.growdev.movie.utils.DataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> lstSlides;
    private ViewPager sliderPager;
    private TabLayout indicator;
    private RecyclerView MoviesRW, moviesRVWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        iniViews();
        iniSlider();
        iniPopularMovies();
        iniWeekMovies();

    }

    private void iniWeekMovies() {
        MovieAdapter weekMoviesAdapter = new MovieAdapter(this, DataSource.getWeekMovies(), this);
        moviesRVWeek.setAdapter(weekMoviesAdapter);
        moviesRVWeek.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }

    private void iniPopularMovies() {
        // recycler setup
        // isi data
        MovieAdapter movieAdapter = new MovieAdapter(this, DataSource.getPopulerMovies(), this);
        MoviesRW.setAdapter(movieAdapter);
        MoviesRW.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void iniSlider() {
        // prepare a list of Slides
        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.slide1, "Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide2, "Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide1, "Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide2, "Slide Title \nmore text here"));
        SliderPagerAdapter adapter = new SliderPagerAdapter(this, lstSlides);
        sliderPager.setAdapter(adapter);
        // setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000 );
        indicator.setupWithViewPager(sliderPager, true);
    }

    private void iniViews() {
        sliderPager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        MoviesRW = findViewById(R.id.Rv_movies);
        moviesRVWeek = findViewById(R.id.rv_movies_week);


    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
        // here we send movie information to detail activity
        // also we ll create the transition animation between activity

        Intent intent = new Intent(this, MovieDetailActivity.class);
        // send movie information to detail activity
        intent.putExtra("title", movie.getTitle());
        intent.putExtra("imgURL", movie.getThumbnail());
        intent.putExtra("imgCover", movie.getCoverPhoto());
        //startActivity(intent);

        // lets create the animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this, movieImageView, "sharedName");

        startActivity(intent, options.toBundle());
        // i ll make a simple test to see if the click work

        Toast.makeText(this, "item clicked : " + movie.getTitle(), Toast.LENGTH_SHORT).show();
    }

    class SliderTimer extends TimerTask{
        @Override
        public void run() {
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderPager.getCurrentItem() < lstSlides.size() - 1){
                        sliderPager.setCurrentItem(sliderPager.getCurrentItem() + 1);
                    }
                    else
                        sliderPager.setCurrentItem(0);
                }
            });
        }
    }
}
