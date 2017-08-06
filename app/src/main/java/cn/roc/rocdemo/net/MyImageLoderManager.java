package cn.roc.rocdemo.net;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import cn.roc.rocdemo.R;


/**
 * Created by Roc on 2016/9/23.
 */
public class MyImageLoderManager {

    public  static  void  loadeImage(String url, ImageView imageView){
        ImageLoader.getInstance().displayImage(url,
                imageView, MyImageLoderManager.deafultOptions,new SimpleImageLoadingListener(){
                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        if(loadedImage!=null && view!=null){
                            ImageView imageView=(ImageView)view;
                            imageView.setImageBitmap(loadedImage);
                        }

                    }
                });
    }

    /**
     * 长方形
     * @param url
     * @param imageView
     */
    public  static  void  loadeImage_chang(String url, ImageView imageView){
        ImageLoader.getInstance().displayImage(url,
                imageView, MyImageLoderManager.deafultOptions_chang,new SimpleImageLoadingListener(){
                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        if(loadedImage!=null && view!=null){
                            ImageView imageView=(ImageView)view;
                            imageView.setImageBitmap(loadedImage);
                        }

                    }
                });
    }


    /**
     * 正方形
     * @param url
     * @param imageView
     */
    public  static  void  loadeImage_zheng(String url, ImageView imageView){
        ImageLoader.getInstance().displayImage(url,
                imageView, MyImageLoderManager.deafultOptions_zheng,new SimpleImageLoadingListener(){
                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        if(loadedImage!=null && view!=null){
                            ImageView imageView=(ImageView)view;
                            imageView.setImageBitmap(loadedImage);
                        }

                    }
                });
    }

    /**
     * 圆行头像
     * @param url
     * @param imageView
     */
    public  static  void  loadeImage_cicle(String url, ImageView imageView){
        ImageLoader.getInstance().displayImage(url,
                imageView, MyImageLoderManager.deafultOptions_cicle,new SimpleImageLoadingListener(){
                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        if(loadedImage!=null && view!=null){
                            ImageView imageView=(ImageView)view;
                            imageView.setImageBitmap(loadedImage);
                        }

                    }
                });
    }


    public static DisplayImageOptions deafultOptions = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.mipmap.ic_launcher).showImageForEmptyUri(R.mipmap.ic_launcher)
            .showImageOnFail(R.mipmap.ic_launcher).cacheInMemory(true).cacheOnDisk(true).considerExifParams(true)
            .bitmapConfig(Bitmap.Config.RGB_565)// 设置图片的解码类型//
            .displayer(new RoundedBitmapDisplayer(20)).build();


    public static DisplayImageOptions deafultOptions_chang = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.mipmap.ic_launcher).showImageForEmptyUri(R.mipmap.ic_launcher)
            .showImageOnFail(R.mipmap.ic_launcher).cacheInMemory(true).cacheOnDisk(true).considerExifParams(true)
            .bitmapConfig(Bitmap.Config.RGB_565)// 设置图片的解码类型//
            .displayer(new RoundedBitmapDisplayer(20)).build();


    public static DisplayImageOptions deafultOptions_zheng = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.mipmap.ic_launcher).showImageForEmptyUri(R.mipmap.ic_launcher)
            .showImageOnFail(R.mipmap.ic_launcher).cacheInMemory(true).cacheOnDisk(true).considerExifParams(true)
            .bitmapConfig(Bitmap.Config.RGB_565)// 设置图片的解码类型//
            .displayer(new RoundedBitmapDisplayer(20)).build();


    public static DisplayImageOptions deafultOptions_cicle = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.mipmap.ic_launcher).showImageForEmptyUri(R.mipmap.ic_launcher)
            .showImageOnFail(R.mipmap.ic_launcher).cacheInMemory(true).cacheOnDisk(true).considerExifParams(true)
            .bitmapConfig(Bitmap.Config.RGB_565)// 设置图片的解码类型//
            .displayer(new RoundedBitmapDisplayer(20)).build();

}
