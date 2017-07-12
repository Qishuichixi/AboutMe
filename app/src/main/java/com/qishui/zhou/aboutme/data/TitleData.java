package com.qishui.zhou.aboutme.data;

/**
 * 作者：Created by zhou on 2017/7/11 15:07
 * 邮箱：qishuichixi@126.com
 * 版本：V 1.0
 * 描述：
 */

public class TitleData extends Data {
    public String title;

    public TitleData(String type,String title) {
        this.title = title;
        super.type=type;
    }
}
