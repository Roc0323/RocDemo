package cn.roc.rocdemo.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.roc.rocdemo.R;

public class ShareNineImageActivity extends AppCompatActivity {

    private Button btn_share_friends_circle;
    private Button btn_get_image;
    private Context mContext;
    private static final int REQUEST_IMAGE_BY_SDCARD = 2050;
    List<File> files=new ArrayList<File>();
    private Button btn_share_friends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_nine_image);
        mContext=this;
        initView();
    }
    private void initView(){
        btn_get_image=(Button)findViewById(R.id.btn_get_image);
        btn_get_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImage();
            }
        });
        btn_share_friends_circle=(Button)findViewById(R.id.btn_share_friends_circle);
        btn_share_friends=(Button)findViewById(R.id.btn_share_friends);
        btn_share_friends_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                ComponentName comp = new ComponentName("com.tencent.mm",
                        "com.tencent.mm.ui.tools.ShareToTimeLineUI");
                intent.setComponent(comp);
                intent.setAction(Intent.ACTION_SEND_MULTIPLE);
                intent.setType("image/*");
                intent.putExtra("Kdescription", "一键分享");
                ArrayList<Uri> imageUris = new ArrayList<Uri>();
                for (File f : files) {
                    imageUris.add(Uri.fromFile(f));
                }
                intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
                startActivity(intent);
            }
        });
        btn_share_friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                ComponentName comp = new ComponentName("com.tencent.mm",
                        "com.tencent.mm.ui.tools.ShareImgUI");
                intent.setComponent(comp);
                intent.setAction(Intent.ACTION_SEND_MULTIPLE);
                intent.setType("image/*");
                intent.putExtra("Kdescription", "一键分享");
                ArrayList<Uri> imageUris = new ArrayList<Uri>();
                for (File f : files) {
                    imageUris.add(Uri.fromFile(f));
                }
                intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
                startActivity(intent);
            }
        });

    }

    //调用android系统自带的方法
    private void setImage() {
        //使用intent调用系统提供的相册功能，使用startActivityForResult是为了获取用户选择的图片
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        ((Activity) mContext).startActivityForResult(intent,
                ShareNineImageActivity.REQUEST_IMAGE_BY_SDCARD);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case ShareNineImageActivity.REQUEST_IMAGE_BY_SDCARD:
                Log.i("TAG","图片的地址："+getPath(data));
                File file_get_photo=new File(getPath(data));
                files.add(file_get_photo);
                Toast.makeText(mContext,"添加"+files.size()+"张照片",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public Bitmap getImg(Intent data) throws IOException {
        //外界的程序访问ContentProvider所提供数据 可以通过ContentResolver接口
        ContentResolver resolver = getContentResolver();
        //获得图片的uri
        Uri originalUri = data.getData();
        Bitmap bm = MediaStore.Images.Media.getBitmap(resolver, originalUri);
        return bm;
    }


    public String getPath(Intent data){
        //这里开始的第二部分，获取图片的路径：
        String[] imgPath = {MediaStore.Images.Media.DATA};

        //好像是android多媒体数据库的封装接口，具体的看Android文档
        Cursor cursor = managedQuery(data.getData(), imgPath, null, null, null);

        //按我个人理解 这个是获得用户选择的图片的索引值
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

        //将光标移至开头 ，这个很重要，不小心很容易引起越界
        cursor.moveToFirst();

        //最后根据索引值获取图片路径
        String path = cursor.getString(column_index);
        return path;
    }



}
