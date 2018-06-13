package cn.roc.rocdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import java.io.File;

import cn.roc.rocdemo.R;
import cn.roc.rocdemo.custom_view.SuperFileView2;
import cn.roc.rocdemo.custom_view.TLog;

/**
 * Created by Roc on 2018/6/13.
 */

public class FileDisplayActivity extends AppCompatActivity {
    private SuperFileView2 mSuperFileView;
    private String filePath;
    private String TAG = "SuperFileView";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_display);
        init();
    }
    public void init() {
        mSuperFileView = (SuperFileView2) findViewById(R.id.mSuperFileView);
        mSuperFileView.setOnGetFilePathListener(new SuperFileView2.OnGetFilePathListener() {
            @Override
            public void onGetFilePath(SuperFileView2 mSuperFileView2) {
                getFilePathAndShowFile(mSuperFileView2);
            }
        });

        if (getIntent().hasExtra("file_path")){
            String path = getIntent().getStringExtra("file_path");
            if (!TextUtils.isEmpty(path)) {
                TLog.d(TAG, "文件path:" + path);
                setFilePath(path);
            }

        }
//        Intent intent = this.getIntent();
//        String path = (String) intent.getSerializableExtra("path");
//
//        if (!TextUtils.isEmpty(path)) {
//            TLog.d(TAG, "文件path:" + path);
//            setFilePath(path);
//        }
        mSuperFileView.show();

    }
    private void getFilePathAndShowFile(SuperFileView2 mSuperFileView2) {


        if (getFilePath().contains("http")) {//网络地址要先下载

            //downLoadFromNet(getFilePath(),mSuperFileView2);

        } else {
            mSuperFileView2.displayFile(new File(getFilePath()));
        }
    }

    public void setFilePath(String fileUrl) {
        this.filePath = fileUrl;
    }

    private String getFilePath() {
        return filePath;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        TLog.d("FileDisplayActivity-->onDestroy");
        if (mSuperFileView != null) {
            mSuperFileView.onStopDisplay();
        }
    }

}
