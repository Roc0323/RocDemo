package cn.roc.rocdemo.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.roc.rocdemo.R;
import cn.roc.rocdemo.view.wechat_popup.CommentPopup;

public class WechatPopupActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView iv_popup_show;
    private Context mContext;
    private CommentPopup mCommentPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechat_popup);
        mContext=this;
        initView();
    }
    private void initView(){
        iv_popup_show=(ImageView)findViewById(R.id.iv_popup_show);
        iv_popup_show.setOnClickListener(this);
        mCommentPopup = new CommentPopup(this);
        mCommentPopup.setOnCommentPopupClickListener(new CommentPopup.OnCommentPopupClickListener() {
            @Override
            public void onLikeClick(View v, TextView likeText) {
                if (v.getTag() == null) {
                    v.setTag(1);
                    likeText.setText("取消");
                }
                else {
                    switch ((int) v.getTag()) {
                        case 0:
                            v.setTag(1);
                            likeText.setText("取消");
                            break;
                        case 1:
                            v.setTag(0);
                            likeText.setText("赞  ");
                            break;
                    }
                }
            }

            @Override
            public void onCommentClick(View v) {
                Toast.makeText(mContext,"评论",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_popup_show:
                mCommentPopup.showPopupWindow(v);
                break;
        }

    }
}
