package com.example.material.joanbarroso.interactiontrigger;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class AreaThumbDragActivity extends BaseActivity {


    double size;
    long time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean tabletSize = getResources().getBoolean(R.bool.isTablet);
        if (tabletSize) {
            size = 0.7;
        } else {
            size = 0.026;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                width = relativeLayout.getWidth();
                height = relativeLayout.getHeight();
                distanceY = event.getRawY();
                distanceX = event.getRawX();
                time = System.currentTimeMillis();
                if (event.getSize() > size){
                    triggered = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (event.getSize() > size || triggered) {
                    triggered = true;
                    findViewById(R.id.everything).setBackgroundColor(Color.parseColor("#11FF11"));
                    relativeLayout.setX((event.getX()-distanceX)*2.3f);
                    relativeLayout.setY((event.getY()-distanceY)*2.3f);
                }
                else {
                    findViewById(R.id.everything).setBackgroundColor(Color.parseColor("#CCCCCC"));
                }
                Log.v("thisMotion", String.valueOf(event.getSize()));
                Log.v("Y", String.valueOf(event.getRawY()));
                break;
            case MotionEvent.ACTION_UP:
                findViewById(R.id.everything).setBackgroundColor(Color.parseColor("#CCCCCC"));
                if (triggered && System.currentTimeMillis() - time < 150) {
                    relativeLayout.setY(0);
                    relativeLayout.setX(0);
                }
                triggered =  false;
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public void onBackPressed() {
        ++backCount;
        if(backCount == 2) {
            backCount = 0;
            triggered = !triggered;
        }
        if (triggered) {
            relativeLayout.setBackgroundColor(Color.parseColor("#11FF11"));
        }
    }
}
