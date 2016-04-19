package com.example.material.joanbarroso.interactiontrigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.drag)
    public void onDragClicked() {
        startActivity(new Intent(getApplicationContext(), AreaThumbScroll.class));
    }

    @OnClick(R.id.transalte)
    public void onTranslateClicked() {
        startActivity(new Intent(getApplicationContext(), Shrink.class));
    }

}
