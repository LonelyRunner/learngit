package javaTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ZH on 2016/7/1.
 */
public class A {
    public static void main(String args[]){
        Map<String,Double> map = new HashMap<>();
        map.put("a",0.10);
        map.put("a",0.11);
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("key=" + key + " value=" + value);
        }
    }
}
