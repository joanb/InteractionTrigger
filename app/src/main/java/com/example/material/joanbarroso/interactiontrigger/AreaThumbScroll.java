package com.example.material.joanbarroso.interactiontrigger;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class AreaThumbScroll extends BaseActivity {

    private float distanceY;
    private float distanceX;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttons_screen);
        relativeLayout = (RelativeLayout) findViewById(R.id.everything);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                distanceY = event.getRawY();
                distanceX = event.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                if (event.getSize() > 0.026) {
                    findViewById(R.id.everything).setBackgroundColor(Color.parseColor("#11FF11"));
                    relativeLayout.setX(event.getX()-distanceX);
                    relativeLayout.setY(event.getY()-distanceY);
                }
                else {
                    findViewById(R.id.everything).setBackgroundColor(Color.parseColor("#CCCCCC"));
                }
                Log.v("thisMotion", String.valueOf(event.getSize()));
                Log.v("Y", String.valueOf(event.getRawY()));
                break;
            case MotionEvent.ACTION_UP:
                findViewById(R.id.everything).setBackgroundColor(Color.parseColor("#CCCCCC"));
                break;
        }
        return false;
    }
}
