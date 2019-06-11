package com.hillavas.toolbox.activity.webView;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.hillavas.toolbox.R;

public class WebViewActivity extends AppCompatActivity {

    public static final String WEB_UTL = "web_url";
    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Intent mIntent = getIntent();
        url = mIntent.getStringExtra(WEB_UTL);


        WebView webView = (WebView) findViewById(R.id.www1);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl(url);

    }
}
