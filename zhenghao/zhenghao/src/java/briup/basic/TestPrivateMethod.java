package java.briup.basic;

/**
 * Created by ZH on 2016/1/12.
 */
public class TestPrivateMethod {
    private String str;

    private String getPrivateStr(String str){
        return str;
    }

    public static void main(String args[]){
        TestPrivateMethod tpm = new TestPrivateMethod();
        tpm.getPrivateStr("sb");
    }
}
