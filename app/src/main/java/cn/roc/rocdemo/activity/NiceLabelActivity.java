package cn.roc.rocdemo.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import cn.roc.rocdemo.bean.LabelBean;
import cn.roc.rocdemo.R;
import cn.roc.rocdemo.view.LabelView.LabelView;

public class NiceLabelActivity extends AppCompatActivity {
    private LabelView mLabelView;
    private LabelView mLabelViewRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nice_label);
        mLabelView = (LabelView) findViewById(R.id.labelView);
        mLabelViewRight = (LabelView) findViewById(R.id.labelview_right);

        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        LabelBean labelBean = new LabelBean(LabelBean.LABEL_TYPE_TOPIC, LabelBean.DIRECTION_LEFT, 300, 300, 80, 50, "就你最好看", 30, 30, 0, "");
        mLabelView.initData(labelBean, true, true);
        mLabelView.setMax(wm.getDefaultDisplay().getWidth(), wm.getDefaultDisplay().getHeight());
        mLabelView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NiceLabelActivity.this,"点击了标签",Toast.LENGTH_SHORT).show();
            }
        });

        LabelBean labelBeanRight = new LabelBean(LabelBean.LABEL_TYPE_BRAND, LabelBean.DIRECTION_RIGHT, 100, 100, 100, 50, "李一桐", 30, 30, 0, "");
        mLabelViewRight.initData(labelBeanRight, true, true);
        mLabelViewRight.setMax(wm.getDefaultDisplay().getWidth(), wm.getDefaultDisplay().getHeight());
    }
}
