package cn.roc.rocdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import cn.roc.rocdemo.bean.ListCountDownBean;
import cn.roc.rocdemo.holder.ListCountDownHolder;
import cn.roc.rocdemo.holder.MessageTypeCommenHolder;

/**
 * Created by Administrator on 2018/9/29.
 */

public class ListCountDownAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ListCountDownBean> myList;//数据

    public ListCountDownAdapter(List<ListCountDownBean> myList) {
        this.myList = myList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListCountDownHolder(parent.getContext(),parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MessageTypeCommenHolder<ListCountDownBean>) holder).bindData(myList.get(position));
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
}
