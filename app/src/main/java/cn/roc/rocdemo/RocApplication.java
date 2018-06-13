package cn.roc.rocdemo;

import android.app.Application;
import android.content.Context;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.tencent.smtt.sdk.QbSdk;
import java.util.concurrent.TimeUnit;
import cn.roc.rocdemo.imageLoader.loader.ImageLoaders;
import cn.roc.rocdemo.net.DownloadMgr;
import cn.roc.rocdemo.net.myokhttp.MyOkHttp;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Roc on 2017/6/27 0027.
 */
public class RocApplication extends Application {
    private static RocApplication application;
    private MyOkHttp mMyOkHttp;
    private DownloadMgr mDownloadMgr;

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
        initImageLoader();
        ImageLoaders.init(getApplicationContext());

        //持久化存储cookie
        ClearableCookieJar cookieJar =
                new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(getApplicationContext()));

        //log拦截器
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        //自定义OkHttp
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .cookieJar(cookieJar)       //设置开启cookie
                .addInterceptor(logging)            //设置开启log
                .build();
        mMyOkHttp = new MyOkHttp(okHttpClient);

        //增加这句话
        QbSdk.initX5Environment(this,null);

    }
    /*
    * 初始化ImageLoader
    * */
    private void initImageLoader() {
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(configuration);
    }


    public MyOkHttp getMyOkHttp() {
        return mMyOkHttp;
    }
    public DownloadMgr getDownloadMgr() {
        return mDownloadMgr;
    }

    /**
     * 得到全局唯一实例
     * @return
     */
    public  static   RocApplication  getAppInstance(){
        return  application;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = RocApplication.getAppInstance().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    /**
     * 得到屏幕总宽度
     * @return
     */
    public int getScreenWidth() {
        return RocApplication.getAppInstance().getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 得到屏幕总高度
     * @return
     */
    public int getScreenHeight(){
        return  RocApplication.getAppInstance().getResources().getDisplayMetrics().heightPixels;
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        ImageLoaders.trimMemory(level);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        ImageLoaders.clearAllMemoryCaches();
    }
}
