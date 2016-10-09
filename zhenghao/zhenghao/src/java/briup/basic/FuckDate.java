package java.briup.basic;

/**
 * Created by ZH on 2015/11/13.
 */
public class FuckDate {
     public static void main(String[] args){
         System.out.println("世界上最头疼的事情就是不努力的程序员遇上时间问题");
         System.out.println(FuckDate.class);
         FuckDateSon fds = new FuckDateSon();
         fds.RNM();
     }

    public static class Problem{

    }
}

class FuckDateSon{
    private String name;

    public void RNM(){
        System.out.println("日尼玛？");
    }
}

