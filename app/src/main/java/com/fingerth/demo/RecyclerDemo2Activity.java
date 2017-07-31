package com.fingerth.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fingerth.commonadapter.recycleradapter.CommonRecyclerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerDemo2Activity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_demo);
        ButterKnife.bind(this);

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            arrayList.add("item:" + i);
        }

        CommonRecyclerAdapter<String> adapter = new CommonRecyclerAdapter<String>(this, arrayList) {

            @Override
            public Holder onCreate(ViewGroup parent, int viewType) {
                View viewLayout = LayoutInflater.from(RecyclerDemo2Activity.this).inflate(android.R.layout.simple_list_item_1, parent, false);
                return new Holder(viewLayout);
            }

            @Override
            public void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, String data) {
                TextView tv = viewHolder.itemView.findViewById(android.R.id.text1);
                tv.setText(data);
            }
        };
        View mHeaderView = View.inflate(this, R.layout.view_header, null);
        adapter.setHeaderView(mHeaderView);
        View mFootView = View.inflate(this, R.layout.view_foot, null);
        adapter.setFootView(mFootView);


        GridLayoutManager manager = new GridLayoutManager(this, 2);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
    }

}
