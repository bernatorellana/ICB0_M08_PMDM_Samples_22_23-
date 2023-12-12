package org.milaifontanals.webviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.milaifontanals.webviewapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.webView2.getSettings().setJavaScriptEnabled(true);



        mBinding.webView2.loadUrl("file:///android_asset/index.html");
        mBinding.webView2.setWebChromeClient(new WebChromeClient());

        mBinding.webView.setWebViewClient( new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                //return super.shouldOverrideUrlLoading(view, request);
                if(!request.getUrl().toString().contains(".google.com")){
                    view.loadData("<html><body><h1>ERROR PIRATILLA</h1></body></html>",
                            "text/html", "utf-8");
                    return false;
                }
                view.loadUrl(request.getUrl().toString());
                return true;
            }
        });
        mBinding.webView2.addJavascriptInterface(new JavaInterface(), "JavaInterface");


        mBinding.btnGo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String url = mBinding.edtURL.getText().toString();
        mBinding.webView.loadUrl(url);



    }
}