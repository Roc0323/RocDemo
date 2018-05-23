package cn.roc.rocdemo.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;

import java.io.File;

import cn.roc.rocdemo.R;
import cn.roc.rocdemo.imageLoader.config.PriorityMode;
import cn.roc.rocdemo.imageLoader.config.ScaleMode;
import cn.roc.rocdemo.imageLoader.imagei.ImageDownLoadCallBack;
import cn.roc.rocdemo.imageLoader.loader.ImageLoaders;
import cn.roc.rocdemo.imageLoader.utils.DownLoadImageService;

import static cn.roc.rocdemo.imageLoader.config.Contants.ANDROID_RESOURCE;
import static cn.roc.rocdemo.imageLoader.config.Contants.RAW;

/**
 * Created by Roc on 2018/5/18.
 */

public class GlideUseActivity extends Activity implements View.OnClickListener{

    private ImageView iv_test1;
    private ImageView iv_test2;
    private ImageView iv_test3;
    private ImageView iv_test4;
    private ImageView iv_test5;
    private ImageView iv_test6;
    private ImageView iv_test7;
    private ImageView iv_test8;
    private ImageView iv_test9;
    private ImageView iv_test10;
    private ImageView iv_test11;
    private ImageView iv_test12;
    private ImageView iv_test13;
    private ImageView iv_test14;
    private ImageView iv_test15;

    private String url1 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490359451818&di=b3031652757061d8d9a681e824c8a9e5&imgtype=0&src=http%3A%2F%2Flvyou.panjin.net%2Ffjpic%2F1299485962.jpg";
    private String url2 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490359343773&di=9fc5478b63f369090613c1c27d56f237&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201510%2F04%2F20151004210446_usmze.jpeg";
    private String url3 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490971670&di=d810318cdd61531a5d1d3861d00c2d9e&imgtype=jpg&er=1&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2Fc%2F570cc782c8312.jpg";
    private String url4 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490377045881&di=0f13095a141036c21225c377dd7749a9&imgtype=0&src=http%3A%2F%2Ftpic.home.news.cn%2FxhCloudNewsPic%2Fxhpic1501%2FM09%2F3B%2F9F%2FwKhTlFjGSD-EBUVnAAAAADRqVbw103.jpg";
    private String url5 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490377243693&di=5471e90a84737494794986fe81833f9f&imgtype=0&src=http%3A%2F%2Fnews.cpd.com.cn%2Fn203193%2Fc29879991%2Fpart%2F29880124.jpg";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_use);
        initView();
        load();
    }
    private void initView(){
        iv_test1 = (ImageView) findViewById(R.id.iv_test1);
        iv_test2 = (ImageView) findViewById(R.id.iv_test2);
        iv_test3 = (ImageView) findViewById(R.id.iv_test3);
        iv_test4 = (ImageView) findViewById(R.id.iv_test4);
        iv_test5 = (ImageView) findViewById(R.id.iv_test5);
        iv_test6 = (ImageView) findViewById(R.id.iv_test6);
        iv_test7 = (ImageView) findViewById(R.id.iv_test7);
        iv_test8 = (ImageView) findViewById(R.id.iv_test8);
        iv_test9 = (ImageView) findViewById(R.id.iv_test9);
        iv_test10 = (ImageView) findViewById(R.id.iv_test10);
        iv_test11 = (ImageView) findViewById(R.id.iv_test11);
        iv_test12 = (ImageView) findViewById(R.id.iv_test12);
        iv_test13 = (ImageView) findViewById(R.id.iv_test13);
        iv_test14 = (ImageView) findViewById(R.id.iv_test14);
        iv_test15 = (ImageView) findViewById(R.id.iv_test15);
    }

    private void load(){
        ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
            @Override
            public void animate(View view) {
                view.setAlpha( 0f );
                ObjectAnimator fadeAnim = ObjectAnimator.ofFloat( view, "alpha", 0f, 1f );
                fadeAnim.setDuration( 2500 );
                fadeAnim.start();
            }
        };
        ImageLoaders.with(this)
                .url(url2)
                .animate(animationObject)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.CENTER_CROP)
                .into(iv_test1);

        ImageLoaders.with(this)
                .url(url1)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test2);
        Glide.with(this).load(url2).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(iv_test3);

        ImageLoaders.with(this)
                .url(url2)
                .placeHolder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test4);
        ImageLoaders.with(this)
                .url(url3)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test5);

        ImageLoaders.with(this)
                .url(url4)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test6);

        ImageLoaders.with(this)
                .res(R.drawable.gif_test)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test7);

        ImageLoaders.with(this)
                .res(R.drawable.jpeg_test)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test8);

        ImageLoaders.with(this)
                .res(R.mipmap.b)
                .vignetteFilter()
                .priority(PriorityMode.PRIORITY_NORMAL)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
//                .ignoreCertificateVerify()
                .into(iv_test9);

        ImageLoaders.with(this)
                .res(R.mipmap.c)
                .sketchFilter()
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test10);

        ImageLoaders.with(this).res(R.mipmap.f).placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER).blur(90).into(iv_test11);



//        ImageLoaders.with(this)
//                .file("file://"+ Environment.getExternalStorageDirectory().getPath()+FOREWARD_SLASH+IMG_NAME)
//                .placeHolder(R.mipmap.ic_launcher)
//                .scale(ScaleMode.FIT_CENTER)
//                .into(iv_test11);


//        ImageLoader.with(this)
//                .file(new File(getFilesDir(), IMG_NAME_C))
//                .placeHolder(R.mipmap.ic_launcher)
//                .scale(ScaleMode.FIT_CENTER)
//                .into(iv_test12);
//
//        ImageLoader.with(this)
//                .asserts(ASSERTS_PATH+IMG_NAME_C)
//                .placeHolder(R.mipmap.ic_launcher)
//                .scale(ScaleMode.FIT_CENTER)
//                .rectRoundCorner(50)
//                .into(iv_test13);

        ImageLoaders.with(this)
                .raw(ANDROID_RESOURCE+getPackageName()+RAW+R.raw.jpeg_test)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .asCircle()
                .into(iv_test14);

        ImageLoaders.with(this)
                .raw(ANDROID_RESOURCE+getPackageName()+RAW+R.raw.jpeg_test)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .asSquare()
                .into(iv_test15);

//        ImageLoaders.saveImageIntoGallery(new DownLoadImageService(GlideUseActivity.this, url3, true, "lala", new ImageDownLoadCallBack() {
//
//            @Override
//            public void onDownLoadSuccess(Bitmap bitmap) {
//                Log.e("TAG", "下载图片成功 bitmap");
//            }
//
//            @Override
//            public void onDownLoadFailed() {
//                Log.e("TAG", "下载图片失败");
//            }
//
//        }));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_test1:
                break;
        }

    }
}
