package net.growdev.movie.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import net.growdev.movie.R;
import net.growdev.movie.adapters.CastAdapter;
import net.growdev.movie.models.Cast;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView MovieThumbnailImg, MovieCoverImg;
    private TextView tv_title, tv_description;
    private FloatingActionButton play_fab;
    private RecyclerView RvCast;
    private CastAdapter castAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        // get the data
        iniViews();

        //setup list cast
        setupRvCast();

    }

    void iniViews(){
        RvCast = findViewById(R.id.rv_cast);
        play_fab = findViewById(R.id.play_fab);
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imagecover = getIntent().getExtras().getInt("imgCover");
        MovieThumbnailImg = findViewById(R.id.detail_movie_img);
        Glide.with(this).load(imageResourceId).into(MovieThumbnailImg);
        MovieThumbnailImg.setImageResource(imageResourceId);
        MovieCoverImg = findViewById(R.id.detail_movie_cover);
        Glide.with(this).load(imagecover).into(MovieCoverImg);
        tv_title = findViewById(R.id.detail_movie_title);
        tv_title.setText(movieTitle);
        getSupportActionBar().setTitle(movieTitle);
        tv_description = findViewById(R.id.detail_movie_desc);
        //setup animation
//        MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this ,R.anim.scale_animation));
//        play_fab.setAnimation(AnimationUtils.loadAnimation(this ,R.anim.scale_animation));
    }

    void setupRvCast(){

        List<Cast> mdata = new ArrayList<>();
        mdata.add(new Cast("name", R.drawable.robert));
        mdata.add(new Cast("name", R.drawable.bose));
        mdata.add(new Cast("name", R.drawable.mark));
        mdata.add(new Cast("name", R.drawable.jordan));
        mdata.add(new Cast("name", R.drawable.chris));
        mdata.add(new Cast("name", R.drawable.evans));

        castAdapter = new CastAdapter(this, mdata);
        RvCast.setAdapter(castAdapter);
        RvCast.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }
}
