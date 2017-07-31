package com.fingerth.commonadapter.pageradapter.unlimited;

import android.content.Context;

import com.fingerth.commonadapter.pageradapter.CommonPagerAdapter;

import java.util.List;

/**
 * ======================================================
 * Created by Administrator able_fingerth on 2017/7/28.
 * <p/>
 * 版权所有，违者必究！
 * <详情描述/>
 * 无限滑动，这里用假无限滑动
 */
public abstract class UnlimitedSlidePagerAdapter<T> extends CommonPagerAdapter<T> {

    public final static int PAGER_COUNT = 5000000;//假无限滑动，这个数够用了吧！

    protected UnlimitedSlidePagerAdapter(Context context, List<T> mDatas, int mPagerLayoutId) {
        super(context, mDatas, mPagerLayoutId);
    }

    /**
     * 获取中间位置，在setAdapter()之后，調用setCurrentItem(midPosition, false);
     */
    public int getMidPosition() {
        return PAGER_COUNT / 2 - ((PAGER_COUNT / 2) % mDatas.size());
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }


}
