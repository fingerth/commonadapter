package com.fingerth.demo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.fingerth.commonadapter.pageradapter.CommonPagerAdapter;
import com.fingerth.commonadapter.pageradapter.PagerHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PagerDemoActivity extends AppCompatActivity {

    @BindView(R.id.vp)
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_demo);
        ButterKnife.bind(this);
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            arrayList.add("pager : " + i);
        }

        vp.setAdapter(new CommonPagerAdapter<String>(this, arrayList, R.layout.pager_item_view) {
            @Override
            public void convert(PagerHolder holder, String item) {
                holder.setText(R.id.tv, item);
            }
        });

    }

}
