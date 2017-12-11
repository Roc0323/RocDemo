package cn.roc.rocdemo.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import cn.roc.rocdemo.R;

public class FileOperationActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_new_folder;
    private Button btn_delete_folder;
    private static String sdpath=Environment.getExternalStorageDirectory()+"/";
    private Button btn_new_text_file;
    private Button btn_delete_folder_all_file;
    private Button btn_image_save_local;
    private String imageUrl="";
    private String imageUrl2="";
    private String imageUrl3="";
    private Context mContext;
    private ImageView iv_show_image;
    private List<String> imageList=new ArrayList<String>();
    private int count=0;
    private Button btn_judge_folder_null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_operation);
        mContext=this;
        initView();
        initData();
    }
    private void initView(){
        btn_new_folder=(Button)findViewById(R.id.btn_new_folder);
        btn_new_folder.setOnClickListener(this);
        btn_delete_folder=(Button)findViewById(R.id.btn_delete_folder);
        btn_delete_folder.setOnClickListener(this);
        btn_new_text_file=(Button)findViewById(R.id.btn_new_text_file);
        btn_new_text_file.setOnClickListener(this);
        btn_delete_folder_all_file=(Button)findViewById(R.id.btn_delete_folder_all_file);
        btn_delete_folder_all_file.setOnClickListener(this);
        btn_image_save_local=(Button)findViewById(R.id.btn_image_save_local);
        btn_image_save_local.setOnClickListener(this);
        iv_show_image=(ImageView)findViewById(R.id.iv_show_image);
        btn_judge_folder_null=(Button)findViewById(R.id.btn_judge_folder_null);
        btn_judge_folder_null.setOnClickListener(this);
    }
    private void initData(){
        imageList.add("http://ocuw2gabq.bkt.clouddn.com/2017-08-10_qmzGpDp7.png");
        imageList.add("http://ocuw2gabq.bkt.clouddn.com/2017-08-10_HglaTZAE.png");
        imageList.add("http://ocuw2gabq.bkt.clouddn.com/2017-08-10_UN1fIHM7.png");
        imageList.add("http://ocuw2gabq.bkt.clouddn.com/2017-08-10_BuhFy29q.png");
        imageList.add("http://ocuw2gabq.bkt.clouddn.com/2017-08-10_32Wiwuc9.png");
        imageList.add("http://ocuw2gabq.bkt.clouddn.com/2017-08-10_aEDJoVSZ.png");
        imageList.add("http://ocuw2gabq.bkt.clouddn.com/2017-08-10_82h8ICn7.png");
        imageList.add("http://ocuw2gabq.bkt.clouddn.com/2017-08-10_FzP2nI1i.png");
        imageList.add("http://ocuw2gabq.bkt.clouddn.com/2017-08-10_cvwAauDN.png");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_new_folder:
                createSDCardDir("fuchengpeng");
                break;
            case R.id.btn_delete_folder:
                deleteDir("fuchengpeng");
                break;
            case R.id.btn_new_text_file:
                writeFile("这是你刚刚写入的文件");
                break;
            case R.id.btn_delete_folder_all_file:
                deleteAllFiles(new File(sdpath+"/fuchengpeng/"));
                break;
            case R.id.btn_image_save_local:
                Log.i("TAG","iamgelist的大小："+imageList.size());
                for (int i=0;i<imageList.size();i++){
                    Glide.with(mContext).load(imageList.get(i)).asBitmap().into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            //iv_show_image.setImageBitmap(resource);
                            savePicture(resource);
                        }
                    });
                }

                break;
            case R.id.btn_judge_folder_null:
                File file = new File(sdpath+"fuchengpeng");

                //判断文件夹是否为空
                if (file.exists() && file.isDirectory()) {
                    if(file.list().length > 0) {
                        Toast.makeText(mContext,"该文件夹不为空",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(mContext,"该文件夹为空",Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }

    //在SD卡上创建一个文件夹
    public void createSDCardDir(String folderName){
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            // 创建一个文件夹对象，赋值为外部存储器的目录
            //File sdcardDir =Environment.getExternalStorageDirectory();
            //得到一个路径，内容是sdcard的文件夹路径和名字
            String path=sdpath+folderName;
            File path1 = new File(path);
            if (!path1.exists()) {
                //若不存在，创建目录，可以在应用启动的时候创建
                path1.mkdirs();
                //setTitle("paht ok,path:"+path);
                Toast.makeText(FileOperationActivity.this,"创建文件夹成功",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(FileOperationActivity.this,"该文件夹已存在",Toast.LENGTH_SHORT).show();
            }
        } else{
            //setTitle("false");
            Toast.makeText(FileOperationActivity.this,"创建文件夹失败",Toast.LENGTH_SHORT).show();
            return;
        }
    }
    /**
     * 写入文件方法
     * @param content
     */
    public static void writeFile(String content) {
        try {
            //判断实际是否有SD卡，且应用程序是否有读写SD卡的能力，有则返回true
            if (Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                // 获取SD卡的目录
                File sdCardDir = Environment.getExternalStorageDirectory();
                String path = "/fuchengpeng/";
//                File dir = new File(path);
//                if (!dir.exists()) {
//                    dir.mkdirs();
//                }
                File targetFile = new File(sdCardDir.getCanonicalPath() + path+"ccc.txt");
                //使用RandomAccessFile是在原有的文件基础之上追加内容，
                //而使用outputstream则是要先清空内容再写入
                RandomAccessFile raf = new RandomAccessFile(targetFile, "rw");
                //光标移到原始文件最后，再执行写入
                raf.seek(targetFile.length());
                raf.write(content.getBytes());
                raf.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //删除指定文件
    public static void delFile(String fileName){
        File file = new File(sdpath + fileName);
        if(file.isFile()){
            file.delete();
        }
        file.exists();
    }
    //删除文件夹和文件夹里面的文件
    public static void deleteDir(String folderName) {
        File dir = new File(sdpath+folderName);
        if (dir == null || !dir.exists() || !dir.isDirectory())
            return;
        for (File file : dir.listFiles()) {
            if (file.isFile())
                file.delete(); // 删除所有文件
            else if (file.isDirectory())
                deleteDir(sdpath+folderName); // 递规的方式删除文件夹
        }
        dir.delete();// 删除目录本身
    }
    //删除指定目录文件夹下面的所有文件
    public static void deleteAllFiles(File root) {
        File files[] = root.listFiles();
        if (files != null)
            for (File f : files) {
                if (f.isDirectory()) { // 判断是否为文件夹
                    deleteAllFiles(f);
                    try {
                        f.delete();
                    } catch (Exception e) {
                    }
                } else {
                    if (f.exists()) { // 判断是否存在
                        deleteAllFiles(f);
                        try {
                            f.delete();
                        } catch (Exception e) {
                        }
                    }
                }
            }
    }
    //保存网络图片到本地
    public void savePicture(Bitmap bitmap)
    {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
        {
            try
            {
                File sdcardDir = Environment
                        .getExternalStorageDirectory();
                Time t = new Time();
                t.setToNow();
                String filename = sdcardDir.getCanonicalPath()
                        + "/fuchengpeng/"
                        + String.format("image"+count+".jpg",
                        t.year, t.month + 1, t.monthDay,
                        t.hour, t.minute, t.second);
                File file = new File(filename);
                FileOutputStream out = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
                out.flush();
                out.close();
                count++;
                if(count==9){
                    Toast.makeText(mContext,"保存图片成功",Toast.LENGTH_SHORT).show();
                }
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }




}
