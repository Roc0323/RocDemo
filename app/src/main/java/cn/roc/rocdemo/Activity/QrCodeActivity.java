package cn.roc.rocdemo.Activity;

import android.graphics.Point;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import cn.roc.rocdemo.R;
import cn.roc.rocdemo.interfaces.OnScrollChangedListener;
import cn.roc.rocdemo.view.MyScrollView;

public class QrCodeActivity extends AppCompatActivity {

    private TextView tv_test;
    private MyScrollView sv_my_scrollview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        initView();
    }
    private void initView(){
        tv_test=(TextView)findViewById(R.id.tv_test);
        sv_my_scrollview=(MyScrollView)findViewById(R.id.sv_my_scrollview);
        sv_my_scrollview.setOnScrollChangedListener(new OnScrollChangedListener() {
            @Override
            public void onScrollChanged(int top, int oldTop) {
                Point p = new Point();
                getWindowManager().getDefaultDisplay().getSize(p);
                int screenWidth = p.x;
                int screenHeight = p.y;
                Rect rect = new Rect(0, 0, screenWidth, screenHeight);
                int[] location = new int[2];
                tv_test.getLocationInWindow(location);
                if (tv_test.getLocalVisibleRect(rect)) {
                    // 控件在屏幕可见区域
                    Log.i("TAG","textview在屏幕的可见区域");
                } else {
                    // 控件已不在屏幕可见区域（已滑出屏幕）
                    Log.i("TAG","textview已不在屏幕的可见区域");
                }
            }
        });



    }


}
