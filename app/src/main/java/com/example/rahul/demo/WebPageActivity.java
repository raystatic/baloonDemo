package com.example.rahul.demo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebPageActivity extends AppCompatActivity {

    WebView webView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);

        String url=getIntent().getStringExtra("url");

        getSupportActionBar().setTitle(url);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        progressDialog=new ProgressDialog(WebPageActivity.this);

        webView=findViewById(R.id.webview);


        Log.e("link",url+"");

//        webView.setWebViewClient(new MyWebViewClient());
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress==100)
                {
                    if (progressDialog.isShowing()&&progressDialog!=null)
                    {
                        progressDialog.dismiss();
                    }
                }
                else
                {
                    progressDialog.setMessage("Loading Page...");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();
                }
            }
        });
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(url);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
