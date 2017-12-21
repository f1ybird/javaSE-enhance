package lang.test;

import java.util.Arrays;

/**
 * 数组测试类
 * @author kevin
 * @date 2017/12/21
 * @Modified By:
 **/
public class ArrayTest {

    public static void main(String[] args){
        int[] iArr = {1,4,3,7};
        // 打印数组1
        for(int i = 0;i < iArr.length;i++){ System.out.print(i + ",");}
        System.out.println();
        // 打印数组2
        System.out.println(Arrays.toString(iArr));
        // 数组排序
        Arrays.sort(iArr);
        // 排序后输出
        System.out.println(Arrays.toString(iArr));

        // 数组拷贝
        int[] iArr2 = Arrays.copyOf(iArr,2);
        System.out.println(Arrays.toString(iArr2));
    }
}
