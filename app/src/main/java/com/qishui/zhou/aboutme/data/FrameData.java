package com.qishui.zhou.aboutme.data;

/**
 * 作者：Created by zhou on 2017/7/12 09:18
 * 邮箱：qishuichixi@126.com
 * 版本：V 1.0
 * 描述：
 */

public class FrameData extends Data {

    public  String frameTag;

    public FrameData(String type, String frameTag) {
        this.frameTag = frameTag;
        super.type = type;
    }
}
