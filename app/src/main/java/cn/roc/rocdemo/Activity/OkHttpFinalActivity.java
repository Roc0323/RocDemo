package cn.roc.rocdemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.finalteam.okhttpfinal.HttpCycleContext;
import cn.finalteam.okhttpfinal.RequestParams;
import cn.roc.rocdemo.R;

public class OkHttpFinalActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_final);
        initView();
    }
    private void initView(){
        findViewById(R.id.btn_http_get).setOnClickListener(this);
        findViewById(R.id.btn_http_post).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.btn_http_get:
               break;
           case R.id.btn_http_post:
               break;
       }
    }
    private  void initGetRequest(){
//        RequestParams params = new RequestParams((HttpCycleContext) this);
//        params.addFormDataPart("page",);
//        params.addFormDataPart("limit", 12);
    }
    private  void initPostRequest(){

    }



}
