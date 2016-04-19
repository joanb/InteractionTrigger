package com.example.material.joanbarroso.interactiontrigger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnTouch;

import java.util.List;

public abstract class BaseActivity extends AppCompatActivity {

    @Bind({R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button8, R.id.button9, R.id.button10
            , R.id.button11, R.id.button12, R.id.button13, R.id.button14, R.id.button15, R.id.button16, R.id.button17, R.id.button18, R.id.button19
            , R.id.button20, R.id.button21, R.id.button22, R.id.button23, R.id.button24})
    List<Button> allButtons;
    @Bind(R.id.everything)
    RelativeLayout relativeLayout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttons_screen);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(BaseActivity.this, "sda", Toast.LENGTH_SHORT).show();
        return false;
    }

    @OnTouch({R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button8, R.id.button9, R.id.button10
            , R.id.button11, R.id.button12, R.id.button13, R.id.button14, R.id.button15, R.id.button16, R.id.button17, R.id.button18, R.id.button19
            , R.id.button20, R.id.button21, R.id.button22, R.id.button23, R.id.button24})
    public boolean buttonPressed(View view, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            Toast.makeText(BaseActivity.this, String.valueOf(view.getId()), Toast.LENGTH_SHORT).show();
        }
        return true;
    }

}
