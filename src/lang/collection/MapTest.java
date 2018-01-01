package lang.collection;

import java.util.*;

/**
 * LinkedHashMap和HashMap,TreeMap的区别
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, String> treeMap = new TreeMap<String, String>();
        //Map<String, String> linkedMap = new LinkedHashMap<String, String>();
        Map<String, String> linkedMap = new HashMap<>();

        treeMap.put("a", "222");
        treeMap.put("c", "111");
        treeMap.put("a", "333");
        for (Iterator<String> iter = treeMap.keySet().iterator(); iter.hasNext(); ) {
            System.out.println("TreeMap=" + iter.next());
        }

        System.out.println("----------分割线---------");

        linkedMap.put("a", "222");
        linkedMap.put("c", "111");
        linkedMap.put("a", "333");
        for (Iterator<String> iter = linkedMap.keySet().iterator(); iter.hasNext(); ) {
            System.out.println("LinkedHashMap=" + iter.next());
        }

        // 结果
        /*TreeMap = a
        TreeMap = b
        TreeMap = c
        ---------- 分割线-------- -
        LinkedHashMap = b
        LinkedHashMap = c
        LinkedHashMap = a*/
    }
}