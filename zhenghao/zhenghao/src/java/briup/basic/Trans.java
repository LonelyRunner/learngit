package briup.basic;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ZH on 2016/8/4.
 */
public class Trans {
    public static void main(String args[]) throws Exception{
        String str = "2017-02";
        String str1 = "2017-02-03";
        System.out.println(transStringToDate(str));
        System.out.println(transStringToDate(str1));
    }

    public static Date transStringToDate(String str) throws Exception{
        SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY-MM");
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
        if(str.length()<8){
            return sdf1.parse(str);
        }else{
            return sdf.parse(str);
        }
    }
}
