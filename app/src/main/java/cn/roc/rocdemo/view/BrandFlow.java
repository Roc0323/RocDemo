package cn.roc.rocdemo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import cn.roc.rocdemo.net.MyImageLoderManager;

/**
 * Created by Roc on 2017/12/7.
 */

public class BrandFlow extends FrameLayout implements ViewTreeObserver.OnGlobalLayoutListener{

    public static final int IDX_X = 0;
    public static final int IDX_Y = 1;
    public static final int IDX_TXT_LENGTH = 2;
    public static final int IDX_DIS_Y = 3;
    /** 由外至内的动画。 */
    public static final int ANIMATION_IN = 1;
    /** 由内至外的动画。 */
    public static final int ANIMATION_OUT = 2;
    /** 位移动画类型：从外围移动到坐标点。 */
    public static final int OUTSIDE_TO_LOCATION = 1;
    /** 位移动画类型：从坐标点移动到外围。 */
    public static final int LOCATION_TO_OUTSIDE = 2;
    /** 位移动画类型：从中心点移动到坐标点。 */
    public static final int CENTER_TO_LOCATION = 3;
    /** 位移动画类型：从坐标点移动到中心点。 */
    public static final int LOCATION_TO_CENTER = 4;
    public static final long ANIM_DURATION = 800L;
    public static final int MAX = 17;
    public static final int TEXT_SIZE_MAX = 20;
    public static final int TEXT_SIZE_MIN = 10;
    private OnClickListener itemClickListener;
    private static Interpolator interpolator;
    private static AlphaAnimation animAlpha2Opaque;
    private static AlphaAnimation animAlpha2Transparent;
    private static ScaleAnimation animScaleLarge2Normal, animScaleNormal2Large,
            animScaleZero2Normal, animScaleNormal2Zero;
    /** 存储显示的关键字。 */
    private Vector<Integer> vecKeywords;
    private int width, height;
    /**
     * go2Show()中被赋值为true，标识开发人员触发其开始动画显示。<br/>
     * 本标识的作用是防止在填充keywrods未完成的过程中获取到width和height后提前启动动画。<br/>
     * 在show()方法中其被赋值为false。<br/>
     * 真正能够动画显示的另一必要条件：width 和 height不为0。<br/>
     */
    private boolean enableShow;
    private Random random;

    private int txtAnimInType, txtAnimOutType;
    /** 最近一次启动动画显示的时间。 */
    private long lastStartAnimationTime;
    /** 动画运行时间。 */
    private long animDuration;
    private Context context;
    private int picWidth = 0;
    private List<Integer> numList=new ArrayList<Integer>();
    private boolean isStop=true;
    private int count =0;
    private Thread thread;


