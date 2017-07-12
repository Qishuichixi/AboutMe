package com.qishui.zhou.aboutme.adapter;

import com.qishui.zhou.aboutme.R;
import com.qishui.zhou.aboutme.data.Data;

/**
 * 作者：Created by zhou on 2017/7/11 23:36
 * 邮箱：qishuichixi@126.com
 * 版本：V 1.0
 * 描述：
 */

public class HomeMultiTypeSupport implements BaseRecyclerAdapter.MultiTypeSupport<Data> {

    @Override
    public int getLayoutId(Data item, int position) {
        switch (item.type) {

            case "title":
                return R.layout.title_text;

            case "content":
                return R.layout.text;
            case "frame":

                return R.layout.frame;
        }

        return 0;
    }
}
