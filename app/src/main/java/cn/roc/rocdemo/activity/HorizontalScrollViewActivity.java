package cn.roc.rocdemo.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.roc.rocdemo.adapter.HorizontalScrollViewAdapter;
import cn.roc.rocdemo.R;
import cn.roc.rocdemo.view.MyHorizontalScrollView;

public class HorizontalScrollViewActivity extends AppCompatActivity {
    private MyHorizontalScrollView mHorizontalScrollView;
    private HorizontalScrollViewAdapter mAdapter;
    private ImageView mImg;
    private List<Integer> mDatas = new ArrayList<Integer>(Arrays.asList(
            R.mipmap.a, R.mipmap.b, R.mipmap.c, R.mipmap.d,
            R.mipmap.e, R.mipmap.f, R.mipmap.g, R.mipmap.h,
            R.mipmap.l));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_scrollview);

        mImg = (ImageView) findViewById(R.id.id_content);

        mHorizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.id_horizontalScrollView);
        mAdapter = new HorizontalScrollViewAdapter(this, mDatas);
        //添加滚动回调
        mHorizontalScrollView
                .setCurrentImageChangeListener(new MyHorizontalScrollView.CurrentImageChangeListener()
                {
                    @Override
                    public void onCurrentImgChanged(int position,View viewIndicator)
                    {
                        mImg.setImageResource(mDatas.get(position));
                        viewIndicator.setBackgroundColor(Color.parseColor("#AA024DA4"));
                    }
                });
        //添加点击回调
        mHorizontalScrollView.setOnItemClickListener(new MyHorizontalScrollView.OnItemClickListener()
        {

            @Override
            public void onClick(View view, int position)
            {
                mImg.setImageResource(mDatas.get(position));
                view.setBackgroundColor(Color.parseColor("#AA024DA4"));
            }
        });
        //设置适配器
        mHorizontalScrollView.initDatas(mAdapter);

    }


}
