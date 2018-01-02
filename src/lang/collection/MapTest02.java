package lang.collection;

import java.util.*;

/**
 * Map测试类
 *
 * 【HashMap】
 *
 *  HashMap允许使用null 值和 null 键
 *  不同步
 *
 *  HashMap的底层主要是基于数组和链表来实现的，它之所以有相当快的查询速度主要是因为
 *  它是通过计算散列码来决定存储的位置。HashMap中主要是通过key的hashCode来计算hash值的，
 *  只要hashCode相同，计算出来的hash值就一样。如果存储的对象对多了，就有可能不同的对象所
 *  算出来的hash值是相同的，这就出现了所谓的hash冲突。
 *  学过数据结构的同学都知道，解决hash冲突的方法有很多，HashMap底层是通过链表来解决hash冲突的。
 *
 *  loadFactor加载因子是表示Hsah表中元素的填满的程度."冲突的机会"与"空间利用率"之间
 *  寻找一种平衡与折衷. 这种平衡与折衷本质上是数据结构中有名的"时-空"矛盾的平衡与折衷.
 *
 *  默认情况下，数组大小为【16】，那么当HashMap中元素个数超过【16*0.75=12】的时候，
 *  就把数组的大小扩展为 【2*16=32】，即扩大一倍，然后重新计算每个元素在数组中的位置，
 *  扩容是需要进行数组复制的，复制数组是非常消耗性能的操作，所以如果我们已经预知HashMap
 *  中元素的个数，那么预设元素的个数能够有效的提高HashMap的性能。
 *
 *  HashMap()：构建一个初始容量为 16，负载因子为 0.75 的 HashMap。
 *  HashMap(int initialCapacity)：构建一个初始容量为 initialCapacity，负载因子为 0.75 的 HashMap。
 *  HashMap(int initialCapacity, float loadFactor)：以指定初始容量、指定的负载因子创建一个 HashMap。
 *  HashMap的基础构造器HashMap(int initialCapacity, float loadFactor)带有两个参数，
 *  它们是初始容量initialCapacity和加载因子loadFactor。
 *
 *  HashMap的实现中，通过threshold字段来判断HashMap的最大容量：
 *  threshold = (int)(capacity * loadFactor);
 *
 *
 * @author kevin
 * @date 2018/01/02
 * @Modified By:
 **/
public class MapTest02 {
    public static void main(String[] args) {
        // 1. Map转换List
        Map<String, String> map = new HashMap<>();
        List keyList1 = new ArrayList(map.keySet());
        List keyList2 = new ArrayList(map.values());
        List keyList3 = new ArrayList(map.entrySet());

        // 2. 遍历map
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
        }
        // or use : map.keySet().iterator();

        // 3.创建一个static的map
//        static{
//            Map aMap = new HashMap();
//            aMap.put(1, "one");
//            aMap.put(2, "two");
//            map = Collections.unmodifiableMap(aMap);
//        }

        // 4.拷贝一个map
        Map<String, String> synchronizedMap = Collections.synchronizedMap(map);

        // 5.创建一个空map
        Map<Object, Object> emptyMap = Collections.emptyMap();
        // HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

        // 6.对map进行反向查找，即通过值查找键
        map.put("1", "11");
        map.put("2", "22");
        map.put("3", "33");

        for (Map.Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value.equals("33")) {
                Object key = entry.getKey();
                System.out.println("key->" + key + ",value->" + value);
                break;
            }
        }
    }
}
