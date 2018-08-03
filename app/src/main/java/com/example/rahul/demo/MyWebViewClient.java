package com.example.rahul.demo;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by rahul on 4/8/18.
 */

public class MyWebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
