package cn.roc.rocdemo.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bigkoo.alertview.AlertView;

import cn.roc.rocdemo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        findViewById(R.id.btn_okgo).setOnClickListener(this);
        findViewById(R.id.btn_dialog).setOnClickListener(this);
        findViewById(R.id.btn_mine_select_photo).setOnClickListener(this);
        findViewById(R.id.btn_mine_coordinator_layout).setOnClickListener(this);
        findViewById(R.id.btn_mine_pop_test).setOnClickListener(this);
        findViewById(R.id.ll_shuibo).setOnClickListener(this);
        findViewById(R.id.btn_okhttp).setOnClickListener(this);
        findViewById(R.id.btn_add_head).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_okgo:
                Intent intent=new Intent(this,OkgoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_dialog:
                Intent intent_dialog=new Intent(this,DialogActivity.class);
                startActivity(intent_dialog);
                break;
            case R.id.btn_mine_select_photo:
                Intent intent_select=new Intent(this,SelectPhotoActivity.class);
                startActivity(intent_select);
                break;
            case R.id.btn_mine_coordinator_layout:
                Intent intent_coordinator=new Intent(this,CoordinatorLayout.class);
                startActivity(intent_coordinator);
                break;
            case R.id.btn_mine_pop_test:
                Intent intent_pop=new Intent(this,PopTest.class);
                startActivity(intent_pop);
                break;
            case R.id.ll_shuibo:
                //Toast.makeText(this,"水波效果",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_okhttp:
                Intent intent_okhttp=new Intent(this,OkHttpFinalActivity.class);
                startActivity(intent_okhttp);
                break;
            case R.id.btn_add_head:
                Intent intent_recyclerview=new Intent(this,RecyclerViewAddHead.class);
                startActivity(intent_recyclerview);
                break;
        }
    }
}
