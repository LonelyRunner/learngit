package java.briup.Reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ZH on 2016/2/22.
 */
public class RegTest {
    public static void main(String args[]){
        String Email1 = "826270362@qq.com";
        boolean b1 = volidateEmail(Email1);
        System.out.println(b1);

        /** 简单的正则表达匹配 */
        //method 1
        Pattern pattern = Pattern.compile("b*g");
        Matcher m = pattern.matcher("bbbbbbg");
        System.out.println(m);
        boolean b = m.matches();
        System.out.println(b);
        //method 2
        System.out.println(Pattern.matches("b*g","g"));
    }

    public static boolean volidateEmail(String text){
        /** 普通方法验证E-mail(邮箱的正确格式:必须包含@和.  不能以@和.开头  @要在最后一个.之前) */
        /** 826270362@qq.com */
        int atIndex = text.indexOf('@');
        int dotLastIndex = text.lastIndexOf('.');
        int textLen = text.length();

        if(atIndex<0 || dotLastIndex<0){
            return false;
        }

        if(atIndex==0 || atIndex==textLen || dotLastIndex==0 || dotLastIndex==textLen){
            return false;
        }

        if(atIndex > dotLastIndex){
            return false;
        }
        return true;
    }

    public static boolean verifyByReg(String text){
        /** 邮件 826270362@qq.com
         * 1.不能以.和@开头
         * 2.最后一个@必须在最后一个.之前
         * 3.必须包含@和.*/
        String reg = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
        return true;
    }
}
