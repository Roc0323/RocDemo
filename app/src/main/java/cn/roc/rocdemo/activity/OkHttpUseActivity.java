package cn.roc.rocdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import cn.roc.rocdemo.R;
import cn.roc.rocdemo.RocApplication;
import cn.roc.rocdemo.bean.TestConfigBean;
import cn.roc.rocdemo.net.DownloadMgrActivity;
import cn.roc.rocdemo.net.NetRequestUtil;
import cn.roc.rocdemo.net.UploadModel;
import cn.roc.rocdemo.net.myokhttp.MyOkHttp;
import cn.roc.rocdemo.net.myokhttp.response.DownloadResponseHandler;
import cn.roc.rocdemo.net.myokhttp.response.GsonResponseHandler;
import cn.roc.rocdemo.net.myokhttp.response.JsonResponseHandler;
import cn.roc.rocdemo.net.myokhttp.response.RawResponseHandler;

/**
 * Created by Roc on 2018/5/23.
 */

public class OkHttpUseActivity extends Activity implements View.OnClickListener{
    private final String TAG = "TAG";
    private MyOkHttp mMyOkhttp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_use);

        findViewById(R.id.btn_post).setOnClickListener(this);
        findViewById(R.id.btn_post_json).setOnClickListener(this);
        findViewById(R.id.btn_post_gson).setOnClickListener(this);
        findViewById(R.id.btn_get).setOnClickListener(this);
        findViewById(R.id.btn_put).setOnClickListener(this);
        findViewById(R.id.btn_patch).setOnClickListener(this);
        findViewById(R.id.btn_delete).setOnClickListener(this);
        findViewById(R.id.btn_upload).setOnClickListener(this);
        findViewById(R.id.btn_download).setOnClickListener(this);
        findViewById(R.id.btn_download_mgr).setOnClickListener(this);
        findViewById(R.id.btn_cookie).setOnClickListener(this);

        mMyOkhttp = RocApplication.getAppInstance().getMyOkHttp();

    }

    @Override
    protected void onDestroy() {
        mMyOkhttp.cancel(this);
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_post:
                doPost();
                break;

            case R.id.btn_post_json:
                doPostJSON();
                break;

            case R.id.btn_post_gson:
                doPostGson();
                break;

            case R.id.btn_get:
                doGet();
                break;

            case R.id.btn_put:
                doPut();
                break;

            case R.id.btn_patch:
                doPatch();
                break;

            case R.id.btn_delete:
                doDelete();
                break;

            case R.id.btn_upload:
                doUpload();
                break;

            case R.id.btn_download:
                doDownload();
                break;

            case R.id.btn_download_mgr:
                startActivity(new Intent(this, DownloadMgrActivity.class));
                break;

            case R.id.btn_cookie:
                doCookie();
                break;
        }
    }

    /**
     * POST请求 + Json返回
     */
    private void doPost() {
        String url = NetRequestUtil.line_url + "App.Config.Index";
        //String url = "http:www.sdjfjq.com";
        Map<String, String> params = new HashMap<>();
        params.put("device", "2");
        params.put("regid", "24fds");
        params.put("timespan","13645646456");
        params.put("version", "1.8.2");

        mMyOkhttp.post()
                .url(url)
                .params(params)
                .tag(this)
                .enqueue(new JsonResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, JSONObject response) {
                        Log.i(TAG, "doPost onSuccess JSONObject:" + response);
                    }

                    @Override
                    public void onSuccess(int statusCode, JSONArray response) {
                        Log.i(TAG, "doPost onSuccess JSONArray:" + response);
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        Log.i(TAG, "doPost onFailure:" + error_msg);
                    }
                });
    }

    /**
     * POST请求 + Gson返回
     */
    private void doPostGson() {
        String url = NetRequestUtil.line_url + "App.Config.Index";
        //String url = "http://www.sfdfwlaq4549.com/";
        Map<String, String> params = new HashMap<>();
        params.put("device", "2");
        params.put("regid", "24fds");
        params.put("timespan","13645646456");
        params.put("version", "1.8.2");

        mMyOkhttp.post()
                .url(url)
                .params(params)
                .tag(this)
                .enqueue(new GsonResponseHandler<TestConfigBean>() {
                    @Override
                    public void onSuccess(int statusCode, TestConfigBean response) {
                        Log.i(TAG, "doPostGson onSuccess Api_url:" + response.getData().getApi_url());
                        Log.i(TAG, "doPostGson onSuccess GsonObject:" + response.toString());
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        Log.i(TAG, "doPostGson onFailure statusCode:" + statusCode);
                        Log.i(TAG, "doPostGson onFailure error_msg:" + error_msg);
                    }
                });
    }

    /**
     * POST请求Json参数 + Json返回
     */
    private void doPostJSON() {
        String url = NetRequestUtil.line_url + "App.Config.Index";

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("device", "2");
            jsonObject.put("regid", "4566w");
            jsonObject.put("timespan", "4546468979");
            jsonObject.put("version", "1.8.2");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.i(TAG, " jsonObject值为:" + jsonObject.toString());
        mMyOkhttp.post()
                .url(url)
                .jsonParams(jsonObject.toString())          //与params不共存 以jsonParams优先
                .tag(this)
                .enqueue(new JsonResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, JSONObject response) {
                        Log.i(TAG, "doPostJSON onSuccess JSONObject:" + response);
                    }

                    @Override
                    public void onSuccess(int statusCode, JSONArray response) {
                        Log.i(TAG, "doPostJSON onSuccess JSONArray:" + response);
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        Log.i(TAG, "doPostJSON onFailure:" + error_msg);
                    }
                });
    }

    /**
     * GET请求 + Raw String返回
     */
    private void doGet() {
        String url = "https://www.baidu.com/";

        mMyOkhttp.get()
                .url(url)
                .addParam("name", "tsy")
                .addParam("id", "5")
                .tag(this)
                .enqueue(new RawResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, String response) {
                        Log.i(TAG, "doGet onSuccess:" + response);
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        Log.i(TAG, "doGet onFailure:" + error_msg);
                    }
                });
    }

    /**
     * PUT请求 + Json返回
     */
    private void doPut() {
        String url = "https://www.baidu.com/";

        mMyOkhttp.put()
                .url(url)
                .tag(this)
                .enqueue(new JsonResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, JSONObject response) {
                        Log.i(TAG, "doPut onSuccess:" + response);
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        Log.i(TAG, "doPut onFailure:" + error_msg);
                    }
                });
    }

    /**
     * PATCH请求 + Json返回
     */
    private void doPatch() {
        String url = "http://192.168.2.135/myokhttp/patch.php/id/5/name/tsy";

        mMyOkhttp.patch()
                .url(url)
                .tag(this)
                .enqueue(new JsonResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, JSONObject response) {
                        Log.i(TAG, "doPatch onSuccess:" + response);
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        Log.i(TAG, "doPatch onFailure:" + error_msg);
                    }
                });
    }

    /**
     * DELETE请求 + Json返回
     */
    private void doDelete() {
        String url = "http://192.168.2.135/myokhttp/delete.php/id/5";

        mMyOkhttp.delete()
                .url(url)
                .tag(this)
                .enqueue(new JsonResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, JSONObject response) {
                        Log.i(TAG, "doDelete onSuccess:" + response);
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        Log.i(TAG, "doDelete onFailure:" + error_msg);
                    }
                });
    }

    /**
     * UPLOAD + Gson返回
     */
    private void doUpload() {
        String url = "http://192.168.1.144:8080/upload.php";

        mMyOkhttp.upload()
                .url(url)
                .addParam("name", "tsy")
                .addFile("avatar",
                        new File(getFilesDir()
                                + "/local20180124083154.png"))        //上传已经存在的File
//                .addFile("avatar2", "asdsda.png", byteContents)    //直接上传File bytes
                .tag(this)
                .enqueue(new GsonResponseHandler<UploadModel>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        Log.i(TAG, "doUpload onFailure:" + error_msg);
                    }

                    @Override
                    public void onProgress(long currentBytes, long totalBytes) {
                        Log.i(TAG, "doUpload onProgress:" + currentBytes + "/" + totalBytes);
                    }

                    @Override
                    public void onSuccess(int statusCode, UploadModel response) {
                        Log.i(TAG, "doUpload onSuccess:" + response.ret + " " + response.msg);
                    }
                });
    }

    /**
     * Download
     */
    private void doDownload() {
        String url = "http://192.168.2.135/myokhttp/head.jpg";

        mMyOkhttp.download()
                .url(url)
                .filePath(Environment.getExternalStorageDirectory() + "/ahome/a.jpg")
                .tag(this)
                .enqueue(new DownloadResponseHandler() {
                    @Override
                    public void onStart(long totalBytes) {
                        Log.i(TAG, "doDownload onStart");
                    }

                    @Override
                    public void onFinish(File downloadFile) {
                        Log.i(TAG, "doDownload onFinish:");
                    }

                    @Override
                    public void onProgress(long currentBytes, long totalBytes) {
                        Log.i(TAG, "doDownload onProgress:" + currentBytes + "/" + totalBytes);
                    }

                    @Override
                    public void onFailure(String error_msg) {
                        Log.i(TAG, "doDownload onFailure:" + error_msg);
                    }
                });
    }

    /**
     * cookie测试
     *
     * php代码：
     * if(empty($_COOKIE['mycookie'])) {
     *      setcookie('mycookie','value', time()+20);
     *      die("no cookie 'mycookie', set 'mycookie' => 'value'");
     * }
     * die("has cookie 'mycookie' => " . $_COOKIE['mycookie']);
     *
     */
    private void doCookie() {
        String url = "http://192.168.2.135/myokhttp/cookie.php";

        mMyOkhttp.post()
                .url(url)
                .tag(this)
                .enqueue(new RawResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, String response) {
                        Log.i(TAG, "doCookie onSuccess:" + response);
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        Log.i(TAG, "doCookie onFailure:" + error_msg);
                        Log.i(TAG, "doCookie onFailure statusCode:" + statusCode);
                    }
                });
    }
}
