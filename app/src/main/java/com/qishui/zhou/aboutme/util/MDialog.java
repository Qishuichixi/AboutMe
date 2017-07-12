package com.qishui.zhou.aboutme.util;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DialogTitle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

import com.qishui.zhou.aboutme.R;

/**
 * 作者：Created by zhou on 2017/7/12 00:46
 * 邮箱：qishuichixi@126.com
 * 版本：V 1.0
 * 描述：
 */
public class MDialog {

    private static MDialog mDialog;
    private String title;//标题
    private String message;//提示内容
    private int iconResId;//图标
    private Context context;//上下文对象
    private String OK;//确认
    private String Cancel;//取消
    private int btnOKSize;
    private int btnCancelSize;
    private int titleSize;//标题大小
    private int messageSize;//主题大小
    private String titleColor;//标题颜色
    private String msgColor;//信息颜色
    private String okColor;//颜色
    private String cancelColor;//标题颜色


    private MDialog() {
    }

    public static MDialog build() {

//        if (mDialog == null) {
//            synchronized (MDialog.class) {
//                if (mDialog == null) {
//                    mDialog = new MDialog();
//                }
//            }
//        }
//        return mDialog;
        return new MDialog();
    }

    //设置上下文对象
    public MDialog with(Context context) {
        this.context = context;
        return this;
    }

    // 设置标题
    public MDialog title(String title) {
        this.title = title;
        return this;
    }


    //设置消息
    public MDialog message(String message) {
        this.message = message;
        return this;
    }

    //设置图标
    public MDialog setIconResId(int iconResId) {
        this.iconResId = iconResId;
        return this;
    }

    //设置确认
    public MDialog setOK(String OK) {
        this.OK = OK;
        return this;
    }

    public MDialog setCancel(String Cancel) {
        this.Cancel = Cancel;
        return this;
    }

    public MDialog setTitleSize(int titleSize) {
        this.titleSize = titleSize;
        return this;
    }

    //设置颜色
    public MDialog setMessageSize(int messageSize) {
        this.messageSize = messageSize;
        return this;
    }


    public MDialog setOKSize(int btnOKSize) {
        this.btnOKSize = btnOKSize;
        return this;
    }

    public MDialog setCancelSize(int btnCancelSize) {
        this.btnCancelSize = btnCancelSize;
        return this;
    }


    public MDialog setTitleColor(String titleColor) {
        this.titleColor = titleColor;
        return this;
    }


    public MDialog setMsgColor(String msgColor) {
        this.msgColor = msgColor;
        return this;
    }


    public MDialog setOkColor(String okColor) {
        this.okColor = okColor;
        return this;
    }


    public MDialog setCancelColor(String cancelColor) {
        this.cancelColor = cancelColor;
        return this;
    }

    //显示对话框
    public void show(final OnClickCallback callback) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        if (!TextUtils.isEmpty(message)) {
            builder.setMessage(message);
        }
        if (iconResId != 0) {
            builder.setIcon(iconResId);
        }
        if (TextUtils.isEmpty(Cancel)) {
            Cancel = "取消";
        }
        if (TextUtils.isEmpty(OK)) {
            OK = "确认";
        }
        builder.setNegativeButton(Cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                callback.onCancel();
            }
        });
        builder.setPositiveButton(OK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                callback.onOk();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        //设置属性
        setAttribute(dialog);


    }

    private void setAttribute(AlertDialog dialog) {
        //设置标题
        DialogTitle title = (DialogTitle) dialog.findViewById(R.id.alertTitle);
        TextView textView = (TextView) dialog.findViewById(android.R.id.message);
        Button positiveBtn = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        Button negativeBtn = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        //设置大小
        if (titleSize != 0) title.setTextSize(titleSize);
        if (messageSize != 0) textView.setTextSize(messageSize);
        if (btnOKSize != 0) positiveBtn.setTextSize(btnOKSize);
        if (btnCancelSize != 0) negativeBtn.setTextSize(btnCancelSize);
        //设置颜色

        try {

            if (!TextUtils.isEmpty(okColor))
                positiveBtn.setTextColor(Color.parseColor(okColor));
            if (!TextUtils.isEmpty(cancelColor))
                negativeBtn.setTextColor(Color.parseColor(cancelColor));
            if (!TextUtils.isEmpty(titleColor))
                title.setTextColor(Color.parseColor(titleColor));
            if (!TextUtils.isEmpty(msgColor))
                textView.setTextColor(Color.parseColor(msgColor));

        } catch (Exception e) {

            throw new RuntimeException("颜色属性设置出错，格式为#123456");
        }

    }


    interface IOnClickCallback {
        void onOk();//点击确定的时候回调
    }

    public static abstract class OnClickCallback implements IOnClickCallback {
        public void onCancel() {//点击取消的时候回调
        }
    }


}
