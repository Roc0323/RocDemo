package cn.roc.rocdemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import cn.roc.rocdemo.R;
import cn.roc.rocdemo.imagewatcher.ImageWatcher;
import cn.roc.rocdemo.net.MyImageLoderManager;

public class PopTest extends AppCompatActivity implements View.OnClickListener{

    private ImageView iv_image_big_one;
    private ImageView iv_image_big_two;
    private ImageView iv_image_big_three;
    private ImageWatcher iw_watcher;
    private List<ImageView> imageViewList=new ArrayList<ImageView>();
    private List<String> imageUrlList=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_test);
        initView();
        initData();
    }
    private void initData(){
        imageUrlList.add("http://img5.imgtn.bdimg.com/it/u=1444023808,3753293381&fm=21&gp=0.jpg");
        imageUrlList.add("http://img4.imgtn.bdimg.com/it/u=3445377427,2645691367&fm=21&gp=0.jpg");
        imageUrlList.add("http://img4.imgtn.bdimg.com/it/u=2644422079,4250545639&fm=21&gp=0.jpg");
    }
    private void initView(){
        iv_image_big_one=(ImageView)findViewById(R.id.iv_image_big_one);
        MyImageLoderManager.loadeImage("http://img5.imgtn.bdimg.com/it/u=1444023808,3753293381&fm=21&gp=0.jpg",iv_image_big_one);
        iv_image_big_two=(ImageView)findViewById(R.id.iv_image_big_two);
        MyImageLoderManager.loadeImage("http://img4.imgtn.bdimg.com/it/u=3445377427,2645691367&fm=21&gp=0.jpg",iv_image_big_two);
        iv_image_big_three=(ImageView)findViewById(R.id.iv_image_big_three);
        MyImageLoderManager.loadeImage("http://img4.imgtn.bdimg.com/it/u=2644422079,4250545639&fm=21&gp=0.jpg",iv_image_big_three);
        iv_image_big_one.setOnClickListener(this);
        iv_image_big_two.setOnClickListener(this);
        iv_image_big_three.setOnClickListener(this);
        imageViewList.add(iv_image_big_one);
        imageViewList.add(iv_image_big_two);
        imageViewList.add(iv_image_big_three);
        iw_watcher=(ImageWatcher)findViewById(R.id.iw_watcher);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_image_big_one:
                iw_watcher.show(iv_image_big_one,imageViewList,imageUrlList);
                break;
            case R.id.iv_image_big_two:
                iw_watcher.show(iv_image_big_two,imageViewList,imageUrlList);
                break;
            case R.id.iv_image_big_three:
                iw_watcher.show(iv_image_big_three,imageViewList,imageUrlList);
                break;
        }
    }
}
