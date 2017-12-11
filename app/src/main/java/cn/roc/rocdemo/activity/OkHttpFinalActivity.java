package cn.roc.rocdemo.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import java.io.IOException;
import cn.roc.rocdemo.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpFinalActivity extends AppCompatActivity implements View.OnClickListener{

    private Handler handler=new Handler();

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
               initGetRequest();
               break;
           case R.id.btn_http_post:
               initPostRequest();
               break;
       }
    }
    public void initGetRequest(){
        String url = "https://www.baidu.com/";
        //1,创建OKHttpClient对象
        OkHttpClient mOkHttpClient=new OkHttpClient();
        //2,创建一个Request
        Request request = new Request.Builder().url(url).build();
        //3,创建一个call对象
        Call call = mOkHttpClient.newCall(request);
        //4,将请求添加到调度中
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               if(response.isSuccessful()){
                   Log.i("TAG","get请求数据成功");
                   Log.i("TAG","返回数据："+response.body().string());
                   handler.post(new Runnable() {
                       @Override
                       public void run() {
                           Toast.makeText(OkHttpFinalActivity.this,"get请求成功",Toast.LENGTH_SHORT).show();
                       }
                   });


               }
            }
        });


    }
    private  void initPostRequest(){

        String url = "http://test.gongchangtemai.com/index.php?url=shop/user/signin";
        //1,创建OKhttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //2,创建Request
        RequestBody formBody=new FormBody.Builder()
                .add("username","15121043032")
                .add("password","123456").build();

        Request request = new Request.Builder().url(url).post(formBody).build();
        //3，创建call对象并将请求对象添加到调度中
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    Log.i("TAG","post请求数据成功");
                    Log.i("TAG","返回数据为："+response.body().string());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(OkHttpFinalActivity.this,"post请求成功",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }

        });

    }



}
