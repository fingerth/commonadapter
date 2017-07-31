package com.fingerth.commonadapter.baseadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.annotation.IdRes;
import android.support.annotation.IntDef;
import android.support.annotation.LayoutRes;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fingerth.commonadapter.R;

/**
 * ======================================================
 * Created by Administrator able_fingerth on 2017/7/27.
 * <p/>
 * 版权所有，违者必究！
 * <详情描述/>
 */
public class ViewHolder {
    private final SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;

    @IntDef({TYPE_NULL, TYPE_FITCENTER, TYPE_CENTERCROP, TYPE_GIF})
    public @interface ImgScaleType {

    }

    private static final int TYPE_NULL = 0;
    private static final int TYPE_FITCENTER = 1;
    private static final int TYPE_CENTERCROP = 2;
    private static final int TYPE_GIF = 3;

    private ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.mPosition = position;
        this.mViews = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        //用這個方法，不然如果mConvertView是一個ImageView，用了Glide加載圖片，setTag已經被Glide佔用了。
        //Spinner 每個Item是Material Design的TextView的setTag也被佔用了。
        mConvertView.setTag(R.id.fingerth_view_holder_id, this);
    }

    /**
     * 拿到ViewHolder对象
     */
    public static ViewHolder get(Context context, View convertView, ViewGroup parent, @LayoutRes int layoutId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        }
        //根據id來
        return (ViewHolder) convertView.getTag(R.id.fingerth_view_holder_id);
    }

    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 通过控件的Id获取对于的控件
     */
    public <T extends View> T getView(@IdRes int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 为TextView设置字符串
     */
    public ViewHolder setText(@IdRes int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 为ImageView设置图片
     */
    public ViewHolder setImageResource(@IdRes int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }

    /**
     * 为ImageView设置图片
     *
     */
    public ViewHolder setImageBitmap(@IdRes int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param url
     * @return
     */
    public ViewHolder setImageByUrl(@IdRes int viewId, String url) {
        Glide.with(mConvertView.getContext())
                .load(url)
                .thumbnail(0.3f)
                .into((ImageView) getView(viewId));
        return this;
    }

    /**
     * 有默認的加載圖片
     */
    public ViewHolder setImageByUrlDefaultPlaceholder(@IdRes int viewId, String url) {
        Glide.with(mConvertView.getContext())
                .load(url)
                .placeholder(R.drawable.loading_spinner)
                .error(R.drawable.loading_spinner)
                .thumbnail(0.3f)
                .into((ImageView) getView(viewId));
        return this;
    }

    public ViewHolder setImageByUrl(@IdRes int viewId, String url,
                                    @DrawableRes int placeholderRes, @DrawableRes int errorRes,
                                    @FloatRange(from = 0.0f, to = 1.0f) float thumbnail,
                                    @ImgScaleType int scaleType,
                                    DiskCacheStrategy diskCacheStrategy) {
        switch (scaleType) {
            case TYPE_NULL:
                Glide.with(mConvertView.getContext())
                        .load(url)
                        .placeholder(placeholderRes)
                        .error(errorRes)
                        .diskCacheStrategy(diskCacheStrategy)
                        .thumbnail(thumbnail)
                        .into((ImageView) getView(viewId));
                break;
            case TYPE_FITCENTER:
                Glide.with(mConvertView.getContext())
                        .load(url)
                        .placeholder(placeholderRes)
                        .error(errorRes)
                        .diskCacheStrategy(diskCacheStrategy)
                        .fitCenter()
                        .thumbnail(thumbnail)
                        .into((ImageView) getView(viewId));
                break;
            case TYPE_CENTERCROP:
                Glide.with(mConvertView.getContext())
                        .load(url)
                        .placeholder(placeholderRes)
                        .error(errorRes)
                        .diskCacheStrategy(diskCacheStrategy)
                        .centerCrop()
                        .thumbnail(thumbnail)
                        .into((ImageView) getView(viewId));
                break;
            case TYPE_GIF:
                Glide.with(mConvertView.getContext())
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

        return this;
    }

    public ViewHolder setImageByUrl(@IdRes int viewId, String url,
                                    Drawable placeholderRes, Drawable errorRes,
                                    @FloatRange(from = 0.0f, to = 1.0f) float thumbnail,
                                    @ImgScaleType int scaleType,
                                    DiskCacheStrategy diskCacheStrategy) {
        switch (scaleType) {
            case TYPE_NULL:
                Glide.with(mConvertView.getContext())
                        .load(url)
                        .placeholder(placeholderRes)
                        .error(errorRes)
                        .diskCacheStrategy(diskCacheStrategy)
                        .thumbnail(thumbnail)
                        .into((ImageView) getView(viewId));
                break;
            case TYPE_FITCENTER:
                Glide.with(mConvertView.getContext())
                        .load(url)
                        .placeholder(placeholderRes)
                        .error(errorRes)
                        .diskCacheStrategy(diskCacheStrategy)
                        .fitCenter()
                        .thumbnail(thumbnail)
                        .into((ImageView) getView(viewId));
                break;
            case TYPE_CENTERCROP:
                Glide.with(mConvertView.getContext())
                        .load(url)
                        .placeholder(placeholderRes)
                        .error(errorRes)
                        .diskCacheStrategy(diskCacheStrategy)
                        .centerCrop()
                        .thumbnail(thumbnail)
                        .into((ImageView) getView(viewId));
                break;
            case TYPE_GIF:
                Glide.with(mConvertView.getContext())
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

        return this;
    }

    public int getPosition() {
        return mPosition;
    }


}
