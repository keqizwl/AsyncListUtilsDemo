package com.example.zwl.testpaging;

import android.app.Activity;
import android.support.v7.util.AsyncListUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by zwl on 9/23/17.
 */

public class TestDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //将数据源和view的事件结合起来
    AsyncListUtil<Data> mDataAsyncListUtil;
    Activity mActivity;
    LayoutInflater mLayoutInflater;

    public TestDataAdapter(Activity activity, AsyncListUtil<Data> dataAsyncListUtil) {
        mActivity = activity;
        mLayoutInflater = LayoutInflater.from(mActivity);
        mDataAsyncListUtil = dataAsyncListUtil;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.item_data, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        if (mDataAsyncListUtil.getItem(position) != null) {
            viewHolder.mTvName.setText("name:" + mDataAsyncListUtil.getItem(position).getName());
            viewHolder.mTvAge.setText("age:" + mDataAsyncListUtil.getItem(position).getAge());
        }
    }

    @Override
    public int getItemCount() {
        return mDataAsyncListUtil.getItemCount();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTvName;
        TextView mTvAge;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvAge = itemView.findViewById(R.id.tv_age);
            mTvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
