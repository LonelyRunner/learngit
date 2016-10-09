package java.briup.basic.aboutCollection.aboutMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ZH on 2015/11/16.
 */
public class MapTest {
    public static void main(String[] args){
        /** Map 不属于集合 */
        /** key->value  键值对存在 */
        Map<String,Student> map = new HashMap<>();
        Student stu1 = new Student("Leborn James","男",30,"NBA现役第一人");
        Student stu2 = new Student("C 罗","男",27,"西甲现役第一人");
        Student stu3 = new Student("习近平","男",66,"中国现役第一人");
        Student stu4 = new Student("Leborn James","",30,"NBA现役第一人");

        map.put("first",stu1);
        map.put("second",stu2);
        map.put("third",stu3);
        map.put("forth",stu4);

       MapTest m = new MapTest();
        m.loopMap1(map);
        System.out.println("-----------------Hero-------------");
        m.loopMap2(map);
        System.out.println("-----------------Hero-------------");
        m.loopMap3(map);
        System.out.println("-----------------Hero-------------");
        m.loopMap4(map);
    }

    /** 遍历map集合的方法 */
    public void loopMap1(Map<String,Student> map){
        System.out.println("通过Map.keySet遍历key和value：");
        for(String s : map.keySet()){
            System.out.println("key is "+s+"  value is "+map.get(s).toString());
        }
    }

    public void loopMap2(Map<String,Student> map){
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String,Student>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            System.out.println("key is "+iterator.next().getKey()+" value is "+iterator.next().getValue().toString());
        }
    }

    public void loopMap3(Map<String,Student> map){
        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        for(Map.Entry<String,Student> m : map.entrySet()){
            System.out.println("key is "+m.getKey()+" value is "+m.getValue().toString());
        }
    }

    public void loopMap4(Map<String,Student> map){
        for(Object o : map.values()){
            System.out.println(o.toString());
        }
    }


}
