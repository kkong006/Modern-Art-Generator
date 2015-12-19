package com.example.karen.modernartui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

public class momaWebView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moma_web_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        WebView viewMoma = new WebView(this);
        setContentView(viewMoma);
        viewMoma.loadUrl("http://www.moma.org/learn/moma_learning/themes/what-is-modern-art");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
