package cn.roc.rocdemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.callback.StringCallback;

import cn.roc.rocdemo.Bean.ConfigBean;
import cn.roc.rocdemo.R;
import okhttp3.Call;
import okhttp3.Response;

public class OkgoActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okgo);
        initView();
    }
    private void initView(){
        findViewById(R.id.btn_okgo_get_request).setOnClickListener(this);
    }
    private void initGetData(){
//        OkGo.<ConfigBean>post("http://ddbuyapi.gongchangtemai.com/index.php?url=shop/config")     // 请求方式和请求url
//                .tag(this)                       // 请求的 tag, 主要用于取消对应的请求
//                .execute(new)





    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.btn_okgo_get_request:
               initGetData();
               break;
       }
    }
}
