package java.briup.basic.排序;

import java.util.Arrays;

/**
 * Created by ZH on 2016/1/18.
 */
public class SampleComparable implements Comparable<SampleComparable>{

    private String id;
    private int age;

    public SampleComparable(String id,int age){
        this.id = id;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int compareTo(SampleComparable o){
        return this.age - o.getAge();
    }

    @Override
    public String toString() {
        return "SampleComparable{" +
                "id='" + id + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String args[]){
        SampleComparable user1 = new SampleComparable("1",12);
        SampleComparable user2 = new SampleComparable("2",15);
        SampleComparable[] sampleComparable = new SampleComparable[]{user1,user2};
        Arrays.sort(sampleComparable);
        for(SampleComparable s1 : sampleComparable){
            System.out.println(s1);
        }
    }
}
