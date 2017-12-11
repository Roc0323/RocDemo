package cn.roc.rocdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.roc.rocdemo.bean.NineGridBean;
import cn.roc.rocdemo.R;
import cn.roc.rocdemo.view.NineGridTestLayout;

/**
 * Created by Roc on 2017/8/6 0006.
 */

public class NineGongGeAdapter extends RecyclerView.Adapter<NineGongGeAdapter.ViewHolder>{
    private Context mContext;
    private List<NineGridBean> mList;
    protected LayoutInflater inflater;

    public NineGongGeAdapter(Context mContext) {
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    public void setList(List<NineGridBean> list) {
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = inflater.inflate(R.layout.view_nine_gongge_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(convertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.layout.setIsShowAll(mList.get(position).isShowAll);
        holder.layout.setUrlList(mList.get(position).urlList,mList.get(position).urlList2);
    }

    @Override
    public int getItemCount() {
        return getListSize(mList);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        NineGridTestLayout layout;

        public ViewHolder(View itemView) {
            super(itemView);
            layout = (NineGridTestLayout) itemView.findViewById(R.id.layout_nine_grid);
        }
    }

    private int getListSize(List<NineGridBean> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        return list.size();
    }
}
