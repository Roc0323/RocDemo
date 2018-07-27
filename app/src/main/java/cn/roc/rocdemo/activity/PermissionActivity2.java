package cn.roc.rocdemo.activity;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

import cn.roc.rocdemo.utils.permission.PermissionHelper;
import cn.roc.rocdemo.utils.permission.PermissionInterface;

/**
 * Created by Roc on 2018/7/23.
 */

public class PermissionActivity2 extends Activity implements PermissionInterface {
    private PermissionHelper mPermissionHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(cn.roc.rocdemo.R.layout.activity_permission2);
        //初始化并发起权限申请
        mPermissionHelper = new PermissionHelper(this, this);
        mPermissionHelper.requestPermissions();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(mPermissionHelper.requestPermissionsResult(requestCode, permissions, grantResults)){
            //权限请求结果，并已经处理了该回调
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public int getPermissionsRequestCode() {
        //设置权限请求requestCode，只有不跟onRequestPermissionsResult方法中的其他请求码冲突即可。
        return 10000;
    }

    @Override
    public String[] getPermissions() {
        //设置该界面所需的全部权限
        return new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        };
    }

    @Override
    public void requestPermissionsSuccess() {
        //权限请求用户已经全部允许
        initViews();
    }

    @Override
    public void requestPermissionsFail() {
        //权限请求不被用户允许。可以提示并退出或者提示权限的用途并重新发起权限申请。
        Toast.makeText(PermissionActivity2.this,"权限请求不被用户允许",Toast.LENGTH_SHORT).show();
    }

    private void initViews(){
        //已经拥有所需权限，可以放心操作任何东西了

        Toast.makeText(PermissionActivity2.this,"已经拥有所需权限，可以放心操作任何东西了",Toast.LENGTH_SHORT).show();

    }
}
