package com.example.material.joanbarroso.interactiontrigger;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class DoubleTapDragActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                width = relativeLayout.getWidth();
                height = relativeLayout.getHeight();
                distanceY = event.getRawY();
                distanceX = event.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                if (triggered) {
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
                if (!triggered) {
                    relativeLayout.setY(0);
                    relativeLayout.setX(0);
                }
                triggered = false;
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public void onBackPressed() {
        ++backCount;
        if (backCount == 2) {
            backCount = 0;
            triggered = true;
        }
        if (triggered) {
            relativeLayout.setBackgroundColor(Color.parseColor("#11FF11"));
        }
    }
}
