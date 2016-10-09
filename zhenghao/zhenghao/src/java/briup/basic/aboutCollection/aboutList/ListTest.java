package java.briup.basic.aboutCollection.aboutList;

/**
 * Created by ZH on 2015/11/16.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** List介绍 */
/** 1.允许重复的元素 */
/** 2.用户可以对列表中每个元素的插入位置进行精确地控制 */
/** 3.List里面的元素是有序（存储和取出的元素一致）的并且可以重复 */
public class ListTest {
   public static void main(String... args){
       ListTest lt = new ListTest();
       List list = new ArrayList<String>();
       list.add("a");
       list.add("b");
       list.add("c");
       list.add("a");
       list.add(4,"d");
       lt.loopList1(list);
       System.out.println();
       lt.loopList2(list);
       System.out.println();
       lt.loopList3(list);
   }
    public void loopList1(List list){
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i) + "  ");
        }
    }

    public void loopList2(List<String> list){
        for(String s : list){
            System.out.print(s+"  ");
        }
    }

    public void loopList3(List list){
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+"  ");
        }
    }
}
