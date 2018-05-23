package cn.roc.rocdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import cn.roc.rocdemo.R;

/**
 * Created by Roc on 2018/5/14.
 */

public class NineGongGeSelect extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_select);
        findViewById(R.id.btn_nine_one).setOnClickListener(this);
        findViewById(R.id.btn_nine_two).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_nine_one:
                Intent intent_nine_gongge1=new Intent(this,NineGongGeAcitivy.class);
                startActivity(intent_nine_gongge1);
                break;
            case R.id.btn_nine_two:
                Intent intent_nine_gongge2=new Intent(this,NineGongGeActivity2.class);
                startActivity(intent_nine_gongge2);
                break;
        }
    }
}
