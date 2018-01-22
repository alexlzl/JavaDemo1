package com.test;

import com.sun.jmx.snmp.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by liuzhouliang on 2018/1/22.
 */
public class Test {
    private static long time=1516090441511L;
//    private static long time=1516513903000L;
    public static void main(String[] args){
//        System.out.println(showDate(getDatefromTime(time),"yyyy-MM-dd HH:mm:ss"));
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeS="2018-01-21 13:51:43";
        Date date = null;
        try {
            date = format.parse(timeS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Format To times:"+date.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println( sdf.format( new Date(time)));
//       String dayType= TimeToDateUtil.getDates(time / 1000);
//       System.out.println(dayType);
        System.out.println( getTodayOrYesterday(date.getTime()));
        System.out.println( getTimeStateNew(date.getTime()+""));
    }
    public static Date getDatefromTime(long num) {
        return new Date(num);
    }
    public static String showDate(Date date, String pattern){
        String  dateStr=format(date,pattern);
        String year = dateStr.substring(0,4);
        Long yearNum =Long.parseLong(year);
        int month = Integer.parseInt(dateStr.substring(5,7));
        int day = Integer.parseInt(dateStr.substring(8,10));
        String hour = dateStr.substring(11,13);
        String minute = dateStr.substring(14,16);

        long addtime =date.getTime();
        long today = System.currentTimeMillis();//当前时间的毫秒数
        Date now = new Date(today);
        String  nowStr=format(now,pattern);
        int  nowDay = Integer.parseInt(nowStr.substring(8,10));
        String result="";
        long l=today-addtime;//当前时间与给定时间差的毫秒数
        long days=l/(24*60*60*1000);//这个时间相差的天数整数，大于1天为前天的时间了，小于24小时则为昨天和今天的时间
        long hours=(l/(60*60*1000)-days*24);//这个时间相差的减去天数的小时数
        long min=((l/(60*1000))-days*24*60-hours*60);//
        long s=(l/1000-days*24*60*60-hours*60*60-min*60);
        if(days > 0){
            if(days>0 && days<2){
                result ="前天"+hour+"点"+minute+"分";
            } else {
                result = yearNum%100+"年"+month+"月 "+day+"日"+hour+"点"+minute+"分";
            }
        }else if(hours > 0 ) {
            if(day!=nowDay){
                result = "昨天"+hour+"点"+minute+"分";
            }else{
                result=hours+"小时 前";
            }
        } else if(min > 0){
            if(min>0 && min<15){
                result="刚刚";
            } else {
                result=min+"分 前";
            }
        }else {
            result=s+"秒 前";
        }
        return result;
    }
    /**
     * 日期格式化
     * @param date      需要格式化的日期
     * @param pattern   时间格式，如：yyyy-MM-dd HH:mm:ss
     * @return          返回格式化后的时间字符串
     */
    public static String format(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
    public static String getTodayOrYesterday(long date) {//date 是存储的时间戳
        //所在时区时8，系统初始时间是1970-01-01 80:00:00，注意是从八点开始，计算的时候要加回去
        int offSet = Calendar.getInstance().getTimeZone().getRawOffset();
        long today = (System.currentTimeMillis()+offSet)/86400000;
        long start = (date+offSet)/86400000;
        long intervalTime = start - today;
        //-2:前天,-1：昨天,0：今天,1：明天,2：后天
        String strDes="";
        if(intervalTime==0){
            strDes= "今天";//今天
        }else if(intervalTime==-1){
            strDes= "昨天";//昨天
        }else if(intervalTime==-2){
            strDes= "前天";
        }else if(intervalTime==1){
            strDes= "明天";
        }else if(intervalTime==2){
            strDes= "后天";
        }
        else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            strDes=sdf.format( new Date(date));//直接显示时间

        }
        return strDes;
    }

    public static String getTimeStateNew(String long_time){
        String long_by_13="1000000000000";
        String long_by_10="1000000000";
        if(Long.valueOf(long_time)/Long.valueOf(long_by_13)<1){
            if(Long.valueOf(long_time)/Long.valueOf(long_by_10)>=1){
                long_time=long_time+"000";
            }
        }
        Timestamp time=new Timestamp(Long.valueOf(long_time));
        Timestamp now=new Timestamp(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//    System.out.println("传递过来的时间:"+format.format(time));
//    System.out.println("现在的时间:"+format.format(now));
        long day_conver=1000*60*60*24;
        long hour_conver=1000*60*60;
        long min_conver=1000*60;
        long time_conver=now.getDateTime()-time.getDateTime();
        long temp_conver;
//    System.out.println("天数:"+time_conver/day_conver);
        if((time_conver/day_conver)<3){
            temp_conver=time_conver/day_conver;
            if(temp_conver<=2 && temp_conver>=1){
                return temp_conver+"天前";
            }else{
                temp_conver=(time_conver/hour_conver);
                if(temp_conver>=1){
                    return temp_conver+"小时前";
                }else {
                    temp_conver=(time_conver/min_conver);
                    if(temp_conver>=1){
                        return temp_conver+"分钟前";
                    }else{
                        return "刚刚";
                    }
                }
            }
        }else{
            return format.format(time);
        }
    }

}
