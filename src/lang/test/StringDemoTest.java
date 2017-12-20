package lang.test;

/**
 * String类方法测试
 * @author kevin
 * @date 2017/12/20
 * @Modified By:
 **/
public class StringDemoTest {

    public static void main(String[] args) {
        String str = new String("astrs");
//        String ss = str.replaceFirst("s","x");
//        String ss = str.replaceAll("s","x");
//        final String ss = str.replace("s", "x");

        // 正则匹配
//        System.out.println(str.matches("[a-z]+"));

        // 不包含最后一个字符
//        System.out.println(str.substring(0,str.length()));
        // 偏移1位判断
//        System.out.println(str.startsWith("t",1));

        // 去掉首尾空格
//        System.out.println(str.trim());

        // 从1开始计数
//        System.out.println(str.lastIndexOf("t"));

//        StringBuffer strs2 = new StringBuffer("strs");
//        System.out.println(str.contentEquals(strs2));

//        System.out.println(str.contains("s"));
//        System.out.println(str.concat("h"));

//        System.out.println(str.indexOf("r"));
//        System.out.println(str.codePointAt(0));

        // 比较字符串中的字串是否和另一个字符串匹配，可以忽略大小写
//        String Str1 = new String("www.runoob.com");
//        String Str2 = new String("runoob");
//        String Str3 = new String("RUNOOB");
//        System.out.print("返回值 :" );
//        System.out.println(Str1.regionMatches(true,4, Str3, 0, 6));
        // Pattern
//        System.out.println(ss);
//        StringDemo s = new StringDemo("hello world");
//        char[] val = s.toCharArray();
//        System.out.println(s.myCharAt(0));
    }
}
