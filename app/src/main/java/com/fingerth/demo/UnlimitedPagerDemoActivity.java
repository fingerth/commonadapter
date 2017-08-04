package com.fingerth.demo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.fingerth.commonadapter.pageradapter.PagerHolder;
import com.fingerth.commonadapter.pageradapter.unlimited.UnlimitedSlidePagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UnlimitedPagerDemoActivity extends AppCompatActivity {

    @BindView(R.id.vp)
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlimited_pager_demo);
        ButterKnife.bind(this);

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            arrayList.add("unlimited pager : " + i);
        }

        UnlimitedSlidePagerAdapter<String> unlimitedSlidePagerAdapter = new UnlimitedSlidePagerAdapter<String>(this, arrayList, R.layout.pager_item_view) {
            @Override
            public void convert(PagerHolder holder, int position,String item) {
                holder.setText(R.id.tv, item);
            }
        };
        vp.setAdapter(unlimitedSlidePagerAdapter);
        vp.setCurrentItem(unlimitedSlidePagerAdapter.getMidPosition(), false);
    }
}
