package id.sch.smktelkom_mlg.learn.skysportnewsvisionet;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import id.sch.smktelkom_mlg.learn.skysportnewsvisionet.model.Articles;

public class DetailActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Articles article = (Articles) getIntent().getSerializableExtra(MainActivity.ARTICLE);
        ImageView ivFoto = (ImageView) findViewById(R.id.imageViewFoto);
        TextView tvTitleDetail = (TextView) findViewById(R.id.textViewTitleDetail);
        TextView tvAuthorDetail = (TextView) findViewById(R.id.textViewAuthorDetail);
        TextView tvDescriptionDetail = (TextView) findViewById(R.id.textViewDescriptionDetail);
        TextView tvLink = (TextView) findViewById(R.id.textViewLink);
        TextView tvPublish = (TextView) findViewById(R.id.textViewPublish);

        setTitle("Sky Sport News");
        Picasso.with(context).load(article.getUrlToImage()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(ivFoto);
        tvTitleDetail.setText(article.getTitle());
        tvAuthorDetail.setText(article.getAuthor());
        tvDescriptionDetail.setText(article.getDescription());
        tvLink.setText(article.getUrl());
        tvPublish.setText(article.getPublishedAt());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}
