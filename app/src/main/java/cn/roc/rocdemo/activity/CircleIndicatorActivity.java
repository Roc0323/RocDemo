package cn.roc.rocdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import cn.roc.rocdemo.R;

/**
 * Created by Roc on 2018/5/24.
 */

public class CircleIndicatorActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_indicator);
        initView();
    }
    private void initView(){
        findViewById(R.id.btn_circle_indicator_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one = new Intent(CircleIndicatorActivity.this,CircleIndicatorOne.class);
                startActivity(intent_one);
            }
        });
        findViewById(R.id.btn_circle_indicator_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_two = new Intent(CircleIndicatorActivity.this,CircleIndicatorTwo.class);
                startActivity(intent_two);
            }
        });
        findViewById(R.id.btn_circle_indicator_three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_three = new Intent(CircleIndicatorActivity.this,CircleIndicatorThree.class);
                startActivity(intent_three);
            }
        });
    }
}
