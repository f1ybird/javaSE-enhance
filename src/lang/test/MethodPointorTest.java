package lang.test;

import java.lang.reflect.Method;

/**
 * 使用反射调用类的静态方法
 * @author kevin
 * @date 2017/12/21
 * @Modified By:
 **/
public class MethodPointorTest {
    
    public static void main(String[] args){
        try {
            Method square = MethodPointorTest.class.getMethod("square", double.class);
            Method sqrt = Math.class.getMethod("sqrt", double.class);
            printTable(1,10,10,square);
            printTable(1,10,10,sqrt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 平方
     */
    public static double square(double x){
        return Math.sqrt(x);
    }

    public static void printTable(int from, int to, int n, Method method){
       System.out.println("方法名：" + method);
        int dx = (to - from) / (n - 1);
        try{
            for (double x = from; x <= to; x+=dx) {
                double y = (Double)method.invoke(null, x);// 调用静态方法
                System.out.printf("%10.4f | %10.4f%n",x,y);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
