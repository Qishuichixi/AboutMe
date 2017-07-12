package com.qishui.zhou.aboutme;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.KeyEvent;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.qishui.zhou.aboutme.adapter.HomeAdapter;
import com.qishui.zhou.aboutme.adapter.HomeMultiTypeSupport;
import com.qishui.zhou.aboutme.data.Data;
import com.qishui.zhou.aboutme.util.CommonUtils;
import com.qishui.zhou.aboutme.util.StatusBarUtils;
import com.qishui.zhou.aboutme.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    HomeAdapter adapter;
    List<Data> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        StatusBarUtils.setColor(this, 0x891777, 0);


        final XRecyclerView recyclerView = (XRecyclerView) findViewById(R.id.xrv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


        list = CommonUtils.setData();
        adapter = new HomeAdapter(this, list, new HomeMultiTypeSupport());
        recyclerView.setAdapter(adapter);


        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Toast.makeText(MainActivity.this, "~onRefresh~", Toast.LENGTH_SHORT).show();
                        adapter.notifyDataSetChanged();
                        recyclerView.refreshComplete();
                    }

                }, 1000);
            }

            @Override
            public void onLoadMore() {
                {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {

                            Toast.makeText(MainActivity.this, "~onLoadMore~", Toast.LENGTH_SHORT).show();
                            adapter.notifyDataSetChanged();
                            //  recyclerView.loadMoreComplete();
                            recyclerView.setNoMore(true);
                        }
                    }, 1000);
                }
            }
        });


    }

    /**
     * 点击返回键退出程序
     */
    private static Boolean isExit = false;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isExit == false) {
                isExit = true;
                ToastUtils.show(this, "再按一次退出程序");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                }, 2000);

            } else {
                //退出程序
                finish();
            }
        }
        return false;
    }


}
