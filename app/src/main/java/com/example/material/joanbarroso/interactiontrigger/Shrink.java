package com.example.material.joanbarroso.interactiontrigger;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import butterknife.ButterKnife;

public class Shrink extends BaseActivity {

    float y = 0;
    boolean triggered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttons_screen);
        ButterKnife.bind(this);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                y = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (event.getSize() > 0.026) {
                    findViewById(R.id.everything).setBackgroundColor(Color.parseColor("#11FF11"));
                    triggered = true;
                }
                else
                    findViewById(R.id.everything).setBackgroundColor(Color.parseColor("#CCCCCC"));

                Log.v("thisMotion", String.valueOf(event.getSize()));
                Log.v("Y", String.valueOf(event.getRawY()));
                break;
            case MotionEvent.ACTION_UP:
                findViewById(R.id.everything).setBackgroundColor(Color.parseColor("#CCCCCC"));
                if (y < event.getRawY()+60 && triggered){
                    moveScreenDown();
                    triggered = false;
                }
                else if (y > event.getRawY()+60 && triggered)
                    moveScreenUp();
                    triggered = false;
                break;
        }
        return false;
    }

    private void moveScreenUp() {
        relativeLayout.setY(0);
    }

    private void moveScreenDown() {
        relativeLayout.setY(500);
    }
}
