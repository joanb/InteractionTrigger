package com.example.material.joanbarroso.interactiontrigger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RelativeLayout;
import butterknife.Bind;

import java.util.List;

public abstract class BaseActivity extends AppCompatActivity {

    @Bind({R.id.button,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button8,R.id.button9,R.id.button10
            ,R.id.button11,R.id.button12,R.id.button13,R.id.button14,R.id.button15,R.id.button16,R.id.button17,R.id.button18,R.id.button19
            ,R.id.button20,R.id.button21,R.id.button22,R.id.button23,R.id.button24})
    List<Button> allButtons;
    @Bind(R.id.everything)
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ButterKnife.bind(this);

    }

}
