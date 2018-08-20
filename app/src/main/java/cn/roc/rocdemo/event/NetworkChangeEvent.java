package cn.roc.rocdemo.event;

/**
 * Created by Roc on 2018/7/31.
 */

public class NetworkChangeEvent {
    public boolean isConnected; //是否存在网络

    public NetworkChangeEvent(boolean isConnected) {
        this.isConnected = isConnected;
    }
}
