package com.example.riversofpune;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Article Activity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WebView webView = findViewById(R.id.article_web_view);
        String currlink1 = "file:///android_asset/sample_file1/samplefileecosia.html";
        String currlink = "file:///android_asset/sample_file2/17thCentuary_change.docx.html";
        webView.loadUrl(currlink);
    }

}
