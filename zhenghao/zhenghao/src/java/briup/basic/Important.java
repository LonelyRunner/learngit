package java.briup.basic;

/**
 * Created by ZH on 2016/1/12.
 */
public class Important {
    public static void main(String args[]){
        char b = '范';
        int a = (int)b;
        System.out.println(a);
    }
    /** 将汉字转换为ASCII码 */
    public static void convertHanZi(String str){
        char[] chars = str.toCharArray();
        for(int i=0;i<chars.length;i++){
            System.out.print((int)chars[i]+" ");
        }
    }
}
