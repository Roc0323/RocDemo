package cn.roc.rocdemo.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by Roc on 2018/3/29.
 */

public abstract class MessageTypeCommenHolder<T> extends RecyclerView.ViewHolder {

    public MessageTypeCommenHolder(Context context, ViewGroup root, int layoutRes) {
        super(LayoutInflater.from(context).inflate(layoutRes, root, false));
    }

    public Context getContext() {
        return itemView.getContext();
    }

    /**
     * 用给定的 data 对 holder 的 view 进行赋值
     */
    public abstract void bindData(T t);

    public void setData(T t) {
        bindData(t);
    }
}
