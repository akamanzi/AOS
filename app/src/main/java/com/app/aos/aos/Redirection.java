package com.app.aos.aos;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Arnold on 11/12/15.
 */
public class Redirection extends ActionBarActivity{
    WebView webView;
    String url;

     ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        setContentView(webView);
        webView.setWebViewClient(new webviewClient());


        Intent geturl = getIntent();
        url = geturl.getStringExtra("url");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
       // webView.clearHistory();
       // webView.clearCache(true);
        webView.loadUrl(url);

    }


    public class webviewClient extends WebViewClient{


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            String link= Uri.parse(url).getHost().toString();
            Log.d("passedUrl",link);
            return true;        }


        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            progressDialog = new ProgressDialog(Redirection.this);
            progressDialog.setMessage("Loading Page....");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            if (progressDialog.isShowing()){
                progressDialog.dismiss();
            }

            super.onPageFinished(view, url);
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        webView.loadUrl(url);
    }

    @Override
    protected void onStart() {
        super.onStart();
        webView.loadUrl(url);
    }
}
