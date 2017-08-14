package com.fingerth.commonadapter.recycleradapter;

import android.graphics.Bitmap;
import android.support.annotation.IdRes;
import android.support.annotation.IntDef;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * ======================================================
 * Created by Administrator able_fingerth on 2017/7/31.
 * <p/>
 * 版权所有，违者必究！
 * <详情描述/>
 */
public class Holder extends RecyclerView.ViewHolder {

    public Holder(View itemView) {
        super(itemView);
    }

    @IntDef({TYPE_NULL, TYPE_FITCENTER, TYPE_CENTERCROP, TYPE_GIF})
    public @interface ImgScaleType {

    }

    private static final int TYPE_NULL = 0;
    private static final int TYPE_FITCENTER = 1;
    private static final int TYPE_CENTERCROP = 2;
    private static final int TYPE_GIF = 3;

    /**
     * 通过控件的Id获取对于的控件
     */
    public <T extends View> T getView(@IdRes int viewId) {
        return this.itemView.findViewById(viewId);
    }

    /**
     * 为TextView设置字符串
     */
    public void setText(@IdRes int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
    }

    /**
     * 为ImageView设置图片
     */
    public void setImageResource(@IdRes int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);
    }

    /**
     * 为ImageView设置图片
     */
    public void setImageBitmap(@IdRes int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
    }
}
