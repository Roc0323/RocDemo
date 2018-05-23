package cn.roc.rocdemo.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cn.roc.rocdemo.R;
import cn.roc.rocdemo.utils.ImgDataUtil;
import cn.roc.rocrecyclerviewlib.Divider.BaseItemDecoration;
import cn.roc.rocrecyclerviewlib.HeaderAndFooter.HeaderAndFooterRecyclerView;
import cn.roc.rocrecyclerviewlib.HeaderAndFooter.OnItemClickListener;
import cn.roc.rocrecyclerviewlib.HeaderAndFooter.OnItemLongClickListener;
import cn.roc.rocrecyclerviewlib.LayoutManager.WZMLinearLayoutManager;
import cn.roc.rocrecyclerviewlib.PullToLoad.OnLoadListener;
import cn.roc.rocrecyclerviewlib.PullToLoad.PullToLoadRecyclerView;
import cn.roc.rocrecyclerviewlib.PullToRefresh.OnRefreshListener;
import cn.roc.rocrecyclerviewlib.SimpleAdapter.SimpleAdapter;
import cn.roc.rocrecyclerviewlib.SimpleAdapter.ViewHolder;

public class RecyclerViewAddHead extends AppCompatActivity {
    private HeaderAndFooterRecyclerView rcv;
    private ArrayList<String> imgs;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_add_head);
        imgs = ImgDataUtil.getImgDatas();
        handler = new Handler();
        initView();
    }

    private void initView(){
        rcv = (HeaderAndFooterRecyclerView) findViewById(R.id.rcv);
        rcv.setLayoutManager(new WZMLinearLayoutManager(WZMLinearLayoutManager.VERTICAL));
//        设置适配器，封装后的适配器只需要实现一个函数
        rcv.setAdapter(new SimpleAdapter<String>(this, imgs, R.layout.item_test) {
            @Override
            protected void onBindViewHolder(ViewHolder holder, String data) {
                ImgDataUtil.loadImage(mContext, data, holder.<ImageView>getView(R.id.iv));
            }
        });
//        设置刷新监听
//        rcv.setOnRefreshListener(new OnRefreshListener() {
//            @Override
//            public void onStartRefreshing() {
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        imgs.clear();
//                        imgs.addAll(ImgDataUtil.getImgDatas());
//                        rcv.completeRefresh();
//                    }
//                }, 1000);
//            }
//        });
////        设置加载监听
//        rcv.setOnLoadListener(new OnLoadListener() {
//            @Override
//            public void onStartLoading(int skip) {
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        imgs.addAll(ImgDataUtil.getImgDatas());
//                        rcv.completeLoad();
//                    }
//                }, 1000);
//            }
//        });
//        设置分割线
        rcv.addItemDecoration(new BaseItemDecoration(this,R.color.white));

        rcv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                Toast.makeText(RecyclerViewAddHead.this, "item" + position + " has been clicked", Toast.LENGTH_SHORT).show();
            }
        });
        rcv.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(int position) {
                Toast.makeText(RecyclerViewAddHead.this, "item" + position + " has been long clicked", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_header:
                rcv.addHeaderView(getHeaderView());
                break;
            case R.id.btn_remove_header:
                if (headerViews.size()==0) return;
                rcv.removeHeaderView(headerViews.get(headerViews.size()-1));
                headerViews.remove(headerViews.size()-1);
                break;
            case R.id.btn_add_footer:
                rcv.addFooterView(getFooterView());
                break;
            case R.id.btn_remove_footer:
                if (footerViews.size()==0) return;
                rcv.removeFooterView(footerViews.get(footerViews.size() - 1));
                footerViews.remove(footerViews.size() - 1);
                break;
        }
    }

    private ArrayList<View> headerViews = new ArrayList<>();
    private ArrayList<View> footerViews = new ArrayList<>();

    private View getHeaderView() {
        View view = getLayoutInflater().inflate(R.layout.item_header,rcv,false);
        ((TextView) view.findViewById(R.id.tv)).setText("Header"+headerViews.size());
        headerViews.add(view);
        return view;
    }

    private View getFooterView() {
        View view = getLayoutInflater().inflate(R.layout.item_footer,rcv,false);
        ((TextView) view.findViewById(R.id.tv)).setText("Footer"+footerViews.size());
        footerViews.add(view);
        return view;
    }

}
