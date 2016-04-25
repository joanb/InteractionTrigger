package com.example.material.joanbarroso.interactiontrigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {


    WebView webview;
    private boolean triggered;
    private float y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webview = ((WebView) findViewById(R.id.webView));
        webview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String   failingUrl) {

            }
        });
        webview.loadUrl("http://www.google.com");
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                y = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (event.getSize() > 0.026) {
                    triggered = true;
                } else

                Log.v("thisMotion", String.valueOf(event.getSize()));
                Log.v("Y", String.valueOf(event.getRawY()));
                break;
            case MotionEvent.ACTION_UP:
                if (y < event.getRawY() + 60 && triggered) {
                    moveScreenDown();
                } else if (y > event.getRawY() + 60 && triggered)
                    moveScreenUp();
                triggered = false;
                break;
        }
        return super.dispatchTouchEvent(event);

    }

    private void moveScreenUp() {
        webview.setY(0);
    }

    private void moveScreenDown() {
        webview.setY(webview.getHeight()/2);
    }
}