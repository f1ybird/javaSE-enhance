package lang.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * List测试类
 *
 * 出现错误：fail-fast
 * 解决方案：<1>、fail-safe 使用并发库（java.util.concurrent）下
 *              的CopyOnWriteArrayList类可以解决该问题，但是性能开销很大。
 *         <2>、先使用一个临时的List集合来存放需要移除的元素，最后使用removeAll方法来移除所有。
 */
public class ListTest {
    private static List<String> list = new ArrayList<String>();// fail-fast
    // 解决方案1
    //private static List<String> list = new CopyOnWriteArrayList<String>();// fail-safe

    // 解决方案2 新建一个集合存储要删除的元素，便利完毕后再删除该集合
    private static List<String> delList = new ArrayList<String>();

    public static void init(int num) {
        for (int i = 0; i < num; i++) {
            list.add(i + "");
        }
    }

    public static void main3(String[] args) {
        int num = 5;
        init(num);
        for (String string : list) {
            if (string.equals(num - 1 + "")) {
                System.out.println("执行remove操作");
                list.remove(string);
            } else {
                System.out.println(string);
            }
        }
    }
    public static void main(String[] args) {
        int num = 5;
        init(num);
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            String string = (String) iterator.next();
            if (string.equals(num - 2 + "")) {
                System.out.println("执行remove操作");
                delList.add(string);
                //list.remove(string);
            } else {
                System.out.println(string);
            }
        }
        delList.removeAll(delList);// 删除遍历过程中选定的元素。
        // 结果如下
        /*
            0
            1
            2
            执行remove操作

            上述结果显然是有问题的，我们认为的正确结果应该是：

            0
            1
            2
            执行remove操作
            4

            那为什么没有打印4呢？原因：当if条件成立时，也就是string等于3时，
            执行移除操作，下标为3的元素移除后，那下标为4的元素前移一位，就刚好
            满足跳出循环的条件，因为游标在3的位置，前移后下标为4的位置就没有元素了，
            这时结束循环，直接跳过了4这个元素。
         */

    }

    public static void main1(String[] args) {
        int num = 5;
        init(num);
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            String string = (String) iterator.next();
            if (string.equals(num - 1 + "")) {
                // fail-fast
                // 出现ConcurrentModificationException异常的原因在于不能对list集合同时进行读写操作。
                System.out.println("执行remove操作");
                list.remove(string);
            } else {
                System.out.println(string);
            }
        }
    }
}  