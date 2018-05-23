package cn.roc.rocdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.roc.rocdemo.R;
import cn.roc.rocdemo.utils.MultiImageViewLayout;

/**
 * Created by Roc on 2018/5/14.
 */

public class NineGongGeActivity2 extends Activity{
//    public static final String[] PHOTOS = {
//            "http://f.hiphotos.baidu.com/image/pic/item/faf2b2119313b07e97f760d908d7912396dd8c9c.jpg",
//            "http://g.hiphotos.baidu.com/image/pic/item/4b90f603738da977c76ab6fab451f8198718e39e.jpg",
//            "http://e.hiphotos.baidu.com/image/pic/item/902397dda144ad343de8b756d4a20cf430ad858f.jpg",
//            "http://a.hiphotos.baidu.com/image/pic/item/a6efce1b9d16fdfa0fbc1ebfb68f8c5495ee7b8b.jpg",
//            "http://b.hiphotos.baidu.com/image/pic/item/a71ea8d3fd1f4134e61e0f90211f95cad1c85e36.jpg",
//            "http://c.hiphotos.baidu.com/image/pic/item/7dd98d1001e939011b9c86d07fec54e737d19645.jpg",
//            "http://f.hiphotos.baidu.com/image/pic/item/f11f3a292df5e0fecc3e83ef586034a85edf723d.jpg",
//            "http://pica.nipic.com/2007-10-17/20071017111345564_2.jpg",
//            "http://pic4.nipic.com/20091101/3672704_160309066949_2.jpg",
//            "http://pic4.nipic.com/20091203/1295091_123813163959_2.jpg",
//            "http://pic2.ooopic.com/11/79/98/31bOOOPICb1_1024.jpg"};
public static final String[] PHOTOS = {
        "http://f.hiphotos.baidu.com/image/pic/item/faf2b2119313b07e97f760d908d7912396dd8c9c.jpg",
        "http://g.hiphotos.baidu.com/image/pic/item/4b90f603738da977c76ab6fab451f8198718e39e.jpg",
        "http://e.hiphotos.baidu.com/image/pic/item/902397dda144ad343de8b756d4a20cf430ad858f.jpg",
        "http://a.hiphotos.baidu.com/image/pic/item/a6efce1b9d16fdfa0fbc1ebfb68f8c5495ee7b8b.jpg",
        "http://b.hiphotos.baidu.com/image/pic/item/a71ea8d3fd1f4134e61e0f90211f95cad1c85e36.jpg",
        "http://c.hiphotos.baidu.com/image/pic/item/7dd98d1001e939011b9c86d07fec54e737d19645.jpg",
        "http://f.hiphotos.baidu.com/image/pic/item/f11f3a292df5e0fecc3e83ef586034a85edf723d.jpg",
        "http://pica.nipic.com/2007-10-17/20071017111345564_2.jpg",
        "http://pic4.nipic.com/20091101/3672704_160309066949_2.jpg"};

    private List<String> mStrings = new ArrayList<String>();
    private MultiImageViewLayout mMultiImageViewLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_gongge2);

        for (int i = 0; i < PHOTOS.length; i++) {
            mStrings.add(PHOTOS[i]);
        }
        mMultiImageViewLayout = (MultiImageViewLayout) findViewById(R.id.multiimage);
        mMultiImageViewLayout.setList(mStrings);
        mMultiImageViewLayout.setOnItemClickListener(new MultiImageViewLayout.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int PressImagePosition, float PressX, float PressY) {
                //System.out.println("view = [" + view + "], PressImagePosition = [" + PressImagePosition + "], PressX = [" + PressX + "], PressY = [" + PressY + "]");
                Toast.makeText(NineGongGeActivity2.this,"点击事件："+PressImagePosition,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int PressImagePosition, float PressX, float PressY) {
               // System.out.println("view = [" + view + "], PressImagePosition = [" + PressImagePosition + "], PressX = [" + PressX + "], PressY = [" + PressY + "]");
                Toast.makeText(NineGongGeActivity2.this,"长按事件："+PressImagePosition,Toast.LENGTH_SHORT).show();
            }

        });
    }
}
