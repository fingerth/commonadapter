//package com.fingerth.demo.view;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.support.annotation.AttrRes;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.util.AttributeSet;
//import android.util.TypedValue;
//import android.widget.FrameLayout;
//
///**
// * ======================================================
// * Created by Administrator able_fingerth on 2017/7/31.
// * <p/>
// * 版权所有，违者必究！
// * <详情描述/>
// */
//public class NumberIndicatorView extends FrameLayout {
//    private Context mContext;
//
//    private int viewSize = 200;
//
//    private Paint mPaintBackgroundOil;
//    private Paint mPaintLine;
//    private Paint mTextPaint;
//    private Paint mTextPaint2;
//
//    public NumberIndicatorView(@NonNull Context context) {
//        super(context);
//        mContext = context;
//        initPaint();
//    }
//
//    public NumberIndicatorView(@NonNull Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//        mContext = context;
//        initPaint();
//    }
//
//    public NumberIndicatorView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        mContext = context;
//        initPaint();
//    }
//
//    private void initPaint() {
//        setBackgroundColor(Color.TRANSPARENT);
//        viewSize = dp2px(getContext(), 60);
//
//        //宽度=5，抗锯齿，畫背景
//        mPaintBackgroundOil = new Paint();
//        mPaintBackgroundOil.setStrokeWidth(5);
//        mPaintBackgroundOil.setAntiAlias(true);
//        mPaintBackgroundOil.setStyle(Paint.Style.FILL);
//        mPaintBackgroundOil.setColor(0x33333333);
//
//        //宽度=5，抗锯齿，畫中間斜線
//        mPaintLine = new Paint();
//        mPaintLine.setStrokeWidth(2);
//        mPaintLine.setAntiAlias(true);
//        mPaintLine.setStyle(Paint.Style.STROKE);
//        mPaintLine.setColor(Color.WHITE);
//
//        //宽度=5，抗锯齿，寫數字
//        mTextPaint = new Paint();
//        mTextPaint.setTextSize(45);
//        mTextPaint.setStrokeWidth(5);
//        mTextPaint.setAntiAlias(true);
//        mTextPaint.setColor(Color.WHITE);
//
//        mTextPaint2 = new Paint();
//        mTextPaint2.setTextSize(30);
//        mTextPaint2.setStrokeWidth(3);
//        mTextPaint2.setAntiAlias(true);
//        mTextPaint2.setColor(Color.WHITE);
//    }
//
//    public void setViewSize(int size) {
//        this.viewSize = size;
//        setMeasuredDimension(viewSize, viewSize);
//    }
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        // TODO Auto-generated method stub
//        setMeasuredDimension(viewSize, viewSize);
//    }
//
//    private String text1 = "2";
//    private String text2 = "6";
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        canvas.drawCircle(viewSize / 2, viewSize / 2, viewSize / 2, mPaintBackgroundOil);
////        canvas.drawCircle(viewSize / 2, viewSize / 2, 255, mPaintLine);
////        canvas.drawCircle(viewSize / 2, viewSize / 2, 125, mPaintLine);
////        canvas.drawCircle(viewSize / 2, viewSize / 2, 350, mPaintLine);
////        //绘制两条十字线
//        canvas.drawLine(viewSize * 3 / 4, viewSize / 4, viewSize / 4, viewSize * 3 / 4, mPaintLine);
////        canvas.drawLine(0, viewSize / 2, viewSize, viewSize / 2, mPaintLine);
//
//
//        // 计算Baseline绘制的起点X轴坐标 ，计算方式：画布宽度的一半 - 文字宽度的一半
//        int baseX = (int) (viewSize * 3 / 8 - mTextPaint.measureText(text1) / 2);
//        // 计算Baseline绘制的Y坐标 ，计算方式：画布高度的一半 - 文字总高度的一半
//        int baseY = (int) ((viewSize * 3 / 8) - ((mTextPaint.descent() + mTextPaint.ascent()) / 2));
//        // 居中画一个文字
//        canvas.drawText(text1, baseX, baseY, mTextPaint);
//
//        // 计算Baseline绘制的起点X轴坐标 ，计算方式：画布宽度的一半 - 文字宽度的一半
//        int baseX2 = (int) (viewSize * 5 / 8 - mTextPaint2.measureText(text2) / 2);
//        // 计算Baseline绘制的Y坐标 ，计算方式：画布高度的一半 - 文字总高度的一半
//        int baseY2 = (int) ((viewSize * 5 / 8) - ((mTextPaint2.descent() + mTextPaint2.ascent()) / 2));
//        // 居中画一个文字
//        canvas.drawText(text2, baseX2, baseY2, mTextPaint2);
//
//        super.onDraw(canvas);
//    }
//
//    public static int dp2px(Context context, int dp) {
//        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
//    }
//}
