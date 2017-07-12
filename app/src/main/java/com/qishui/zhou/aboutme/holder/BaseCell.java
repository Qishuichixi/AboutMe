package com.qishui.zhou.aboutme.holder;

import android.content.Context;
import android.view.View;

/**
 * 作者：Created by zhou on 2017/7/11 13:48
 * 邮箱：qishuichixi@126.com
 * 版本：V 1.0
 * 描述：
 */

public abstract class BaseCell<Data> {
    private View contentView;
    private Data data;
    protected Context context;

    public BaseCell(Context context) {
        this.context = context;
        contentView = initView();
        contentView.setTag(this);
    }

    /**
     * 创建界面
     */
    public abstract View initView();

    public View getContentView() {
        return contentView;
    }

    public void setData(Data data) {
        this.data = data;
        refreshView(data);
    }

    /**
     * 根据数据刷新界面
     */
    public abstract void refreshView(Data data);
}
