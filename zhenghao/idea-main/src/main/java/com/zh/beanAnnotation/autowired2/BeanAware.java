package com.zh.beanAnnotation.autowired2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by ZH on 2016/8/8.
 */
@Component
public class BeanAware {

    @Autowired
    private List<BeanAutowired> list;

    @Autowired
    private Map<String,BeanAutowired> map;

    @Autowired
    @Qualifier("beanAutowiredOne")
    private BeanAutowired beanAutowired;

    @Autowired
    @Genor("beanAutowiredTwo")
    private BeanAutowired beanAutowired2;

    public void sayList(){
        System.out.println("List<BeanAutowired> list 方式注入");
        if(null!=list){
            for(BeanAutowired beanAutowired : list){
                System.out.println(beanAutowired.getClass().getName());
            }
        }
    }

    public void sayMap(){
        System.out.println("Map<String,BeanAutowired> map 方式注入");
        if(map.size()!=0 && map!=null){
            for(Map.Entry<String,BeanAutowired> entry : map.entrySet()){
                System.out.println(entry.getKey()+"    "+entry.getValue().getClass().getName());
            }
        }
    }

    public void sayQualifier(){
        System.out.println("qualifier注解 ： "+beanAutowired.getClass().getName());
        System.out.println("qualifier注解 ： "+beanAutowired2.getClass().getName());
    }

}
