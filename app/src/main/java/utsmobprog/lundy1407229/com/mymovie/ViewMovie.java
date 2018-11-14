package utsmobprog.lundy1407229.com.mymovie;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ViewMovie extends AppCompatActivity {

    String SOverview = new String("When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego \n Venom \n to save his life.");
    Button searchPlace ;
    TextView overviews,detai_overview;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_movie);
        searchPlace =  (Button)findViewById(R.id.btn_theater);
        overviews = (TextView)findViewById(R.id.tv_overview);
        detai_overview = (TextView)findViewById(R.id.tv_content_overview);
        img = (ImageView)findViewById(R.id.img_movie);


        overviews.setText("Overview");
        detai_overview.setText(SOverview);
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/original/VuukZLgaCrho2Ar8Scl9HtV3yD.jpg")
                .override(600,300)
                .into(img);
        //img.setImageURI(Uri.parse("https://image.tmdb.org/t/p/original/VuukZLgaCrho2Ar8Scl9HtV3yD.jpg"));

    }

    public void gotoMaps(View view) {
        Intent cinema= new Intent(this,CinemaOption.class);
        startActivity(cinema);
        this.finish();
    }
}
