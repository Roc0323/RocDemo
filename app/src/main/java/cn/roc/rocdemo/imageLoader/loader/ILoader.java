package cn.roc.rocdemo.imageLoader.loader;

import android.content.Context;
import android.view.View;

import com.bumptech.glide.MemoryCategory;

import cn.roc.rocdemo.imageLoader.config.SingleConfig;
import cn.roc.rocdemo.imageLoader.utils.DownLoadImageService;


/**
 * Created by doudou on 2017/4/10.
 */

public interface ILoader {

    void init(Context context, int cacheSizeInM, MemoryCategory memoryCategory, boolean isInternalCD);

    void request(SingleConfig config);

    void pause();

    void resume();

    void clearDiskCache();

    void clearMomoryCache(View view);

    void clearMomory();

    boolean  isCached(String url);

    void trimMemory(int level);

    void clearAllMemoryCaches();

    void saveImageIntoGallery(DownLoadImageService downLoadImageService);
}
