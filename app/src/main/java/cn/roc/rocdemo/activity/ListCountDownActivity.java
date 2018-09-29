package cn.roc.rocdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.roc.rocdemo.R;
import cn.roc.rocdemo.adapter.ListCountDownAdapter;
import cn.roc.rocdemo.bean.ListCountDownBean;

/**
 * Created by Administrator on 2018/9/29.
 */

public class ListCountDownActivity extends Activity{
    private RecyclerView recycler_count_down;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_count_down);
        recycler_count_down=(RecyclerView) findViewById(R.id.recycler_count_down);
        List<ListCountDownBean> myList = new ArrayList<>();
        myList.add(new ListCountDownBean(4,04,56));
        myList.add(new ListCountDownBean(1,23,21));
        myList.add(new ListCountDownBean(8,39,02));
        myList.add(new ListCountDownBean(3,33,32));
        myList.add(new ListCountDownBean(2,21,51));
        myList.add(new ListCountDownBean(00,01,00));
        myList.add(new ListCountDownBean(5,34,36));
        myList.add(new ListCountDownBean(5,34,36));
        myList.add(new ListCountDownBean(5,34,36));
        myList.add(new ListCountDownBean(5,34,36));
        myList.add(new ListCountDownBean(5,34,36));
        myList.add(new ListCountDownBean(5,34,36));
        myList.add(new ListCountDownBean(5,34,36));
        //创建默认的线性LayoutManager
        mLayoutManager = new LinearLayoutManager(this);
        recycler_count_down.setLayoutManager(mLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        recycler_count_down.setHasFixedSize(true);
        ListCountDownAdapter adapter = new ListCountDownAdapter(myList);
        recycler_count_down.setAdapter(adapter);

    }
}
