package cn.roc.rocdemo.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;

import cn.roc.rocdemo.R;
import cn.roc.rocdemo.custom_view.x5webview.X5WebView;

/**
 * Created by Roc on 2018/7/25.
 */

public class X5WebviewActivity extends Activity{
    private X5WebView webView;

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
        webView.loadUrl("http://111.231.37.236/wxapp/forApp/messageList.html?id=7504&token=c589e4a7148abfc7d019e7cd0f3428a0&userCollectionId=11476");

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
