package com.example.material.joanbarroso.interactiontrigger;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RelativeLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnTouch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class BaseActivity extends AppCompatActivity {

    @Bind({R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button8, R.id.button9, R.id.button10
            , R.id.button11, R.id.button12, R.id.button13, R.id.button14, R.id.button15, R.id.button16, R.id.button17, R.id.button18, R.id.button19
            , R.id.button20, R.id.button21, R.id.button22, R.id.button23, R.id.button24})
    List<Button> allButtons;
    @Bind(R.id.everything)
    RelativeLayout relativeLayout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.chronometer)
    Chronometer chronometer;
    List<Button> randomButtons;
    boolean testInProgress;
    Random random;
    int lastRandomNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttons_screen);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        randomButtons = new ArrayList<>();
        testInProgress = false;
        random = new Random();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        prepareAndStartTest();
        item.setVisible(false);
        return false;
    }

    private void prepareAndStartTest() {
        lastRandomNumber = -1;
        for (int i = 0; i < 20; ++i) {
            int randomNumber;
            if (i%4 == 0){
                do {
                    randomNumber = random.nextInt(7);
                } while (randomNumber == lastRandomNumber);
            }
            else {
                do {
                    randomNumber = random.nextInt(23);
                } while (randomNumber == lastRandomNumber);
            }
            lastRandomNumber = randomNumber;
            randomButtons.add(allButtons.get(randomNumber));
        }
        setNewButtonToClick();
        chronometer.start();
        testInProgress = true;
    }

    @OnTouch({R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button8, R.id.button9, R.id.button10
            , R.id.button11, R.id.button12, R.id.button13, R.id.button14, R.id.button15, R.id.button16, R.id.button17, R.id.button18, R.id.button19
            , R.id.button20, R.id.button21, R.id.button22, R.id.button23, R.id.button24})
    public boolean buttonPressed(View view, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (testInProgress) {
                if (view == randomButtons.get(0)) {
                    randomButtons.get(0).setBackgroundColor(Color.DKGRAY);
                    randomButtons.remove(0);
                    relativeLayout.setY(0);
                    relativeLayout.setX(0);
                    if (randomButtons.isEmpty()) {
                        finnishTest();
                    } else {
                        setNewButtonToClick();
                    }
                }
            }
        }
        return true;
    }

    protected void finnishTest() {
        chronometer.stop();
    }

    protected void setNewButtonToClick() {
        randomButtons.get(0).setBackgroundColor(Color.GREEN);
    }

}
