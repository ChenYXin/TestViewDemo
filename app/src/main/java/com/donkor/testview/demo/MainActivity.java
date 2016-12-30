package com.donkor.testview.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button btnDemo1, btnDemo2, btnDemo3, btnDemo4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = (Button) findViewById(R.id.btnDemo1);
        btnDemo2 = (Button) findViewById(R.id.btnDemo2);
        btnDemo3 = (Button) findViewById(R.id.btnDemo3);
        btnDemo4 = (Button) findViewById(R.id.btnDemo4);

        btnDemo1.setOnClickListener(this);
        btnDemo2.setOnClickListener(this);
        btnDemo3.setOnClickListener(this);
        btnDemo4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnDemo1:
                intent=new Intent(MainActivity.this,FirstTestViewDemoActivity.class);
                startActivity(intent);
                break;
            case R.id.btnDemo2:
                intent=new Intent(MainActivity.this,SecondTestViewDemoActivity.class);
                startActivity(intent);
                break;
            case R.id.btnDemo3:
                intent=new Intent(MainActivity.this,ThirdTestViewDemoActivity.class);
                startActivity(intent);
                break;
            case R.id.btnDemo4:
                intent=new Intent(MainActivity.this,FourthTestViewDemoActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
