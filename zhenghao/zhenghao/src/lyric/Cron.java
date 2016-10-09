package lyric;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ZH on 2016/3/23.
 */
public class Cron {
    /** 正则表达式匹配Cron表达式 */
    public static void main(String args[]){
        /**
            // 要验证的字符串
            String str = "service@xsoftlab.net";
            // 邮箱验证规则
            String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
            // 编译正则表达式
            Pattern pattern = Pattern.compile(regEx);
            // 忽略大小写的写法
            // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(str);
            // 字符串是否与正则表达式相匹配
            boolean rs = matcher.matches();
            System.out.println(rs);
        */


        StringBuilder sb = new StringBuilder("0");
        sb.append(" 0").append(" 12").append(" *").append(" *").append(" ?");
        String cronStr = sb.toString();
        System.out.println(cronStr);
        boolean b = false;
        /**
         * String cronRegEx = "";
            Pattern cronPattern = Pattern.compile(cronRegEx);
            Matcher cronMatcher = cronPattern.matcher(cronStr);
            boolean cronRs = cronMatcher.matches();
            System.out.println(cronRs);
        */
        int cronStrLength = cronStr.split(" ").length;
        if(cronStrLength==6 || cronStrLength == 7){
            b = true;
        }else{
            b = false;
        }

        if(b){
            System.out.println("符合Cron表达式");
        }else{
            System.out.println("Cron表达式出错");
        }

        String[] s = new String[2];
        s[0] = "/";
        s[1] = "*";
        String test = "*";
        boolean br = Cron.isOneOfArray(test,s);
        System.out.println(br);
    }

    public static boolean isOneOfArray(String a,String[] array){
        boolean exist = false;
        for(int i=0;i<array.length;i++){
            if(a.equals(array[i])){
                exist = true;
                break;
            }
        }
        return exist;
    }
}
