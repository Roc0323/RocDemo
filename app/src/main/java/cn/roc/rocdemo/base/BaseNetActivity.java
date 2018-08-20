package cn.roc.rocdemo.base;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import cn.roc.rocdemo.receiver.NetworkChangeReceiver;
import cn.roc.rocdemo.utils.NetUtil;

/**
 * Created by Roc on 2018/8/20.
 */

public class BaseNetActivity extends FragmentActivity implements NetworkChangeReceiver.NetEvevt{
    public static NetworkChangeReceiver.NetEvevt evevt ;
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    /**
     * 网络类型
     * @param savedInstanceState
     */
    private int netModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        evevt=this;
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);
        inspectNet();

    }

    public boolean inspectNet(){
        this.netModel = NetUtil.getNetWorkState(BaseNetActivity.this);
        return isNetConnect();
    }

    /**
     * 判断当前网络状态
     * @return
     */
    public boolean isNetConnect(){
        if (netModel == 1){
            return true;
        }else if (netModel == 0){
            return true;
        }else if (netModel == -1){
            return false;
        }
        return false;
    }

    @Override
    public void onNetChange(int netModel) {
        Toast.makeText(BaseNetActivity.this, "network model:"+netModel, Toast.LENGTH_SHORT).show();
    }
}
