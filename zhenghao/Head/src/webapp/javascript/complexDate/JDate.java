package webapp.javascript.complexDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JDate {
    //java中比较难缠的时间

    //1.输出当前日期
    public static Date getCurrentJDate(){
        Date nowDate = new Date();
        return nowDate;
    }


    //2.格式化当前日期 YYYY-MM-DD
    public static String getCurrentJFormateDate(){
        Calendar c = Calendar.getInstance();
        String year = c.get(Calendar.YEAR)+"";
        String month = (c.get(Calendar.MONTH)+1)+"";
        String date = c.get(Calendar.DATE)+"";
        String hour = c.get(Calendar.HOUR)+"";
        String minute = c.get(Calendar.MINUTE)+"";
        String second = c.get(Calendar.SECOND)+"";
        return year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
    }

    //3.使用simpleFormatDate格式化日期
    /**
     * SimpleDateFormate.format(Date)  -->  String  将日期类型转换为字符串类型
     * SimpleDateFormate.parse(String) -->  Date    将字符串类型转换为日期类型
     */
    public static String getCurrentJSFromateDate() throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        String s = sdf.format(c.getTime());
        return s;
    }


    //获取前一天时间
    public static Date getBeforeDate(){
        Date nowDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(nowDate);
        c.add(Calendar.DAY_OF_MONTH, -1);
        nowDate = c.getTime();
        return nowDate;
    }

    //获取后一天时间
    public static Date getAfterDate(){
        Date nowDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(nowDate);
        c.add(Calendar.DAY_OF_MONTH,1);
        nowDate = c.getTime();
        return nowDate;
    }

    //使用参数返回日期类型
    public static Date getDateByParams(int year,int month,int date) throws ParseException{
        String s = year+""+getSuffix(month)+""+getSuffix(date)+"";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date d = sdf.parse(s);

        return d;
    }

    public static String getSuffix(int i){
        if(i>=10){
            return i+"";
        }else{
            return "0"+i;
        }
    }

    public static void main(String[] args) throws Exception{
        System.out.println(getCurrentJDate());
        System.out.println(getCurrentJFormateDate());
        System.out.println(getCurrentJSFromateDate());
        System.out.println(getBeforeDate());
        System.out.println(getAfterDate());

        System.out.println(getDateByParams(2017,3,2));
    }
}
