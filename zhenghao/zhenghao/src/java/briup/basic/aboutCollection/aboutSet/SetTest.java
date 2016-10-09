package java.briup.basic.aboutCollection.aboutSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by ZH on 2015/11/16.
 */
public class SetTest {
    /** set中不允许出现重复的元素 */
    public static void main(String args[]){
        SetTest st = new SetTest();
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("a");
        st.loopSet1(set);
        System.out.println();
        st.loopSet2(set);
    }

    public void loopSet1(Set<String> set){
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
    }
    public void loopSet2(Set<String> set){
        for(String s : set){
            System.out.print(s + " ");
        }
    }

}
