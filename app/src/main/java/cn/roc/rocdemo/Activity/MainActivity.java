package cn.roc.rocdemo.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bigkoo.alertview.AlertView;

import java.util.ArrayList;
import java.util.List;

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
        findViewById(R.id.btn_okhttp).setOnClickListener(this);
        findViewById(R.id.btn_add_head).setOnClickListener(this);
        findViewById(R.id.btn_qrcode).setOnClickListener(this);
        findViewById(R.id.btn_nine_gongge).setOnClickListener(this);
        findViewById(R.id.btn_activity_transition_animation).setOnClickListener(this);
        findViewById(R.id.btn_wechat_popup).setOnClickListener(this);
        findViewById(R.id.btn_horizontal_scrollView).setOnClickListener(this);
        findViewById(R.id.btn_share_nine_image).setOnClickListener(this);
        findViewById(R.id.btn_nice_label).setOnClickListener(this);
        findViewById(R.id.btn_socket).setOnClickListener(this);
        findViewById(R.id.btn_sd_file_operation).setOnClickListener(this);
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
            case R.id.btn_okhttp:
                Intent intent_okhttp=new Intent(this,OkHttpFinalActivity.class);
                startActivity(intent_okhttp);
                break;
            case R.id.btn_add_head:
                Intent intent_recyclerview=new Intent(this,RecyclerViewAddHead.class);
                startActivity(intent_recyclerview);
                break;
            case R.id.btn_qrcode:
                Intent intent_qrcode=new Intent(this,QrCodeActivity.class);
                startActivity(intent_qrcode);
                break;
            case R.id.btn_nine_gongge:
                Intent intent_nine_gongge=new Intent(this,NineGongGeAcitivy.class);
                startActivity(intent_nine_gongge);
                break;
            case R.id.btn_activity_transition_animation:
                Intent intent_transition=new Intent(this,TransitionOneActivity.class);
                startActivity(intent_transition);
                break;
            case R.id.btn_wechat_popup:
                Intent intent_wechat_popup=new Intent(this,WechatPopupActivity.class);
                startActivity(intent_wechat_popup);
                break;
            case R.id.btn_horizontal_scrollView:
                Intent intent_horizontal_scrlllview=new Intent(this,HorizontalScrollViewActivity.class);
                startActivity(intent_horizontal_scrlllview);
                break;
            case R.id.btn_share_nine_image:
                Intent intent_share_nine=new Intent(this,ShareNineImageActivity.class);
                startActivity(intent_share_nine);
                break;
            case R.id.btn_nice_label:
                Intent intent_nice_label=new Intent(this,NiceLabelActivity.class);
                startActivity(intent_nice_label);
                break;
            case R.id.btn_socket:
                Intent intent_socket=new Intent(this,SocketTestActivity.class);
                startActivity(intent_socket);
                break;
            case R.id.btn_sd_file_operation:
                Intent intent_sd_file_operation=new Intent(this,FileOperationActivity.class);
                startActivity(intent_sd_file_operation);
                break;
        }
    }
}
