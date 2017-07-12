package com.qishui.zhou.aboutme.util;

import com.qishui.zhou.aboutme.data.ContentData;
import com.qishui.zhou.aboutme.data.Data;
import com.qishui.zhou.aboutme.data.FrameData;
import com.qishui.zhou.aboutme.data.TitleData;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Created by zhou on 2017/7/11 23:32
 * 邮箱：qishuichixi@126.com
 * 版本：V 1.0
 * 描述：
 */

public class CommonUtils {

    //设定数据源
   public static List<Data> setData() {
        List<Data> list = new ArrayList<>();
        list.add(new TitleData("title", "基本信息"));
        list.add(new ContentData("content", "姓名:周文熙"));
        list.add(new ContentData("content", "年龄:22"));
        list.add(new ContentData("content", "毕业学校:华东交通大学"));
        list.add(new ContentData("content", "专业:软件工程"));
        list.add(new ContentData("content", "毕业时间:2017/06"));
        list.add(new ContentData("content", "手机号:18770813363"));
        list.add(new ContentData("content", "邮箱:qishuichixi@126.com"));
        list.add(new TitleData("title", "JAVA知识"));
        list.add(new ContentData("content", "清楚封装、继承、多态、抽象面向对象编程思想"));
        list.add(new ContentData("content", "清楚异常处理机制"));
        list.add(new ContentData("content", "多线程的使用"));
        list.add(new ContentData("content", "清楚重要集合List、Map等用法"));
        list.add(new ContentData("content", "mysql数据库操作"));
        list.add(new ContentData("content", "了解IO、反射、内部类、正则表达式、TCP/UDP概"));
        list.add(new TitleData("title", "JAEE知识"));
        list.add(new ContentData("content", "清楚html、jsp等网站开发语言"));
        list.add(new ContentData("content", "Struts2、hibernate简单使用"));
        list.add(new ContentData("content", "清楚servlet的使用、清楚在线网站部署"));
        list.add(new TitleData("title", "Android知识"));
        list.add(new ContentData("content", "清楚四大组件Activity、Service、BroadcastReceiver、ContentProvider"));
        list.add(new ContentData("content", "清楚Sqlite、SharedPreferences、文件数据存储，解析json和xml文件"));
        list.add(new ContentData("content", "清楚HttpUrlConnection、HttpClient使用请求、异步任务AysncTask"));
        list.add(new ContentData("content", "会用RecyclerView上拉刷新、下拉加载、多条目布局、添加头布局等"));
        list.add(new ContentData("content", "清楚Fragment、viewpager、回调机制概念、MVC架构模式"));
        list.add(new ContentData("content", "清楚第三方登录、短信验证、分享、推送、支付宝的使用"));
        list.add(new ContentData("content", "清楚自定义控件基本操作流程，基本动画的使用"));
        list.add(new TitleData("title", "项目经历之D帮美食系统"));
        list.add(new ContentData("content", "该项目是主要为17年6月毕业答辩准备的，是一个社区类的App应用软件。项目中简单流程有splash欢迎页面，Guide引导页面，登录注册页面，主页面采用Layout+Fragment+ViewPager方式，内容区使用recyclerview多条目上拉刷新下拉加载，ViewPager轮播推荐机制"));
        list.add(new TitleData("title", "使用技术"));
        list.add(new ContentData("content", "使用Glide图片加载框架"));
        list.add(new ContentData("content", "使用OKHttp框架请求网络、下载文件，清楚GSON解析json框架"));
        list.add(new ContentData("content", " 使用自定义加载为空，加载出错，加载中"));
        list.add(new ContentData("content", "使用ZXing生成二维码信息及扫描"));
        list.add(new ContentData("content", "使用PhotoView放大图片，Banner部分作为轮播图"));
        list.add(new ContentData("content", "使用SuperTextView简单条目布局"));
        list.add(new ContentData("content", " 使用LitePal和ASimpleCache缓存数据"));
        list.add(new ContentData("content", "使用Fragment+ViewPage为主布局，XRecyclerview页面展示"));
        list.add(new TitleData("title", "Github/Blog"));
        list.add(new ContentData("content", "https://my.oschina.net/u/3015461/blog"));
        list.add(new ContentData("content", "https://github.com/Qishuichixi/"));
        list.add(new ContentData("content", "写博客和提交代码到GitHub上的好处就是加深印象，下次接触到类似的时候效率更快、更准。对照他人的博客知识，可以看出自己的不足。常去的网站有csdn、开源中国、简书、博客园等"));
        list.add(new TitleData("title", "工作经历"));
        list.add(new ContentData("content", "2016.6-2016.9在昆山杰普软件公司，进行android培训，该公司主要是与学校合作"));
        list.add(new ContentData("content", "2016.12-2016.5在安硕公司技术Java开发"));
        list.add(new TitleData("title", "个人评价"));
        list.add(new FrameData("frame", "aboutme"));
        list.add(new TitleData("title", "也可以扫码联系我QQ或者微信"));
        list.add(new FrameData("frame", "qqandweixin"));
        list.add(new ContentData("content", "unkonw"));


        return list;
    }
}
