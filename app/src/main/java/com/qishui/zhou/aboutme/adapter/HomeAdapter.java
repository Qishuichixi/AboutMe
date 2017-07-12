package com.qishui.zhou.aboutme.adapter;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.jwkj.libzxing.QRCodeManager;
import com.qishui.zhou.aboutme.R;
import com.qishui.zhou.aboutme.data.ContentData;
import com.qishui.zhou.aboutme.data.Data;
import com.qishui.zhou.aboutme.data.FrameData;
import com.qishui.zhou.aboutme.data.TitleData;
import com.qishui.zhou.aboutme.util.MDialog;
import com.qishui.zhou.aboutme.util.ToastUtils;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 作者：Created by zhou on 2017/7/11 23:33
 * 邮箱：qishuichixi@126.com
 * 版本：V 1.0
 * 描述：
 */


//设置数据
public class HomeAdapter extends BaseRecyclerAdapter<Data> {


    public HomeAdapter(Context context, List<Data> data, MultiTypeSupport<Data> multiTypeSupport) {
        super(context, data, multiTypeSupport);
    }

    @Override
    public void convert(BaseViewHolder holder, final Data item) {

        if (item.type.equals("frame")) {

            FrameLayout frameLayout = holder.getView(R.id.fl);

            if ("aboutme".equals(((FrameData) item).frameTag)) {
                View view = LayoutInflater.from(mContext).inflate(R.layout.evaluation, null);
                frameLayout.addView(view);
            }

            if ("qqandweixin".equals(((FrameData) item).frameTag)) {

                View view = LayoutInflater.from(mContext).inflate(R.layout.linkme, null);

                Bitmap myQQBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.qq);
                Bitmap myWXBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.wx);
                //生成一个带logo的二维码
                final Bitmap mQQBitmap = QRCodeManager.getInstance().createQRCode("QQ：798150439", 300, 300, myQQBitmap);
                ImageView iv_qq = (ImageView) view.findViewById(R.id.qq);
                iv_qq.setImageBitmap(mQQBitmap);

                final Bitmap mWXBitmap = QRCodeManager.getInstance().createQRCode("微信号：qishuichixi", 300, 300, myWXBitmap);
                ImageView iv_wx = (ImageView) view.findViewById(R.id.weixin);
                iv_wx.setImageBitmap(mWXBitmap);

                frameLayout.addView(view);
            }


        }
        if (item.type.equals("title")) {

            holder.setText(R.id.title, ((TitleData) item).title);
        }
        if (item.type.equals("content")) {

            ContentData data = (ContentData) item;
            String text = data.content;
            if (text.equals("unkonw")) {
                text = mContext.getResources().getString(R.string.sz);
            }


            holder.setText(R.id.textView, text);
            final String temp = text;
            holder.setOnIntemClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (temp.contains("18770813363")) {
                        //打电话
                        MDialog.build()
                                .with(mContext)
                                .title("提示")
                                .setTitleSize(20)
                                .message("你要联系我吗，是否拨打电话?")
                                .setMessageSize(18)
                                .setOK("拨打")
                                .setOkColor("#663123")
                                .setCancel("取消")
                                .setCancelColor("#a33400")
                                .show(new MDialog.OnClickCallback() {
                                    @Override
                                    public void onOk() {
                                        call();
                                    }

                                });
                    }
                    if (temp.contains("qishuichixi@126.com")) {
                        //发邮件
                        sendEmail();
                    }
                    if (temp.startsWith("https://")) {
                        //调转web页面
                        openBrowser(temp);
                    }
                }
            });
        }

    }

    //拨打电话
    private void call() {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:18770813363"));
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mContext.startActivity(intent);
    }

    //发邮件
    private void sendEmail() {
        Intent data = new Intent(Intent.ACTION_SENDTO);
        data.setData(Uri.parse("mailto:qishuichixi@126.com"));
        data.putExtra(Intent.EXTRA_SUBJECT, "恭喜周同学成为我公司一部分");
        data.putExtra(Intent.EXTRA_TEXT, "哈哈，我看看，这没毛病~~~~~\n查看时间:" + getTime());
        mContext.startActivity(data);


    }

    /**
     * 在浏览器中打开
     */
    private void openBrowser(String url) {

        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            // 启动浏览器, 谷歌浏览器, 小米手机浏览器支持, 其他手机或浏览器不支持.
            intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
            mContext.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            ToastUtils.show(mContext, "~~~请安装浏览器~~~");
            e.printStackTrace();
        }
    }

    private String getTime() {

        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
    }


}
