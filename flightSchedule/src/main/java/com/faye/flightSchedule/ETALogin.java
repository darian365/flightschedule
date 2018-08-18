package com.faye.flightSchedule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ETALogin {

	public static String LOGIN_URL = "https://apps4.talonsystems.com/tseta/servlet/content?module=home&page=homepg&customer=eta0029&action=login_eta";
    public static String MYSCHEDULE_URL = "https://apps4.talonsystems.com/tseta/servlet/content?module=home&page=homepg&content_type=mysched&maxdayshow=7&";
	public static String USER_AGENT = "User-Agent";
    public static String USER_AGENT_VALUE = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36";
    public static String REFERRAL = "Referer";
    public static String REFERRAL_VALUE = "https://apps4.talonsystems.com/tseta/servlet/content?module=home&page=homepg&customer=eta0029&action=login_eta&&action=login_eta";
    public static void main(String[] args) throws Exception {
 
        simulateLogin("sz11phil", "lileo333"); // 模拟登陆github的用户名和密码
 
    }
 
    /**
     * @param userName 用户名
     * @param pwd 密码
     * @throws Exception
     */
    public static void simulateLogin(String userName, String pwd) throws Exception {
 
        /* 
         * 第一次请求 
         * grab login form page first
         * 获取登陆提交的表单信息，及修改其提交data数据（login，password）
         */
        // get the response, which we will post to the action URL(rs.cookies())
        Connection con = Jsoup.connect(LOGIN_URL);  // 获取connection
        con.header(USER_AGENT, USER_AGENT_VALUE);   // 配置模拟浏览器
        con.cookie("JSESSIONID", "42615E1B69A7FB278BEB9F0CD51D6211");
        con.cookie("taid73", "42DC6E6C4E5A723E80D0BF0AC5A1C8AF");
        con.data("uname", userName);
        con.data("password", pwd);
        Response rs = con.ignoreContentType(true).followRedirects(true).method(Method.POST).execute();                // 获取响应
//        System.out.println(rs.body());
 
        /*
         * 第二次请求，以post方式提交表单数据以及cookie信息
         */
        con = Jsoup.connect(MYSCHEDULE_URL);
        con.header(USER_AGENT, USER_AGENT_VALUE);   // 配置模拟浏览器
        con.header(REFERRAL, REFERRAL_VALUE);
        con.cookie("JSESSIONID", "F879179B43125B9A6758FE337FA073C1");
        con.cookie("taid73", "42DC6E6C4E5A723E80D0BF0AC5A1C8AF");
        // 设置cookie和post上面的map数据
        Response myschedule = con.ignoreContentType(true).followRedirects(true).method(Method.GET).execute();
        // 打印，登陆成功后的信息
        // parse the document from response
//        System.out.println(myschedule.body());
        Document document = Jsoup.parse(myschedule.body());
        List<Element> tables = document.select("table");
        Element schedule = tables.get(12).parent();
//        System.out.println(tables.size());
        EmailSender.send(schedule.html());
    }
}
