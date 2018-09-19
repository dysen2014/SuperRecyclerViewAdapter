package com.dysen.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.dysen.library.SuperRecyclerAdapter;
import com.dysen.library.SuperRecyclerHolder;
import java.util.ArrayList;
import java.util.List;

/**
 *基本类型
 *
 * Created by dysen on 2018/9/19.
 */
public class BaseTypeActivity extends AppCompatActivity {

    private RecyclerView mRv;

    private SuperRecyclerAdapter<String> mAdapter;
    private List<String> mList = new ArrayList<>();

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_recycler);
        initView();
        initData();
    }

    private void initView() {

        mRv = (RecyclerView) findViewById(R.id.rv);

        mAdapter = new SuperRecyclerAdapter<String>(this, mList) {
            @Override
            public void convert(SuperRecyclerHolder holder, final String s, int layoutType,
                final int position) {
                //只有一种布局，不使用layoutType来区分type了
                holder//
                    .setText(R.id.tv_content, s)
                    .setOnItemClickListenner(new View.OnClickListener() {
                        @Override public void onClick(View v) {
                            Toast.makeText(BaseTypeActivity.this, "item被点击"+position, Toast.LENGTH_SHORT)
                                .show();
                        }
                    });
            }

            @Override public int getLayoutAsViewType(String s, int position) {
                return R.layout.recycler_item_base;
            }
        };

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        mRv.setLayoutManager(layoutManager);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        mRv.setLayoutManager(gridLayoutManager);
        mRv.setAdapter(mAdapter);
    }

    private void initData() {
        for (int i = 0; i < 100; i++) {
            mList.add("测试数据" + i);
        }

        mAdapter.notifyDataSetChanged();
    }
}
