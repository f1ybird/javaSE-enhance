package lang.test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * BigInteger测试类
 *
 * @author kevin
 * @date 2017/12/21
 * @Modified By:
 **/
public class BigIntegerTest {

    /**
     * 加法
     */
    public static double add(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.add(b2).doubleValue();
    }

    /**
     * 减法
     */
    public static double sub(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 乘法
     */
    public static double mul(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 除法
     */
    public static double div(double d1, double d2, int len) {
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.divide(b2, len, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 取模运算
     */
    public static int mod(int b1, int b2){
        return BigInteger.valueOf(b1).mod(BigInteger.valueOf(b2)).intValue();
    }

    /**
     * 四舍五入
     */
    public static double round(double d,int len) {
        BigDecimal b1 = new BigDecimal(d);
        BigDecimal b2 = new BigDecimal(1);
        // ROUND_HALF_UP是BigDecimal的一个常量，表示进行四舍五入的操作
        return b1.divide(b2, len, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void main(String[] args) {

        System.out.println("加法运算：" + BigIntegerTest.round(BigIntegerTest.add(10.345,3.333), 1));
        System.out.println("乘法运算：" + BigIntegerTest.round(BigIntegerTest.mul(10.345,3.333), 3));
        System.out.println("除法运算：" + BigIntegerTest.div(10.345, 3.333, 3));
        System.out.println("减法运算：" + BigIntegerTest.round(BigIntegerTest.sub(10.345,3.333), 3));
        System.out.println("取模运算：" + BigIntegerTest.mod(23232342,2323));
    }
}
