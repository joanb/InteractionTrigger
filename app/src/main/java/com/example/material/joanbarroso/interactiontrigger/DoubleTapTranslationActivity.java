package com.example.material.joanbarroso.interactiontrigger;

import android.os.Bundle;

public class DoubleTapTranslationActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        ++backCount;
        if (backCount == 2) {
            backCount = 0;
            if (!down)
                moveScreenDown();
            else
                moveScreenUp();
        }
    }
}