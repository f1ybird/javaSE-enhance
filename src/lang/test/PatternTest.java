package lang.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Pattern测试类
 *
 * @author kevin
 * @date 2017/12/20
 * @Modified By:
 **/
public class PatternTest {
    public static void main(String[] args) {
//        Pattern p = Pattern.compile("a*b");
//        Matcher m = p.matcher("aaaaab");
//        boolean b = m.matches();
        Pattern p = Pattern.compile("([a-z]+)(\\d+)");
        Matcher m = p.matcher("aaa2223bb");
        System.out.println(m.find());
        System.out.println(m.groupCount());
        System.out.println(m.group(1));
        System.out.println(m.group(2));
        // 返回第一组匹配的开始索引 0
        System.out.println(m.start(1));
        // 返回第二组匹配的开始索引 3
        System.out.println(m.start(2));
    }
}
