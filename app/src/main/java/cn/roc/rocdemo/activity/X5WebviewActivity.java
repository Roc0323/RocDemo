package cn.roc.rocdemo.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;

import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;

import cn.roc.rocdemo.R;
import cn.roc.rocdemo.custom_view.x5webview.X5WebView;

/**
 * Created by Roc on 2018/7/25.
 */

public class X5WebviewActivity extends Activity{
    private X5WebView webView;
    private String url="";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x5_webview);
        webView = (X5WebView) findViewById(R.id.x5_webview);
        webView.setWebChromeClient(new WebChromeClient() {
            // For Android 3.0+
            public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType) {
                Log.i("test", "openFileChooser 1");
//                FilechooserActivity.this.uploadFile = uploadFile;
//                openFileChooseProcess();
            }

            // For Android < 3.0
            public void openFileChooser(ValueCallback<Uri> uploadMsgs) {
                Log.i("test", "openFileChooser 2");
//                FilechooserActivity.this.uploadFile = uploadFile;
//                openFileChooseProcess();
            }

            // For Android  > 4.1.1
            public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
                Log.i("test", "openFileChooser 3");
//                FilechooserActivity.this.uploadFile = uploadFile;
//                openFileChooseProcess();
            }

            // For Android  >= 5.0
            public boolean onShowFileChooser(com.tencent.smtt.sdk.WebView webView,
                                             ValueCallback<Uri[]> filePathCallback,
                                             WebChromeClient.FileChooserParams fileChooserParams) {
                Log.i("test", "openFileChooser 4:" + filePathCallback.toString());
//                FilechooserActivity.this.uploadFiles = filePathCallback;
//                openFileChooseProcess();
                return true;
            }

        });
        url = "http://wm.egridcloud.com/appStatic/app/app5/customer?sessionId=f4c073e4-a825-4570-b873-e67a89b81b96&personName=%E4%BB%BB%E4%BC%9F&dealerId=10001001&empId=WM0001009&dealerName=%E5%8C%97%E4%BA%AC%E5%A8%81%E9%A9%AC%E7%94%A8%E6%88%B7%E4%B8%AD%E5%BF%83%E4%BA%94%E6%96%B9%E5%A4%A9%E9%9B%85%E5%BA%97&positionName=%E7%94%A8%E6%88%B7%E4%BD%93%E9%AA%8C%E7%BB%8F%E7%90%86&positionCode=YHTYJL";
        webView.loadUrl(url);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    /**
     * 确保注销配置能够被释放
     */
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        if (this.webView != null) {
            webView.destroy();
        }
        super.onDestroy();
    }
}
