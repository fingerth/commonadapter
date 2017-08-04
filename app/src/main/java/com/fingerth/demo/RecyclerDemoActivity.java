package com.fingerth.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fingerth.commonadapter.recycleradapter.CommonRecyclerAdapter;
import com.fingerth.commonadapter.recycleradapter.Holder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerDemoActivity extends AppCompatActivity {

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

        GridLayoutManager manager = new GridLayoutManager(this, 2);
        rv.setLayoutManager(manager);
        rv.setAdapter(new CommonRecyclerAdapter<String>(this, arrayList) {

            @Override
            public int setLayoutId(int viewType) {
                return android.R.layout.simple_list_item_1;
            }

            @Override
            public void onBind(Holder holder, int RealPosition, String data) {
                holder.setText(android.R.id.text1, data);
            }
        });
    }

}
