package cn.roc.rocdemo.activity;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.mobike.library.MobikeView;

import java.util.ArrayList;
import java.util.List;

import cn.roc.rocdemo.bean.MobikeBean;
import cn.roc.rocdemo.R;

/**
 * Created by Roc on 2017/11/29.
 */

public class MobikeTagActivity extends Activity{
    private Context mContext;
    private MobikeView mobikeView;
    private SensorManager sensorManager;
    private Sensor defaultSensor;
    private List<MobikeBean> mList=new ArrayList<MobikeBean>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobike_tag);
        mContext=this;
        mobikeView = (MobikeView) findViewById(R.id.mobike_view);
        initData();
        initViews();

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        defaultSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //CircleD

    }


    private void initData(){
        mList.add(new MobikeBean(1,R.mipmap.share_fb,"耐克"));
        mList.add(new MobikeBean(2,R.mipmap.share_kongjian,"阿迪达斯"));
        mList.add(new MobikeBean(3,R.mipmap.share_pyq,"乔丹"));
        mList.add(new MobikeBean(4,R.mipmap.share_qq,"报喜鸟"));
        mList.add(new MobikeBean(5,R.mipmap.share_tw,"拉夏贝尔"));
        mList.add(new MobikeBean(6,R.mipmap.share_wechat,"回力"));
        mList.add(new MobikeBean(7,R.mipmap.share_weibo,"匹克"));
        mList.add(new MobikeBean(8,R.mipmap.goods_image_share,"安踏"));
    }

    private void initViews() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        //测试
        for(int i = 0; i <mList.size(); i ++){
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(mList.get(i).getmImg());
            imageView.setTag(R.id.mobike_view_circle_tag,true);
            mobikeView.addView(imageView,layoutParams);
            final int finalI = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MobikeTagActivity.this,"点击的是"+mList.get(finalI).getmName(),Toast.LENGTH_SHORT).show();
                }
            });
        }

    }



    @Override
    protected void onStart() {
        super.onStart();
        mobikeView.getmMobike().onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mobikeView.getmMobike().onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(listerner, defaultSensor, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(listerner);
    }


    //senser监听
    private SensorEventListener listerner = new SensorEventListener(){

        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
                float x =  event.values[0];
                float y =   event.values[1] * 2.0f;
                mobikeView.getmMobike().onSensorChanged(-x,y);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
}
