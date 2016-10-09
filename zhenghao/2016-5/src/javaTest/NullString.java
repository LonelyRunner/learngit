package javaTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ZH on 2016/6/16.
 */
public class NullString {
    public static void main(String args[]){
        String reg = "";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher("");
        boolean b= matcher.matches();
        System.out.println(b);
        System.out.println(reg.matches(""));
    }
}
