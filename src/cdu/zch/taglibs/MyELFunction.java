package cdu.zch.taglibs;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MyELFunction {

    // 定义两种时间格式
    /*
     * 1、2022-11-20
     * 2、2022-11-20 00:00:00
     * */
    public static SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat sdfYMDHMS = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    /*
     * 定义三种函数，分别返回不同的处理之后的格式
     * 1、返回中国区的货币格式
     * 2、返回第一种时间格式
     * 3、返回第二种时间格式
     * */
    public static String currency(BigDecimal money){
        return DecimalFormat.getCurrencyInstance(Locale.CHINA).format(money);
    }

    public static String formatDate(long time){
        return sdfYMD.format(time);
    }

    public static String formatDatetime(long time){
        return sdfYMDHMS.format(time);
    }
}
