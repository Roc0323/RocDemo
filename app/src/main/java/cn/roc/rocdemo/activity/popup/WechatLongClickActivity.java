package cn.roc.rocdemo.activity.popup;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.roc.rocdemo.R;
import cn.roc.rocdemo.utils.PopupWindowList;

/**
 * Created by Roc on 2018/7/26.
 */

public class WechatLongClickActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechat_long_click);
    }
    public void leftTop(View v){
        Log.e("TAG", "rightTop");
        showPopWindows(v);
    }
    public void rightTop(View v){
        Log.e("TAG", "rightTop");
        showPopWindows(v);
    }

    public void middle(View v){
        Log.e("TAG", "middle");
        showPopWindows(v);
    }

    public void leftBottom(View v){
        Log.e("TAG", "leftBottom");
        showPopWindows(v);
    }
    public void rightBottom(View v){
        Log.e("TAG", "rightTop");
        showPopWindows(v);
    }

    private PopupWindowList mPopupWindowList;
    private void showPopWindows(View view){
        List<String> dataList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            dataList.add(String.valueOf(i));
        }
        if (mPopupWindowList == null){
            mPopupWindowList = new PopupWindowList(view.getContext());
        }
        mPopupWindowList.setAnchorView(view);
        mPopupWindowList.setItemData(dataList);
        mPopupWindowList.setModal(true);
        mPopupWindowList.show();
        mPopupWindowList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("TAG", "click position="+position);
                Toast.makeText(WechatLongClickActivity.this,"click position="+position,Toast.LENGTH_SHORT).show();
                mPopupWindowList.hide();
            }
        });
    }
}