    private Handler mHandle=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    //Log.i("TAG","收到分支线程消息:"+msg.arg1);
                    ImageView brandImage = (ImageView) getChildAt(msg.arg1);
                    brandImage.setVisibility(VISIBLE);
                    //缩放动画，设置缩放中心点。
                    ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1,
                            Animation.RELATIVE_TO_SELF, 0.5F,
                            Animation.RELATIVE_TO_SELF, 0.5F);
                    sa.setDuration(2000);
                    brandImage.startAnimation(sa);
                    break;
            }
        }
    };



    public BrandFlow(@NonNull Context context) {
        super(context);
        init();
    }

    public BrandFlow(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BrandFlow(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        lastStartAnimationTime = 0L;

        random = new Random();
        vecKeywords = new Vector<Integer>(MAX);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
//        animDuration = ANIM_DURATION;
//        interpolator = AnimationUtils.loadInterpolator(getContext(),
//                android.R.anim.decelerate_interpolator);
//        animAlpha2Opaque = new AlphaAnimation(0.0f, 1.0f);
//        animAlpha2Transparent = new AlphaAnimation(1.0f, 0.0f);
//        animScaleLarge2Normal = new ScaleAnimation(2, 1, 2, 1);
//        animScaleNormal2Large = new ScaleAnimation(1, 2, 1, 2);
//        animScaleZero2Normal = new ScaleAnimation(0, 1, 0, 1);
//        animScaleNormal2Zero = new ScaleAnimation(1, 0, 1, 0);
        show();
    }

    public long getDuration() {
        return animDuration;
    }

    public void setDuration(long duration) {
        animDuration = duration;
    }


    public boolean feedKeyword(int keyword) {

        boolean result = false;
        if (vecKeywords.size() < MAX) {
            result = vecKeywords.add(keyword);
        }
        return result;
    }


    public void oneAndOneShow(final int imgCount){
        final Random random = new Random();
        if(thread!=null){
            isStop=true;
            count=0;
            Log.i("TAG","是否执行到这里");
        }else {
            thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    while (isStop){
                        try {
                            int ran = random.nextInt(imgCount);
                            if(!numList.contains(ran)){
                                numList.add(ran);
                                Message message=new Message();
                                message.what=1;
                                message.arg1=ran;
                                mHandle.sendMessage(message);
                                count++;
                                Thread.sleep(200);
                                //Log.i("TAG","看看线程怎么执行");
                            }
                            if(imgCount==count){
                                isStop=false;
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        thread.start();
    }

    public void brandHide(int imgCount){
        for (int i=0;i<imgCount;i++){
            ImageView brandImage = (ImageView) getChildAt(i);
            brandImage.setVisibility(INVISIBLE);
        }

    }

    public boolean show() {
//        Log.i("TAG","width："+width);
//        Log.i("TAG","height："+height);
        if (width > 0 && height > 0 && vecKeywords != null && vecKeywords.size() > 0 ) {
            lastStartAnimationTime = System.currentTimeMillis();
            int xCenter = width >> 1, yCenter = height >> 1;
            int size = vecKeywords.size();
            int xItem = width / size, yItem = height / size;
//            Log.i("TAG","xCenter："+xCenter+",yCenter："+yCenter);
//            Log.i("TAG","xItem："+xItem+"，yItem："+yItem);
            LinkedList<Integer> listX = new LinkedList<Integer>(), listY = new LinkedList<Integer>();
            for (int i = 1; i <= size; i++) {
                // 准备随机候选数，分别对应x/y轴位置
                listX.add(i * xItem);
                listY.add(i * yItem + (yItem >> 2));
            }
            LinkedList<ImageView> listTxtTop = new LinkedList<ImageView>();
            LinkedList<ImageView> listTxtBottom = new LinkedList<ImageView>();
            for (int i = 0; i < size; i++) {
                int keyword = vecKeywords.get(i);
                // 随机位置，糙值
                int xy[] = randomXY(random, listX, listY, xItem);
                // 实例化Image
                final ImageView brandImage = new ImageView(getContext());
                Glide.with(getContext()).load(keyword).asBitmap().into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        //Log.i("TAG","图片的宽度s："+resource.getWidth());
                        brandImage.setImageBitmap(resource);
                        brandImage.setVisibility(INVISIBLE);
                        picWidth=resource.getWidth()/2;
                    }
                });
//                brandImage

                xy[IDX_TXT_LENGTH] = picWidth;
                // 第一次修正:修正x坐标
                if (xy[IDX_X] + picWidth > width - (xItem >> 1)) {
                    int baseX = width - picWidth;
                    // 减少文本右边缘一样的概率
                    xy[IDX_X] = baseX - xItem + random.nextInt(xItem >> 1);
                } else if (xy[IDX_X] == 0) {
                    // 减少文本左边缘一样的概率
                    xy[IDX_X] = Math.max(random.nextInt(xItem), xItem / 3);
                }
                xy[IDX_DIS_Y] = Math.abs(xy[IDX_Y] - yCenter);
                brandImage.setTag(xy);
                if (xy[IDX_Y] > yCenter) {
                    listTxtBottom.add(brandImage);
                } else {
                    listTxtTop.add(brandImage);
                }
            }
            attach2Screen(listTxtTop, xCenter, yCenter, yItem);
            attach2Screen(listTxtBottom, xCenter, yCenter, yItem);
            return true;
        }
        return false;
    }

    /** 修正Imageview的Y坐标将将其添加到容器上。 */
    private void attach2Screen(LinkedList<ImageView> listTxt, int xCenter,
                               int yCenter, int yItem) {
        int size = listTxt.size();
        sortXYList(listTxt, size);
        for (int i = 0; i < size; i++) {
            ImageView brandImage = listTxt.get(i);
            int[] iXY = (int[]) brandImage.getTag();
            // 第二次修正:修正y坐标
            int yDistance = iXY[IDX_Y] - yCenter;
            // 对于最靠近中心点的，其值不会大于yItem<br/>
            // 对于可以一路下降到中心点的，则该值也是其应调整的大小<br/>
            int yMove = Math.abs(yDistance);
            inner: for (int k = i - 1; k >= 0; k--) {
                int[] kXY = (int[]) listTxt.get(k).getTag();
                int startX = kXY[IDX_X];
                int endX = startX + kXY[IDX_TXT_LENGTH];
                // y轴以中心点为分隔线，在同一侧
                if (yDistance * (kXY[IDX_Y] - yCenter) > 0) {
                    if (isXMixed(startX, endX, iXY[IDX_X], iXY[IDX_X]
                            + iXY[IDX_TXT_LENGTH])) {
                        int tmpMove = Math.abs(iXY[IDX_Y] - kXY[IDX_Y]);
                        if (tmpMove > yItem) {
                            yMove = tmpMove;
                        } else if (yMove > 0) {
                            // 取消默认值。
                            yMove = 0;
                        }
                        break inner;
                    }
                }
            }
            if (yMove > yItem) {
                int maxMove = yMove - yItem;
                int randomMove = random.nextInt(maxMove);
                int realMove = Math.max(randomMove, maxMove >> 1) * yDistance
                        / Math.abs(yDistance);
                iXY[IDX_Y] = iXY[IDX_Y] - realMove;
                iXY[IDX_DIS_Y] = Math.abs(iXY[IDX_Y] - yCenter);
                // 已经调整过前i个需要再次排序
                sortXYList(listTxt, i + 1);
            }
            FrameLayout.LayoutParams layParams = new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT);
            layParams.gravity = Gravity.LEFT | Gravity.TOP;
            //layParams.gravity = Gravity.CENTER;
            layParams.leftMargin = iXY[IDX_X];
            layParams.topMargin = iXY[IDX_Y];

//            Log.i("TAG","leftMargin:"+iXY[IDX_X]);
//            Log.i("TAG","topMargin:"+iXY[IDX_Y]);
            addView(brandImage, layParams);
            // 动画
//            AnimationSet animSet = getAnimationSet(iXY, xCenter, yCenter,
//                    txtAnimInType);
//            brandImage.startAnimation(animSet);
        }
    }

    public AnimationSet getAnimationSet(int[] xy, int xCenter, int yCenter,
                                        int type) {
        AnimationSet animSet = new AnimationSet(true);
        animSet.setInterpolator(interpolator);
        if (type == OUTSIDE_TO_LOCATION) {
            animSet.addAnimation(animAlpha2Opaque);
            animSet.addAnimation(animScaleLarge2Normal);
            TranslateAnimation translate = new TranslateAnimation((xy[IDX_X]
                    + (xy[IDX_TXT_LENGTH] >> 1) - xCenter) << 1, 0,
                    (xy[IDX_Y] - yCenter) << 1, 0);
            animSet.addAnimation(translate);
        } else if (type == LOCATION_TO_OUTSIDE) {
            animSet.addAnimation(animAlpha2Transparent);
            animSet.addAnimation(animScaleNormal2Large);
            TranslateAnimation translate = new TranslateAnimation(0, (xy[IDX_X]
                    + (xy[IDX_TXT_LENGTH] >> 1) - xCenter) << 1, 0,
                    (xy[IDX_Y] - yCenter) << 1);
            animSet.addAnimation(translate);
        } else if (type == LOCATION_TO_CENTER) {
            animSet.addAnimation(animAlpha2Transparent);
            animSet.addAnimation(animScaleNormal2Zero);
            TranslateAnimation translate = new TranslateAnimation(0,
                    (-xy[IDX_X] + xCenter), 0, (-xy[IDX_Y] + yCenter));
            animSet.addAnimation(translate);
        } else if (type == CENTER_TO_LOCATION) {
            animSet.addAnimation(animAlpha2Opaque);
            animSet.addAnimation(animScaleZero2Normal);
            TranslateAnimation translate = new TranslateAnimation(
                    (-xy[IDX_X] + xCenter), 0, (-xy[IDX_Y] + yCenter), 0);
            animSet.addAnimation(translate);
        }
        animSet.setDuration(animDuration);
        return animSet;
    }

    /**
     * 根据与中心点的距离由近到远进行冒泡排序。
     * @param endIdx
     * 起始位置。
     * 待排序的数组。
     */
    private void sortXYList(LinkedList<ImageView> listTxt, int endIdx) {
        for (int i = 0; i < endIdx; i++) {
            for (int k = i + 1; k < endIdx; k++) {
                if (((int[]) listTxt.get(k).getTag())[IDX_DIS_Y] < ((int[]) listTxt
                        .get(i).getTag())[IDX_DIS_Y]) {
                    ImageView iTmp = listTxt.get(i);
                    ImageView kTmp = listTxt.get(k);
                    listTxt.set(i, kTmp);
                    listTxt.set(k, iTmp);
                }
            }
        }
    }

    /** A线段与B线段所代表的直线在X轴映射上是否有交集。 */
    private boolean isXMixed(int startA, int endA, int startB, int endB) {
        boolean result = false;
        if (startB >= startA && startB <= endA) {
            result = true;
        } else if (endB >= startA && endB <= endA) {
            result = true;
        } else if (startA >= startB && startA <= endB) {
            result = true;
        } else if (endA >= startB && endA <= endB) {
            result = true;
        }
        return result;
    }

    //得到随机坐标
    private int[] randomXY(Random ran, LinkedList<Integer> listX,
                           LinkedList<Integer> listY, int xItem) {
        int[] arr = new int[4];
        arr[IDX_X] = listX.remove(ran.nextInt(listX.size()));
        arr[IDX_Y] = listY.remove(ran.nextInt(listY.size()));
        return arr;
    }

    public Vector<Integer> getKeywords() {
        return vecKeywords;
    }

    public void rubKeywords() {
        vecKeywords.clear();
    }

    /** 直接清除所有的TextView。在清除之前不会显示动画。 */
    public void rubAllViews() {
        removeAllViews();
    }

    public void setOnItemClickListener(OnClickListener listener) {
        itemClickListener = listener;
    }
    @Override
    public void onGlobalLayout() {
        int tmpW = getWidth();
        int tmpH = getHeight();
        if (width != tmpW || height != tmpH) {
            width = tmpW;
            height = tmpH;
            show();
        }
    }
}
