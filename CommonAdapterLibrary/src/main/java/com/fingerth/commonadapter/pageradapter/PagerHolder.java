package com.fingerth.commonadapter.pageradapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.annotation.IdRes;
import android.support.annotation.IntDef;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fingerth.commonadapter.R;

/**
 * ======================================================
 * Created by Administrator able_fingerth on 2017/7/31.
 * <p/>
 * 版权所有，违者必究！
 * <详情描述/>
 */
public class PagerHolder {
    private View view;

    public PagerHolder(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
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
        return (T) view.findViewById(viewId);
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

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param url
     * @return
     */
    public void setImageByUrl(@IdRes int viewId, String url) {
        Glide.with(view.getContext())
                .load(url)
                .thumbnail(0.3f)
                .into((ImageView) getView(viewId));
    }

    /**
     * 有默認的加載圖片
     */
    public void setImageByUrlDefaultPlaceholder(@IdRes int viewId, String url) {
        Glide.with(view.getContext())
                .load(url)
                .placeholder(R.drawable.loading_spinner)
                .error(R.drawable.loading_spinner)
                .thumbnail(0.3f)
                .into((ImageView) getView(viewId));
    }

    public void setImageByUrl(@IdRes int viewId, String url,
                              @DrawableRes int placeholderRes, @DrawableRes int errorRes,
                              @FloatRange(from = 0.0f, to = 1.0f) float thumbnail,
                              @ImgScaleType int scaleType,
                              DiskCacheStrategy diskCacheStrategy) {
        switch (scaleType) {
            case TYPE_NULL:
                Glide.with(view.getContext())
                        .load(url)
                        .placeholder(placeholderRes)
                        .error(errorRes)
                        .diskCacheStrategy(diskCacheStrategy)
                        .thumbnail(thumbnail)
                        .into((ImageView) getView(viewId));
                break;
            case TYPE_FITCENTER:
                Glide.with(view.getContext())
                        .load(url)
                        .placeholder(placeholderRes)
                        .error(errorRes)
                        .diskCacheStrategy(diskCacheStrategy)
                        .fitCenter()
                        .thumbnail(thumbnail)
                        .into((ImageView) getView(viewId));
                break;
            case TYPE_CENTERCROP:
                Glide.with(view.getContext())
                        .load(url)
                        .placeholder(placeholderRes)
                        .error(errorRes)
                        .diskCacheStrategy(diskCacheStrategy)
                        .centerCrop()
                        .thumbnail(thumbnail)
                        .into((ImageView) getView(viewId));
                break;
            case TYPE_GIF:
                Glide.with(view.getContext())
                        .load(url)
                        .asGif()
                        .placeholder(placeholderRes)
                        .error(errorRes)
                        .diskCacheStrategy(diskCacheStrategy)
                        .fitCenter()
                        .thumbnail(thumbnail)
                        .into((ImageView) getView(viewId));
                break;

        }

    }

    public void setImageByUrl(@IdRes int viewId, String url,
                              Drawable placeholderRes, Drawable errorRes,
                              @FloatRange(from = 0.0f, to = 1.0f) float thumbnail,
                              @ImgScaleType int scaleType,
                              DiskCacheStrategy diskCacheStrategy) {
        switch (scaleType) {
            case TYPE_NULL:
                Glide.with(view.getContext())
                        .load(url)
                        .placeholder(placeholderRes)
                        .error(errorRes)
                        .diskCacheStrategy(diskCacheStrategy)
                        .thumbnail(thumbnail)
                        .into((ImageView) getView(viewId));
                break;
            case TYPE_FITCENTER:
                Glide.with(view.getContext())
                        .load(url)
                        .placeholder(placeholderRes)
                        .error(errorRes)
                        .diskCacheStrategy(diskCacheStrategy)
                        .fitCenter()
                        .thumbnail(thumbnail)
                        .into((ImageView) getView(viewId));
                break;
            case TYPE_CENTERCROP:
                Glide.with(view.getContext())
                        .load(url)
                        .placeholder(placeholderRes)
                        .error(errorRes)
                        .diskCacheStrategy(diskCacheStrategy)
                        .centerCrop()
                        .thumbnail(thumbnail)
                        .into((ImageView) getView(viewId));
                break;
            case TYPE_GIF:
                Glide.with(view.getContext())
                        .load(url)
                        .asGif()
                        .placeholder(placeholderRes)
                        .error(errorRes)
                        .diskCacheStrategy(diskCacheStrategy)
                        .fitCenter()
                        .thumbnail(thumbnail)
                        .into((ImageView) getView(viewId));
                break;

        }
    }
}
