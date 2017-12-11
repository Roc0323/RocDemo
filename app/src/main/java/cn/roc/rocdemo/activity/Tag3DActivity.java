package cn.roc.rocdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.moxun.tagcloudlib.view.TagCloudView;

import java.util.ArrayList;
import java.util.List;

import cn.roc.rocdemo.adapter.ImageTagsAdapter;
import cn.roc.rocdemo.bean.Tag3DBean;
import cn.roc.rocdemo.R;

/**
 * Created by Roc on 2017/12/8.
 */

public class Tag3DActivity extends Activity{
    private TagCloudView tagCloudView;
    private List<Tag3DBean> myList=new ArrayList<Tag3DBean>();
    private ImageTagsAdapter imageTagsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3d_tag);
        initData();
        tagCloudView = (TagCloudView) findViewById(R.id.tag_cloud);
//        tagCloudView.setBackgroundColor(Color.LTGRAY);
        imageTagsAdapter = new ImageTagsAdapter(myList);
        tagCloudView.setAdapter(imageTagsAdapter);

        //缩放动画，设置缩放中心点。
        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1,
                Animation.RELATIVE_TO_SELF, 0.5F,
                Animation.RELATIVE_TO_SELF, 0.5F);
        sa.setDuration(1500);
        tagCloudView.startAnimation(sa);


    }

    private void initData(){

        myList.add(new Tag3DBean(1,R.mipmap.brand_logo_01,"彪马"));
        myList.add(new Tag3DBean(2,R.mipmap.brand_logo_02,"范斯"));
        myList.add(new Tag3DBean(3,R.mipmap.brand_logo_03,"阿迪达斯"));
        myList.add(new Tag3DBean(4,R.mipmap.brand_logo_04,"卡骆驰"));
        myList.add(new Tag3DBean(5,R.mipmap.brand_logo_05,"李宁"));
        myList.add(new Tag3DBean(6,R.mipmap.brand_logo_06,"耐克"));
        myList.add(new Tag3DBean(7,R.mipmap.brand_logo_07,"茵宝"));
        myList.add(new Tag3DBean(8,R.mipmap.brand_logo_08,"新百伦"));
        myList.add(new Tag3DBean(9,R.mipmap.brand_logo_09,"不知道啥品牌"));
        myList.add(new Tag3DBean(10,R.mipmap.brand_logo_10,"匡威"));
        myList.add(new Tag3DBean(11,R.mipmap.brand_logo_11,"阿迪达斯"));
        myList.add(new Tag3DBean(12,R.mipmap.brand_logo_12,"卡帕"));
        myList.add(new Tag3DBean(13,R.mipmap.brand_logo_13,"361度"));
        myList.add(new Tag3DBean(14,R.mipmap.brand_logo_14,"乔丹体育"));
        myList.add(new Tag3DBean(15,R.mipmap.brand_logo_15,"锐步"));
        myList.add(new Tag3DBean(16,R.mipmap.brand_logo_16,"华黛思"));
        myList.add(new Tag3DBean(17,R.mipmap.brand_logo_17,"鸿星尔克"));
        myList.add(new Tag3DBean(18,R.mipmap.brand_logo_01,"彪马"));
        myList.add(new Tag3DBean(19,R.mipmap.brand_logo_02,"范斯"));
        myList.add(new Tag3DBean(20,R.mipmap.brand_logo_03,"阿迪达斯"));

    }
}
