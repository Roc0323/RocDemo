package cn.roc.rocdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;

import cn.roc.rocdemo.interfaces.OnScrollChangedListener;

/**
 * Created by Roc on 2017/8/2 0002.
 */

public class MyScrollView extends ScrollView {
    private OnScrollChangedListener onScrollChangedListener;
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(this.onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged(t,oldt);
        }
    }

    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        this.onScrollChangedListener = onScrollChangedListener;
    }
}
