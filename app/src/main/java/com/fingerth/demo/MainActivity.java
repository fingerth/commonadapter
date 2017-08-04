package com.fingerth.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.fingerth.commonadapter.baseadapter.CommonAdapter;
import com.fingerth.commonadapter.baseadapter.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.lv)
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ArrayList<String> list = new ArrayList<>();
        list.add("ViewPager Demo");
        list.add("Unlimited ViewPager Demo(無限滑動)");
        list.add("RecyclerView Demo");
        list.add("RecyclerView Demo(有頭部和foot)");
        list.add("RecyclerView Demo(不同type的item)");

        lv.setAdapter(new CommonAdapter<String>(this, list, android.R.layout.simple_list_item_1) {
            @Override
            public void convert(ViewHolder helper,int position, String item) {
                helper.setText(android.R.id.text1, item);
            }
        });

        lv.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                startActivity(new Intent(this, PagerDemoActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, UnlimitedPagerDemoActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, RecyclerDemoActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, RecyclerDemo2Activity.class));
                break;
            case 4:
                startActivity(new Intent(this, RecyclerDemo3Activity.class));
                break;

        }
    }
}
