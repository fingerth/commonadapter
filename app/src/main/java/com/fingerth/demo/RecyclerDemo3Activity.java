package com.fingerth.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fingerth.commonadapter.recycleradapter.CommonRecyclerAdapter;
import com.fingerth.commonadapter.recycleradapter.Holder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerDemo3Activity extends AppCompatActivity {

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

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(manager);
        rv.setAdapter(new CommonRecyclerAdapter<String>(this, arrayList) {

            @Override
            public int itemViewType(int position) {
                if (position % 3 == 1) {
                    return 0x88;
                }
                return super.itemViewType(position);
            }

            @Override
            public int setLayoutId(int viewType) {
                switch (viewType) {
                    case 0x88:
                        return R.layout.view_foot;
                    default:
                        return android.R.layout.simple_list_item_1;
                }
            }

            @Override
            public void onBind(Holder holder, int RealPosition, String data) {
                switch (holder.getItemViewType()) {
                    case 0x88:
                        holder.setText(R.id.tv, data);
                        break;
                    default:
                        holder.setText(android.R.id.text1, data);
                        break;
                }

            }
        });
    }

}
