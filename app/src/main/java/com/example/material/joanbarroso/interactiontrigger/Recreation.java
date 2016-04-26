package com.example.material.joanbarroso.interactiontrigger;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Recreation extends AppCompatActivity {

    boolean clickedOne;
    boolean clickedTwo;
    boolean clickedThree;
    boolean pendentToErase;
    boolean startPressed;
    @Bind(R.id.recreation_text)
    TextView textView;
    @Bind(R.id.button_1) Button button1;
    @Bind(R.id.button_2) Button button2;
    @Bind(R.id.button_3) Button button3;
    @Bind(R.id.button_4) Button button4;
    @Bind(R.id.erase_button) Button eraseButton;
    int green = Color.GREEN;
    int gray = Color.GRAY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recreation);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.accept_button)
    public void onAcceptButtonPressedep(View v) {
        if (textView.getText().toString().equals("hello") || textView.getText().toString().equals("Hello")) {
            eraseButton.setBackgroundColor(green);
            v.setBackgroundColor(gray);
            pendentToErase = true;
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
        else if (textView.getText().toString().equals("start") || textView.getText().toString().equals("Start")) {
            button1.setBackgroundColor(green);
            startPressed = true;
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }


    @OnClick(R.id.erase_button)
    public void onEraseButtonPressed() {
        if (pendentToErase) {
            textView.setText("");
            textView.setHint("type Start");
            eraseButton.setBackgroundColor(gray);
        }
    }
    @OnClick(R.id.button_1)
    public void onOneButtonPressed() {
        if (startPressed) {
            button1.setBackgroundColor(gray);
            button2.setBackgroundColor(green);
            clickedOne = true;
        }

    }
    @OnClick(R.id.button_2)
    public void onTwoButtonPressed () {
        if (clickedOne) {
            button2.setBackgroundColor(gray);
            button3.setBackgroundColor(green);
            clickedTwo = true;
        }

    }
    @OnClick(R.id.button_3)
    public void onThreeButtonPressedee () {
        if (clickedTwo) {
            button3.setBackgroundColor(gray);
            button4.setBackgroundColor(green);
            clickedThree = true;
        }
    }
    @OnClick(R.id.button_4)
    public void onFourButtonPressed() {
        if (clickedThree) {
            finishRecreation();
        }
    }

    private void finishRecreation() {

    }
}
