package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuzhouliang on 2017/12/5.
 */
public class Test {

    public static void main(String[] args){
        Date now =new Date();
        //2016-08-12 09:55:23
        //yyyy-MM-dd hh:ss:mm
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 hh时ss分mm秒");
        String str = sdf.format(now);
        System.out.println(str);

        //a 居然能区分上下午汉字
        String strDate="2012年12月20日下午12点20分30秒";
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy年MM月dd日ahh点ss分mm秒");
        Date date= null;
        try {
            date = sdf2.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
    }
}
