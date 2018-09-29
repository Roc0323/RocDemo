package cn.roc.rocdemo.holder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.roc.rocdemo.R;
import cn.roc.rocdemo.bean.ListCountDownBean;
import cn.roc.rocdemo.custom_view.SnapUpCountDownTimerView;

/**
 * Created by Administrator on 2018/9/29.
 */

public class ListCountDownHolder extends MessageTypeCommenHolder<ListCountDownBean>{

    private TextView tv_cd_content;
    private SnapUpCountDownTimerView snap_count_down;

    public ListCountDownHolder(Context context, ViewGroup root) {
        super(context, root, R.layout.hoder_list_count_down);
    }

    @Override
    public void bindData(ListCountDownBean listCountDownBean) {
        tv_cd_content = (TextView)itemView.findViewById(R.id.tv_cd_content);
        snap_count_down =(SnapUpCountDownTimerView)itemView.findViewById(R.id.snap_count_down);
        if (listCountDownBean!=null){
            //tv_cd_content.setText(listCountDownBean.getName());
            snap_count_down.setTime(listCountDownBean.getHour(),listCountDownBean.getMinute(),listCountDownBean.getSecond());
            snap_count_down.start();
        }

    }


}
