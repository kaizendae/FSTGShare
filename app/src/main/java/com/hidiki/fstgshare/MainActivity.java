package com.hidiki.fstgshare;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView Browser;
    private Button BtnPrevious;
    private Button BtnNext;
    private Button BtnExit;
    private String PreviousUrl;
    private String NextUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Browser = (WebView)findViewById(R.id.idBrowser);
        Browser.getSettings().setJavaScriptEnabled(true);
        BtnPrevious = (Button)findViewById(R.id.BtnPrevious);
        BtnNext = (Button)findViewById(R.id.BtnNext);
        BtnExit = (Button)findViewById(R.id.BtnExit);

        final Activity activity = this;

        Browser.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

        Browser.loadUrl("https://fstg-share.blogspot.com/");
        PreviousUrl = Browser.getUrl();

    }
    public void Previous(View Target){
        Browser.loadUrl(PreviousUrl);
        PreviousUrl = Browser.getUrl();
    }
    public void Next(View Target){

    }
}
