package com.example.material.joanbarroso.interactiontrigger;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import butterknife.ButterKnife;

public class AreathumbTranslation extends BaseActivity {

    float y = 0;
    boolean triggered = false;
    private double size;
    private boolean down = false;
    int width;
    int height;

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
                break;
        }
        return super.dispatchTouchEvent(event);

    }

    private void moveScreenUp() {
        if (down) {
            down = !down;
            relativeLayout.setY(0);
            relativeLayout.setX(0);
            relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(width, height));
        }
    }

    private void moveScreenDown() {

        if (!down) {
            width = relativeLayout.getWidth();
            height = relativeLayout.getHeight();
            down = !down;
            relativeLayout.setY(relativeLayout.getHeight() / 3);
            relativeLayout.setX(relativeLayout.getWidth() / 3);
            relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(((relativeLayout.getWidth() / 3)*2), (relativeLayout.getHeight() / 3)*2));
        }
    }
}
