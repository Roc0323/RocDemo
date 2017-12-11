package cn.roc.rocdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import cn.roc.rocdemo.RocApplication;

/**
 * Created by Roc on 2017/11/30.
 */

public class ArcView extends View{

    private Paint mPaint;
    private PointF mStartPoint, mEndPoint, mControlPoint;
    private int mWidth;
    private int mHeight;
    private Path mPath = new Path();
    private int mArcHeight = 0;// 圆弧高度
    private int mStartColor;
    private int mEndColor;
    private LinearGradient mLinearGradient;
    private int screenHight;
    private int reduceHeight;


    public ArcView(Context context) {
        super(context);
        init();
    }

    public ArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new Paint();
        //mPaint.setColor(Color.parseColor("#FF3745"));
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.FILL);

        //起始点
        mStartPoint = new PointF(0, 0);
        //终点
        mEndPoint = new PointF(0, 0);
        //控制点
        mControlPoint = new PointF(0, 0);

        mStartColor = Color.parseColor("#FF3745");
        mEndColor = Color.parseColor("#FF3745");

    }


    /**
     *
     * @param startColor
     * @param endColor
     */
    public void setColor(@ColorInt int startColor, @ColorInt int endColor) {
        mStartColor = startColor;
        mEndColor = endColor;
        mLinearGradient = new LinearGradient(mWidth / 2, 0, mWidth / 2, mHeight, mStartColor, mEndColor, Shader.TileMode.MIRROR);
        invalidate();
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mWidth = w;
        mHeight = h;

        screenHight= RocApplication.getAppInstance().getScreenHeight();
        reduceHeight=(screenHight/6)+100;
        //适配
//        if (screenHight>1280){
//            reduceHeight=(screenHight/6)+100;
//        }else {
//            reduceHeight=(screenHight/6);
//        }
        mStartPoint.x = 0;
        mStartPoint.y = mHeight;

        mEndPoint.x = mWidth;
        mEndPoint.y = mHeight;

//        mControlPoint.x = mWidth / 2 - 50;
//        mControlPoint.y = mHeight + 100;

        //控制点的位置
        mControlPoint.x = mWidth / 2 ;
        mControlPoint.y = mHeight - reduceHeight;

        // 初始化shader
        mLinearGradient = new LinearGradient(mWidth / 2, 0, mWidth / 2, mHeight, mStartColor, mEndColor, Shader.TileMode.MIRROR);

        //SweepGradient sweepGradient = new SweepGradient(mEndPoint.x / 2,mEndPoint.y / 2,mStartColor,mEndColor);
        //mPaint.setShader(sweepGradient);


        invalidate();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setShader(mLinearGradient);

        mPath.moveTo(mStartPoint.x, mStartPoint.y);
        mPath.quadTo(mControlPoint.x, mControlPoint.y, mEndPoint.x, mEndPoint.y);

        canvas.drawPath(mPath, mPaint);
    }
}
