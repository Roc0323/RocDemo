package cn.roc.rocdemo.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import cn.roc.rocdemo.adapter.NineGongGeAdapter;
import cn.roc.rocdemo.bean.NineGridBean;
import cn.roc.rocdemo.R;
import cn.roc.rocdemo.event.EmptyEvent;
import cn.roc.rocdemo.event.NineGongGeEvent;
import cn.roc.rocdemo.imagewatcher.ImageWatcher;
import de.greenrobot.event.EventBus;

public class NineGongGeAcitivy extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private NineGongGeAdapter mAdapter;
    private List<NineGridBean> mList;
    private List<String> sList;
    private List<ImageView> imageViewList;
    private Context mContext;

    private String[] mUrls = new String[]{"http://d.hiphotos.baidu.com/image/h%3D200/sign=201258cbcd80653864eaa313a7dca115/ca1349540923dd54e54f7aedd609b3de9c824873.jpg",
            "http://img3.fengniao.com/forum/attachpics/537/165/21472986.jpg",
            "http://d.hiphotos.baidu.com/image/h%3D200/sign=ea218b2c5566d01661199928a729d498/a08b87d6277f9e2fd4f215e91830e924b999f308.jpg",
            "http://img4.imgtn.bdimg.com/it/u=3445377427,2645691367&fm=21&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=2644422079,4250545639&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=1444023808,3753293381&fm=21&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=882039601,2636712663&fm=21&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=4119861953,350096499&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=2437456944,1135705439&fm=21&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=3251359643,4211266111&fm=21&gp=0.jpg",
            "http://img4.duitang.com/uploads/item/201506/11/20150611000809_yFe5Z.jpeg",
            "http://img5.imgtn.bdimg.com/it/u=1717647885,4193212272&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=2024625579,507531332&fm=21&gp=0.jpg"};
    private ImageWatcher iw_nine_watcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_gong_ge_acitivy);
        mContext=this;
        initData();
        initView();
    }

    private void initData(){
        mList=new ArrayList<NineGridBean>();
        sList=new ArrayList<String>();
        imageViewList=new ArrayList<ImageView>();
        NineGridBean model1 = new NineGridBean();
        model1.urlList.add(mUrls[0]);
        model1.urlList.add(mUrls[2]);
        model1.urlList.add(mUrls[3]);
        model1.urlList.add(mUrls[4]);
        model1.urlList.add(mUrls[5]);
        model1.urlList.add(mUrls[6]);
        model1.urlList.add(mUrls[7]);
        model1.urlList.add(mUrls[8]);
        model1.urlList.add(mUrls[9]);

        model1.urlList2.add(mUrls[0]);
        model1.urlList2.add(mUrls[2]);
        model1.urlList2.add(mUrls[3]);
        model1.urlList2.add(mUrls[4]);
        model1.urlList2.add(mUrls[5]);
        model1.urlList2.add(mUrls[6]);
        model1.urlList2.add(mUrls[7]);
        model1.urlList2.add(mUrls[8]);
        model1.urlList2.add(mUrls[9]);
        mList.add(model1);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rl_nine_gong_ge);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new NineGongGeAdapter(this);
        mAdapter.setList(mList);
        mRecyclerView.setAdapter(mAdapter);
        iw_nine_watcher=(ImageWatcher)findViewById(R.id.iw_nine_watcher);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /**
     * 在父Activity中加上一个空事件  不同Actiivty或者不同类之间的事件传送
     * @param event
     */
    public void  onEvent(EmptyEvent event){
    }


    public void onEvent(NineGongGeEvent event){
        if(event.isStatus()){

//            Log.i("TAG","UrlList的数量："+event.getUrlList().size());
//
//            Log.i("TAG","UrlList2的数量："+event.getUrlList2().size());
//
//            Log.i("TAG","ImageList的数量："+event.getImageList().size());

            iw_nine_watcher.show(event.getImageView(),event.getImageList(),event.getUrlList());
        }
    }


}
