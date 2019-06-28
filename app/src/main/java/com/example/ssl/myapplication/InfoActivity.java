package com.example.ssl.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {
    private ImageView imageid;
    private TextView titles;
    private TextView contents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        imageid=(ImageView)findViewById(R.id.imageI);
        titles=(TextView) findViewById(R.id.tv_title);
        contents=(TextView) findViewById(R.id.tv_content);

        Intent intent =getIntent();
        int imageId=intent.getIntExtra("imageID",-1);
        String title=intent.getStringExtra("title");
        String content=intent.getStringExtra("content");

        imageid.setImageResource(imageId);
        titles.setText(title);
        contents.setText(content);

    }
}
