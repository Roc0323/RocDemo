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
        //QbSdk.initX5Environment(this,null);
        initTBS();
    }
    /**
     * 初始化TBS浏览服务X5内核
     */
    private void initTBS() {
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.setDownloadWithoutWifi(true);//非wifi条件下允许下载X5内核
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                //Log.d("app", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {}
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
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
