package lang.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 遍历集合的三种方式性能比较【通过遍历的时间比较】
 *
 * @author kevin
 * @date 2018/01/02
 * @Modified By:
 **/
public class CircleListTest {

    private static List<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        CircleListTest test = new CircleListTest();
        test.initList(list);
        // foreach遍历耗时：57
        // test.foreach(list);
        // for循环遍历耗时：53
        // test.forList(list);
        // iterable遍历耗时：67
        // test.iteratorList(list);

        // 综上比较for>foreach>iterable
    }

    /**
     * 初始化1000万个集合元素
     *
     * @param list
     */
    public void initList(List<String> list) {
        int num = 10000000;
        for (int i = 0; i < num; i++) {
            list.add("list" + i);
        }
    }

    /**
     * for循环遍历耗时
     *
     * @param list
     */
    public void forList(List<String> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            String value = list.get(i);
        }
        long end = System.currentTimeMillis();
        long count = end - start;
        System.out.println("for循环遍历耗时：" + count);
    }

    /**
     * foreach遍历耗时
     *
     * @param list
     */
    public void foreach(List<String> list) {
        long start = System.currentTimeMillis();
        for (String data : list) {
            String value = data;
        }
        long end = System.currentTimeMillis();
        long count = end - start;
        System.out.println("foreach遍历耗时：" + count);
    }

    /**
     * 迭代器遍历
     *
     * @param list
     */
    public void iteratorList(List<String> list) {
        long start = System.currentTimeMillis();
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            String value = it.next();
        }
        long end = System.currentTimeMillis();
        long count = end - start;
        System.out.println("iterable遍历耗时：" + count);
    }
}
