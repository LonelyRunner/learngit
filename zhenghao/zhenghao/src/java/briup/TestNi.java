package java.briup;

/**
 * Created by ZH on 2016/2/24.
 */
public class TestNi {
    public static void main(String args[]){
        String str = "{a_4=张三丰, b_1=3, c=2}";
        int j=0;
        String[] ss = new String[3];
        String[] s = str.split("[\\{\\}=, ]");
        System.out.println(s.length);

        for(int i=0;i<s.length;i++){
            if(!s[i].equals("") && i%2==1){
                ss[j] = s[i];
                j++;
            }
        }
        System.out.println("=======================");
        for(int k=0;k<ss.length;k++){
            System.out.println(ss[k]);
        }
        System.out.println("=======================");

        for(String a : s){
            System.out.println(a);
        }
    }
}
