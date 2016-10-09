package java.innerClass;

/**
 * Created by ZH on 2015/12/31.
 */
public class MemberInnerClass {
    private String name = "radio";

    public int a = 6;

    protected boolean fuckYou = false;

    public int getLength(String str){
        return str.length();
    }
    /** 成员内部类 */
    class Member{
        String name = "CD";

        int a = 8;

        int var = getLength("牛萌帆");

        public void getOuterClassSomething(){
            System.out.println("访问外部类的私有成员:"+MemberInnerClass.this.name);
            System.out.println("访问本类的成员:"+name);
            System.out.println("访问外部类公共成员:"+MemberInnerClass.this.a);
            System.out.println("访问本类成员:"+a);
            System.out.println(var);
        }
    }

    /** 成员内部类是依附外部类而存在的，也就是说，如果要创建成员内部类的对象，前提是必须存在一个外部类的对象
     *
     * Outter outter = new Outter();
       Outter.Inner inner = outter.new Inner();
       //必须通过Outter对象来创建
     */
    public static void main(String args[]){
        MemberInnerClass memberInner = new MemberInnerClass();
        Member member = memberInner.new Member();
        member.getOuterClassSomething();

        System.out.println("Math.round(11.5) = "+Math.round(11.5));
        System.out.println("Math.round(11.5) = "+Math.round(-11.5));
    }
}
