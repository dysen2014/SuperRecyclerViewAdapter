package com.dysen.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.dysen.library.SuperRecyclerAdapter;
import com.dysen.library.SuperRecyclerHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 多类型
 *
 * Created by dysen on 2018/9/19.
 */
public class MoreTypeActivity extends AppCompatActivity {

    private RecyclerView mRv;

    private SuperRecyclerAdapter<Person> mAdapter;
    private List<Person> mList = new ArrayList<>();

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_recycler);
        initView();
        initData();
    }

    private void initView() {

        mRv = (RecyclerView) findViewById(R.id.rv);

        mAdapter = new SuperRecyclerAdapter<Person>(this, mList) {
            @Override
            public void convert(SuperRecyclerHolder holder, final Person p, int layoutType,
                final int position) {
                //只有一种布局，不使用layoutType来区分type了
                holder//
                        .setText(Arrays.asList(new Integer[]{R.id.tv_name, R.id.tv_addr, R.id.tv_age, R.id.tv_phone}),
                                Arrays.asList(new String[]{p.getName(), p.getAddr(), String.valueOf(p.getAge()), String.valueOf(p.getNumber())}), "--")
//                    .setText(R.id.tv_name, p.getName())
//                    .setText(R.id.tv_addr, p.getAddr())
//                    .setText(R.id.tv_age, p.getAge())
//                    .setText(R.id.tv_phone, p.getPhone())
                    .setOnItemClickListenner(new View.OnClickListener() {
                        @Override public void onClick(View v) {
                            Toast.makeText(MoreTypeActivity.this, "item被点击"+position, Toast.LENGTH_SHORT)
                                .show();
                        }
                    });
            }

            @Override public int getLayoutAsViewType(Person s, int position) {
                return R.layout.recycler_item_more;
            }
        };

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRv.setLayoutManager(layoutManager);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
//        mRv.setLayoutManager(gridLayoutManager);
        mRv.setAdapter(mAdapter);
    }

    private void initData() {
        for (int i = 1; i <= 100; i++) {
            if (i%10 == 0)
            mList.add(new Person("", null, i+10, i));
            mList.add(new Person("张三"+i, "长安街"+i+"号", i+10, i));
        }
        mAdapter.notifyDataSetChanged();
    }
}
