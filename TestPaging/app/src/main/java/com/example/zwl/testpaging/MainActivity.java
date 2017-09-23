package com.example.zwl.testpaging;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.AsyncListUtil;
import android.support.v7.util.AsyncListUtil.DataCallback;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    LinearLayoutManager mLinearLayoutManager;
    private RecyclerView.Adapter mAdapter;

    AsyncListUtil mAsyncListUtil;

    private DataCallback<Data> mDataDataCallback = new DataCallback<Data>() {
        private List<Data> mDatas = new ArrayList<>();

        @Override
        public int refreshData() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mDatas.clear();

            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());
            mDatas.add(new Data());

            return mDatas.size();
        }

        @Override
        public void fillData(Data[] datas, int startPosition, int itemCount) {
            for (int i = startPosition; i < mDatas.size(); i++) {
                if(i - startPosition >= itemCount){
                    break;
                }

                datas[i-startPosition] = mDatas.get(i);
            }
        }
    };

    private AsyncListUtil.ViewCallback mViewCallback = new AsyncListUtil.ViewCallback() {
        @Override
        public void getItemRangeInto(int[] outRange) {
            outRange[0] = mLinearLayoutManager.findFirstVisibleItemPosition();
            outRange[1] = mLinearLayoutManager.findLastVisibleItemPosition();
        }

        @Override
        public void onDataRefresh() {
            mAdapter.notifyDataSetChanged();
        }

        @Override
        public void onItemLoaded(int position) {
            mAdapter.notifyItemChanged(position);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rv_test);

        //1init asyncListUtil
        mAsyncListUtil = new AsyncListUtil(Data.class, 10, mDataDataCallback, mViewCallback);

        //2init recyclerview
        mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mAdapter = new TestDataAdapter(this, mAsyncListUtil);
        mRecyclerView.setAdapter(mAdapter);

        //3bind rv and asyncListUtil
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                mAsyncListUtil.onRangeChanged();
            }
        });
    }

}
