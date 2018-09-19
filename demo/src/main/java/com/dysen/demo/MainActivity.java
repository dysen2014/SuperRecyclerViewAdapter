package com.dysen.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by dysen on 2018/9/19.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtn1;
    private Button mBtn2;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mBtn1 = (Button) findViewById(R.id.btn_base_type);
        mBtn2 = (Button) findViewById(R.id.btn_more_type);

        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
    }

    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_base_type:
                startActivity(new Intent(MainActivity.this, BaseTypeActivity.class));
                break;
            case R.id.btn_more_type:
                startActivity(new Intent(MainActivity.this, MoreTypeActivity.class));
                break;
        }
    }
}
