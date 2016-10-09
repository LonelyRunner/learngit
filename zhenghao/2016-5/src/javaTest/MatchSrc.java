package javaTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ZH on 2016/5/11.
 */
public class MatchSrc {
    public static void main(String args[]){
        String str = "<img src=\"1.jpg\"><img src=\"2.jpg\"><img src=\"3.jpg\">";
        Pattern pattern = Pattern.compile("src=\"(\\w+\\.\\w+)\"",'g');
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group(1));
        }
    }
}