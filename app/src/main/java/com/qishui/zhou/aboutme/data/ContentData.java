package com.qishui.zhou.aboutme.data;

/**
 * 作者：Created by zhou on 2017/7/11 15:08
 * 邮箱：qishuichixi@126.com
 * 版本：V 1.0
 * 描述：
 */

public class ContentData extends Data {
    public  String content;

    public ContentData(String type, String content) {
        this.content = content;
        super.type = type;
    }
}
