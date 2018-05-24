package cn.roc.rocdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import cn.roc.rocdemo.R;
import cn.roc.rocdemo.adapter.SamplePagerAdapter;
import cn.roc.rocdemo.custom_view.circleindicator.CircleIndicator;

/**
 * Created by Roc on 2018/5/24.
 */

public class CircleIndicatorTwo extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_indicator_two);
        ViewPager viewpager = (ViewPager)findViewById(R.id.vp_viewpager);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.ci_indicator);
        viewpager.setAdapter(new SamplePagerAdapter());
        indicator.setViewPager(viewpager);
    }
}
