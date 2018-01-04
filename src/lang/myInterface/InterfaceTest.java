package lang.myInterface;

import java.util.Date;

/**
 * 接口测试类
 *
 * @author kevin
 * @date 2018/01/04
 * @Modified By:
 **/
public class InterfaceTest {

    public static void main(String[] args){
        Date date = new Date();
        Object clone = date.clone();
        System.out.println(clone.toString());

        int[] luckyNumbers = {2, 3, 4, 5, 7, 11, 13};
        int[] cloned = (int[]) luckyNumbers.clone();
        System.out.println(cloned[3]);
    }
}
