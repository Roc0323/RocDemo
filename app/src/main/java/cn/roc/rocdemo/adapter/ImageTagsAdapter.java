package cn.roc.rocdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.moxun.tagcloudlib.view.TagsAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.roc.rocdemo.bean.Tag3DBean;
import cn.roc.rocdemo.R;

/**
 * Created by moxun on 16/3/4.
 */
public class ImageTagsAdapter extends TagsAdapter {


    private ImageView iv_brand;
    private List<Tag3DBean> myList = new ArrayList<Tag3DBean>();

    public ImageTagsAdapter(List<Tag3DBean> myList) {
        this.myList = myList;
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public View getView(final Context context, final int position, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_image_tag_item, parent, false);
        iv_brand=(ImageView)view.findViewById(R.id.iv_brand);
        iv_brand.setImageResource(myList.get(position).getImgUrl());
        iv_brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"您点击的是"+myList.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public int getPopularity(int position) {
        return position % 5;
    }

    @Override
    public void onThemeColorChanged(View view, int themeColor) {
        //view.findViewById(R.id.android_eye).setBackgroundColor(themeColor);
    }
}
