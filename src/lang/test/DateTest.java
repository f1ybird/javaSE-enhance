package lang.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间相关测试类：
 *             Date,SimpleDateFormat,Locale,SimpleTimeZone,GregorianCalendar,Calendar
 * @author kevin
 * @date 2017/12/21
 * @Modified By:
 **/
public class DateTest {

    public static void main(String[] args){
        // Date类
        // 比较两个日期
        Date d1 = new Date(99,2,11);
        Date d2 = new Date(99,2,13);
        // 获取毫米数比较
        if(d1.getTime() > d2.getTime()){
            System.out.println("d1 > d2");
        }else{
            System.out.println("d1 < d2");
        }
        // 使用before,after方法比较
        if(d1.after(d2)){
            System.out.println("d1 > d2");
        }else{
            System.out.println("d1 < d2");
        }

        // SimpleDateFormat

        // 日期转时间戳
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        // 2017-12-21 22:11:29
        Timestamp t = Timestamp.valueOf(time);
        System.out.println(t);

        // 时间戳转日期
        // Timestamp t = new Timestamp(2017,12,12,12,12,59,0);
        try {
            Date d4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse( t.toString());
            System.out.println(d4);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Locale

        Locale locale = new Locale("zh","CN");
        /*
        * CN
        * zh
        * 中国
        * 中文
        * */
        System.out.println(locale.getCountry());
        System.out.println(locale.getLanguage());
        System.out.println(locale.getDisplayCountry());
        System.out.println(locale.getDisplayLanguage());

        // 构造一个本地默认的locale实例
        Locale aDefault = Locale.getDefault();
        System.out.println(aDefault.getCountry());
        
        // SimpleTimeZone

        /*
        * 中国
        * 中国标准时间
        * Asia/Shanghai
        * */
        TimeZone aDefault1 = TimeZone.getDefault();
        System.out.println(aDefault.getDisplayCountry());
        System.out.println(aDefault1.getDisplayName());
        System.out.println(aDefault1.getID());

        // GregorianCalendar

        // Calendar instance = GregorianCalendar.getInstance();
        // Thu Dec 21 22:30:43 CST 2017
        //System.out.println(instance.getTime());

        // Thu Dec 21 22:31:52 CST 2017
        // System.out.println(Calendar.getInstance().getTime());
        //System.out.println(new Date());
        //System.out.println(System.currentTimeMillis());
        Calendar instance = Calendar.getInstance();
        // 2017-12-21 10:45:24
        String s2 = instance.get(Calendar.YEAR) + "-"
                + (instance.get(Calendar.MONTH)+1) + "-"
                + instance.get(Calendar.DATE) + " "
                // HOUR 12小时 HOUR_OF_DAY 24小时
                // 2017-12-21 10:49:18
                //+ instance.get(Calendar.HOUR) + ":"
                // 2017-12-21 22:49:18
                + instance.get(Calendar.HOUR_OF_DAY) + ":"
                + instance.get(Calendar.MINUTE) + ":"
                + instance.get(Calendar.SECOND);
        System.out.println(s2);

        // 加一天 +1 减一天 -1
        instance.setTime(new Date());
        System.out.println("原来的日为:" + instance.get(Calendar.DATE));
        instance.add(Calendar.DATE,1);
        System.out.println("加一天后为:" + instance.get(Calendar.DATE));
    }



}
