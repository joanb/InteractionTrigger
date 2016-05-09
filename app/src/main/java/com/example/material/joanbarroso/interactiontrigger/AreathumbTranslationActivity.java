package com.example.material.joanbarroso.interactiontrigger;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import butterknife.ButterKnife;

public class AreathumbTranslationActivity extends BaseActivity {

    private double size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        boolean tabletSize = getResources().getBoolean(R.bool.isTablet);
        if (tabletSize) {
            size = 0.7;
        } else {
            size = 0.026;
        }

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                y = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (event.getSize() > size) {
                    findViewById(R.id.everything).setBackgroundColor(Color.parseColor("#11FF11"));
                    triggered = true;
                } else
                    findViewById(R.id.everything).setBackgroundColor(Color.parseColor("#CCCCCC"));

                Log.v("thisMotion", String.valueOf(event.getSize()));
                Log.v("Y", String.valueOf(event.getRawY()));
                break;
            case MotionEvent.ACTION_UP:
                findViewById(R.id.everything).setBackgroundColor(Color.parseColor("#CCCCCC"));
                if (y < event.getRawY() + 60 && triggered) {
                    moveScreenDown();
                } else if (y > event.getRawY() + 60 && triggered)
                    moveScreenUp();
                triggered = false;
                break;
        }
        return super.dispatchTouchEvent(event);

    }
}
