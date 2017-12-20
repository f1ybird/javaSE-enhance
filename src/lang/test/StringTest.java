package lang.test;

import java.lang.reflect.Field;

/**
 * String测试类
 * @author kevin
 * @date 2017/12/20
 * @Modified By:
 **/
public class StringTest {
    
    public static void main(String[] args){
        // String是不可变类，内部使用final修饰，且无setter方法
        String s = "abc";
        System.out.println(s);
        s = "def";
        System.out.println(s);
        s = "1" + "2" + "3";
        System.out.println(s);
        // 常量池
        String s1 = "constantPool";
        String s2 = "constantPool";
        // true
        System.out.println(s1 == s2);

        String s3 = new String("newObject");
        String s4 = new String("newObject");
        // false
        System.out.println(s3 == s4);

        // 使用intern()方法返回字符串的引用判断为同一个字符串
        // true
        System.out.println(s2 == s1.intern());
        // false
        System.out.println(s3 == s1.intern());
        // false
        System.out.println(s3 == s4.intern());

        // 使用反射改变String的值
        try {
            String valueField = "valueFiled";
            System.out.println(valueField);
            Field field = String.class.getDeclaredField("value");
            // 设置value字段可见
            field.setAccessible(true);
            char[] value = (char[]) field.get(valueField);
            // 设置原字符串的第五个字符为'_'
            value[5] = '_';
            // value_Field
            System.out.println(valueField);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // StringBuffer&StringBuilder
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        /*
           StringBuffer为线程安全，StringBuilder线程不安全
         */

    }
}
