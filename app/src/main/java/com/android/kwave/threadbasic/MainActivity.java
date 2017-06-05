package com.android.kwave.threadbasic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button test, basic, rain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test = (Button) findViewById(R.id.test);
        basic = (Button) findViewById(R.id.basic);
        rain = (Button) findViewById(R.id.rain);
        test.setOnClickListener(this);
        basic.setOnClickListener(this);
        rain.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch(v.getId()){

            case R.id.test :
                intent = new Intent(MainActivity.this, TestActivity.class);

                break;

            case R.id.basic :
                intent = new Intent(MainActivity.this, ThreadBasicActivity.class);

                break;
            case R.id.rain :
                intent = new Intent(MainActivity.this, RainActivity.class);

                break;
        }
        startActivity(intent);
    }
}
