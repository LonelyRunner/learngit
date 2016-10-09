package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZH on 2016/9/19.
 */
public class Test {

    public static void main(String args[]){
        //数据库中查询出的List集合
        List<ClassOne> list = new ArrayList<>();
        ClassOne classOne1 = new ClassOne("自费",12,32,21);
        ClassOne classOne2 = new ClassOne("半费",122,322,231);
        ClassOne classOne3 = new ClassOne("公费",123,312,215);

        list.add(classOne1);
        list.add(classOne2);
        list.add(classOne3);

        //基础字典中的费别dict
        String[] names = new String[]{"自费","公费","半费","地方医保","新农合","北京医保","军队医改"};

        List<ClassTwo> resultList = new ArrayList<>();

        Map<String,Number> mapShould = new HashMap<>();
        Map<String,Number> mapFact = new HashMap<>();
        Map<String,Number> mapSettle = new HashMap<>();

        //初始化map
        for(int i=0;i<names.length;i++){
            mapShould.put(names[i],0);
            mapFact.put(names[i],0);
            mapSettle.put(names[i],0);
        }

        ClassTwo classTwo1 = new ClassTwo();
        classTwo1.setName("应收");
        classTwo1.setChargeMap(mapShould);
        ClassTwo classTwo2 = new ClassTwo();
        classTwo2.setName("实收");
        classTwo2.setChargeMap(mapFact);
        ClassTwo classTwo3 = new ClassTwo();
        classTwo3.setName("结算");
        classTwo3.setChargeMap(mapSettle);

        Map<String,Number> map1 = classTwo1.getChargeMap();
        Map<String,Number> map2 = classTwo2.getChargeMap();
        Map<String,Number> map3 = classTwo3.getChargeMap();

        //循环设置map中的值

        for(int i=0;i<list.size();i++){
            for(int j=0;j<names.length;j++){
                if(list.get(i).getChargeType().equals(names[j])){
                    map1.put(list.get(i).getChargeType(),list.get(i).getShouldGet());
                    map2.put(list.get(i).getChargeType(),list.get(i).getFactGet());
                    map3.put(list.get(i).getChargeType(),list.get(i).getSettle());
                }
            }
        }

        resultList.add(classTwo1);
        resultList.add(classTwo2);
        resultList.add(classTwo3);

        for(ClassTwo classTwo : resultList){
            System.out.println(classTwo);
        }
    }
}
