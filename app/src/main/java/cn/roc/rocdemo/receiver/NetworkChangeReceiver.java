package cn.roc.rocdemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import cn.roc.rocdemo.base.BaseNetActivity;
import cn.roc.rocdemo.utils.NetUtil;

/**
 * Created by Roc on 2018/8/20.
 */

public class NetworkChangeReceiver extends BroadcastReceiver {
    public static String TAG = "NetworkChangeReceiver";
    public NetEvevt evevt = BaseNetActivity.evevt;
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Hxh","MainActivity:"+intent.getAction());

        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            //Toast.makeText(context, "network change", Toast.LENGTH_SHORT).show();
            evevt.onNetChange(NetUtil.getNetWorkState(context));
        }

    }
    public interface NetEvevt {
        public void onNetChange(int netModel);    //网络状态改变时的回调
    }

}
