package com.qishui.zhou.aboutme.util;

import android.content.Context;
import android.widget.Toast;

/**
 * 作者：Created by zhou on 2017/7/12 00:27
 * 邮箱：qishuichixi@126.com
 * 版本：V 1.0
 * 描述：
 */

public class ToastUtils {


    private static Toast toast;

    public static void show(Context context, String content) {
        if (toast == null) {
            toast = Toast.makeText(context, content, Toast.LENGTH_LONG);
        } else {
            toast.setText(content);
        }

        toast.show();
    }
}
