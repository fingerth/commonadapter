package com.fingerth.commonadapter.recycleradapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * ======================================================
 * Created by Administrator able_fingerth on 2017/1/4.
 * <p/>
 * 版权所有，违者必究！
 * <详情描述/>
 * 可有有頭部和底部的RecyclerAdapter
 */
public abstract class CommonRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_HEADER = 0x00;
    public static final int TYPE_NORMAL = 0x11;
    public static final int TYPE_FOOT = 0x22;


    private Context context;
    private ArrayList<T> mDatas = new ArrayList<>();

    private View mHeaderView;
    private View mFootView;

    public CommonRecyclerAdapter(Context context, ArrayList<T> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public View getHeaderView() {
        return mHeaderView;
    }

    public void setFootView(View mFootView) {
        //沒有數據，不顯示FootView
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.mFootView = mFootView;
            notifyItemInserted(getItemCount() - 1);
        } else {
            this.mFootView = null;
        }

    }

    public void setNoFootView() {
        this.mFootView = null;
    }

    public View getFootView() {
        return mFootView;
    }


    /**
     * 數據刷新
     */
    public void addDatas(ArrayList<T> datas) {
        mDatas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        //return mHeaderView == null ? mDatas.size() : mDatas.size() + 1;
        if (mHeaderView == null) {
            if (mFootView == null) {
                return mDatas.size();
            } else {
                return mDatas.size() + 1;
            }
        } else {
            if (mFootView == null) {
                return mDatas.size() + 1;
            } else {
                return mDatas.size() + 2;
            }
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (mHeaderView != null && position == 0) {
            return TYPE_HEADER;
        } else if (mFootView != null && position == getItemCount() - 1) {
            return TYPE_FOOT;
        }

        int pos;
        if (mHeaderView != null) {
            pos = position - 1;
        } else {
            pos = position;
        }
        return itemViewType(pos);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,  int viewType) {

        if (mHeaderView != null && viewType == TYPE_HEADER) {
            return new Holder(mHeaderView);
        } else if (mFootView != null && viewType == TYPE_FOOT) {
            return new Holder(mFootView);
        } else {
            View layout = LayoutInflater.from(parent.getContext()).inflate(setLayoutId(viewType), parent, false);
            return new Holder(layout);
            //return onCreate(parent, viewType);
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        if (mHeaderView != null && viewHolder.getItemViewType() == TYPE_HEADER) {
            return;
        }
        if (mFootView != null && viewHolder.getItemViewType() == TYPE_FOOT) {
            return;
        }


        final int pos = getRealPosition(viewHolder);
        final T data = mDatas.get(pos);
        onBind((Holder) viewHolder, pos, data);

        if (mListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(pos, data);
                }
            });
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return getItemViewType(position) != TYPE_NORMAL ? gridManager.getSpanCount() : 1;
                }
            });
        }
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if (lp != null
                && lp instanceof StaggeredGridLayoutManager.LayoutParams
                && holder.getLayoutPosition() == 0) {
            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
            p.setFullSpan(true);
        }
    }

    private int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    /**
     * 返回itemViewType
     */
    public int itemViewType(int position) {
        return TYPE_NORMAL;
    }

    //    public abstract Holder onCreate(ViewGroup parent, final int viewType);
    @LayoutRes
    public abstract int setLayoutId(int viewType);

    public abstract void onBind(Holder holder, int RealPosition, T data);

//    public class Holder extends RecyclerView.ViewHolder {
//        public Holder(View itemView) {
//            super(itemView);
//        }
//    }

    public interface OnItemClickListener<T> {
        void onItemClick(int position, T data);
    }
}
