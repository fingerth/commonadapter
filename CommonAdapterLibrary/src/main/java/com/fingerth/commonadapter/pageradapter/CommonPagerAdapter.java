package com.fingerth.commonadapter.pageradapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * ======================================================
 * Created by Administrator able_fingerth on 2017/7/28.
 * <p/>
 * 版权所有，违者必究！
 * <详情描述/>
 */
public abstract class CommonPagerAdapter<T> extends PagerAdapter {
    private static final String TAG = CommonPagerAdapter.class.getSimpleName();
    private LayoutInflater layoutInflater;
    public Context context;
    protected List<T> mDatas;
    private final int mPagerLayoutId;

    public CommonPagerAdapter(Context context, List<T> mDatas, int mPagerLayoutId) {
        this.context = context;
        this.mDatas = mDatas;
        this.mPagerLayoutId = mPagerLayoutId;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        Log.e(TAG, "isViewFromObject:" + (view == object ? "true" : "false"));
        return view == object;
    }


    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int pos) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(container.getContext());
        }
        int position = pos % mDatas.size();
        PagerHolder holder = new PagerHolder(layoutInflater.inflate(mPagerLayoutId, null, false));
        convert(holder, mDatas.get(position));
        container.addView(holder.getView());
        return holder.getView();
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.e(TAG, "destroyItem:" + position);
        container.removeView((View) object);
    }

    public abstract void convert(PagerHolder holder, T item);


}
