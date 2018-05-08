package com.dohman.apigrupparbete;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetailActivity extends AppCompatActivity {



    private ImageView image;

    private TextView title, date, rating, overview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Intent intent=getIntent();


        image = (ImageView) findViewById(R.id.imageMain);

        title = (TextView) findViewById(R.id.title);

        date = (TextView)findViewById(R.id.textYear);

        rating = (TextView)findViewById(R.id.textRating);

        overview = (TextView) findViewById(R.id.textPlot);

        //Getting the value from bundle, means the value which we had during switching to this activity from main activity
        MovieDetails details = (MovieDetails) getIntent().getExtras().getSerializable("MOVIE_DETAILS");

        if(details !=null)
        {
            //Showing image from the movie db api into imageview using glide library
            Glide.with(this).load("https://image.tmdb.org/t/p/w500/"+ details.getImage()).into(image);
            title.setText(details.getTitle());
            date.setText(details.getRelease_year());
            rating.setText(Double.toString(details.getRating()));
            overview.setText(details.getPlot());
        }
    }
}
