package cn.roc.rocdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import cn.roc.rocdemo.R;
import cn.roc.rocdemo.view.BrandFlow;


/**
 * Created by Roc on 2017/12/7.
 */

public class RandomPositionActivity extends Activity{


    private String[] keywords = new String[] {
            "http://brand.logoids.com/upload/image/201701/2017011917490225391.jpg",
            "http://brand.logoids.com/upload/image/201611/201611202300226872.png",
            "http://brand.logoids.com/upload/image/201611/2016110913161984310.jpg",
            "http://brand.logoids.com/upload/image/201701/201701080753388472.jpg",
            "http://brand.logoids.com/upload/image/201611/201611081307543589.jpg",
            "http://brand.logoids.com/upload/image/201609/2016092800091554484.jpg",
            "http://brand.logoids.com/upload/image/201609/2016092700135949082.jpg",
            "http://brand.logoids.com/upload/image/201611/2016110814263525824.jpg",
//            "http://brand.logoids.com/upload/image/201702/2017020420265272906.jpg",
//            "http://brand.logoids.com/upload/image/201612/2016121516365798388.jpg",
//            "http://brand.logoids.com/upload/image/201702/2017020520225122603.jpg",
//            "http://brand.logoids.com/upload/image/201611/20161123164856541.png",
//            "http://brand.logoids.com/upload/image/201611/2016110913161984310.jpg",
            "http://brand.logoids.com/upload/image/201611/2016111811102773670.jpg",
            "http://brand.logoids.com/upload/image/201701/2017011916425218048.jpg",
            "http://brand.logoids.com/upload/image/201611/2016110812394314910.jpg",
            "http://brand.logoids.com/upload/image/201609/2016092917174279148.jpg"};
    private int[] brands=new int[]{
            R.mipmap.brand_logo_01,
            R.mipmap.brand_logo_02,
            R.mipmap.brand_logo_03,
            R.mipmap.brand_logo_04,
            R.mipmap.brand_logo_05,
            R.mipmap.brand_logo_06,
            R.mipmap.brand_logo_07,
            R.mipmap.brand_logo_08,
            R.mipmap.brand_logo_09,
            R.mipmap.brand_logo_10,

    };



    private BrandFlow bf_brand;
    private List<Integer> numList=new ArrayList<Integer>();
    private boolean isStop=true;
    private Button btn_refresh;
    private Button btn_yici_show;
    //private ImageView img_gif;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_position);
        initView();
        refreshTags();

    }
    private void initView(){
        //img_gif=(ImageView)findViewById(R.id.img_gif);
//        Glide.with(RandomPositionActivity.this).load(R.drawable.ss)
//                .diskCacheStrategy(DiskCacheStrategy.ALL).into(img_gif);
        bf_brand = (BrandFlow) findViewById(R.id.bf_brand);
        btn_refresh=(Button)findViewById(R.id.btn_refresh);
        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                bf_brand.rubAllViews();
//                refreshTags();
//                bf_brand.show();
                bf_brand.brandHide(brands.length);
                bf_brand.oneAndOneShow(brands.length);

            }
        });
        btn_yici_show=(Button)findViewById(R.id.btn_yici_show);
        btn_yici_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bf_brand.oneAndOneShow(brands.length);
            }
        });

    }

    private void refreshTags() {

        //initSearchHistory();
        //bf_brand.setDuration(800L);
        bf_brand.setOnItemClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(RandomPositionActivity.this,"发生点击事件",Toast.LENGTH_SHORT).show();
            }
        });
        // 添加
        feedKeywordsFlow(bf_brand, brands);
//        bf_brand.go2Show(BrandFlow.ANIMATION_IN);
    }

    private void feedKeywordsFlow(final BrandFlow bf_brand, int[] arr) {
        Random random = new Random();
        while (isStop){

            int ran = random.nextInt(arr.length);
            if(!numList.contains(ran)){
                numList.add(ran);
                final int tmp = arr[ran];
                bf_brand.feedKeyword(tmp);

            }
            if(numList.size()==arr.length){
                isStop=false;
            }
        }
    }

}
