package com.example.material.joanbarroso.interactiontrigger;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import butterknife.ButterKnife;

public class AreathumbTranslation extends BaseActivity {

    float y = 0;
    boolean triggered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                y = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (event.getSize() > 0.026) {
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
        relativeLayout.setY(0);
    }

    private void moveScreenDown() {
        relativeLayout.setY(relativeLayout.getHeight()/2);
    }
}
