package java.List;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZH on 2016/1/27.
 */
public class Test {
    public List<People> getList(){
        List<People> people = new ArrayList<>();
        People p1 = new People("0","123","男",23);
        People p2 = new People("1","123","男",23);
        People p3 = new People("0","124","男",23);
        People p4 = new People("1","124","女",23);
        People p5 = new People("0","123","女",23);
        People p6 = new People("1","123","男",23);
        People p7 = new People("0","123","男",23);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);
        people.add(p6);
        people.add(p7);

        return convertList(people);
    }

    public List<People> convertList(List<People> people){
        List<People> list = new ArrayList<>();
        People onePeople = new People();
        int age = 0;
        if(people!=null){
            for(int i=0;i<people.size();i++){
               if(people.get(i).getCtrValue()=="0"){
                   list.add(people.get(i));
               } else{
                   if(people.get(i).getName().equals("123")){
                        age += people.get(i).getAge();
                   }else{
                       list.add(people.get(i));
                   }
               }
            }
            onePeople.setCtrValue("1");
            onePeople.setGender("男");
            onePeople.setAge(age);
            onePeople.setName("888");
            list.add(onePeople);
        }
        return list;
    }

    public static void main(String args[]){
        Test test = new Test();
        System.out.print(test.getList());
    }
}
