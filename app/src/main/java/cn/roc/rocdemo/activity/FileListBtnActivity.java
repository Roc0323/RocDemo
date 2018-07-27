package cn.roc.rocdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import java.io.File;

import cn.roc.rocdemo.R;
import cn.roc.rocdemo.utils.OpenFileUtils;

/**
 * Created by Roc on 2018/6/13.
 */

public class FileListBtnActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_list_btn);
        findViewById(R.id.btn_excel).setOnClickListener(this);
        findViewById(R.id.btn_doc).setOnClickListener(this);
        findViewById(R.id.btn_ppt).setOnClickListener(this);
        findViewById(R.id.btn_pdf).setOnClickListener(this);
        findViewById(R.id.btn_txt).setOnClickListener(this);
        findViewById(R.id.btn_sanfang).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_doc:
                Intent intent_doc=new Intent(this,FileDisplayActivity.class);
                intent_doc.putExtra("file_path","/storage/emulated/0/test.docx");
                startActivity(intent_doc);
                break;
            case R.id.btn_ppt:
                Intent intent_ppt=new Intent(this,FileDisplayActivity.class);
                intent_ppt.putExtra("file_path","/storage/emulated/0/test.pptx");
                startActivity(intent_ppt);
                break;
            case R.id.btn_excel:
                Intent intent_excel=new Intent(this,FileDisplayActivity.class);
                intent_excel.putExtra("file_path","/storage/emulated/0/test.xlsx");
                startActivity(intent_excel);
                break;
            case R.id.btn_pdf:
                Intent intent_pdf=new Intent(this,FileDisplayActivity.class);
                intent_pdf.putExtra("file_path","/storage/emulated/0/chaohuo/file/1React %E4%B8%AD%E6%96%87%E7%89%88 - v1.1.pdf");
                startActivity(intent_pdf);
                break;
            case R.id.btn_txt:
                Intent intent_txt=new Intent(this,FileDisplayActivity.class);
                intent_txt.putExtra("file_path","/storage/emulated/0/test.txt");
                startActivity(intent_txt);
                break;
            case R.id.btn_sanfang:
                // Android获取一个用于打开Word文件的intent
                Intent intent=OpenFileUtils.openFile("/storage/emulated/0/test.xlsx");
                startActivity(intent);
                break;
        }

    }
}
