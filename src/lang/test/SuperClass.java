package lang.test;

/**
 * 类的初始化时机
 * 对于类的初始化虚拟机规范中明确指出有且只有一下五中情况会立即执行对类的初始化：
 1、遇到 new、getstatic、putstatic或invokestatic 着四条指令时，这四条指令分别代表：
 使用new关键字实例化对象、读取或设置静态字段、调用一个类的静态方法。

 2、使用jav.lang.reflect包中的方法对类进行反射调用。

 3、当初始化一个类的时候，如果该类的父类没有初始化，则需要先初始化其父类

 4、当虚拟机启动时，用户需要指定一个要执行的主类（包括main()方法的那个类），虚拟机会先初始化这个主类

 5、使用jdk1.7的动态语言支持时，如果一个java.lang.MethodHandle实例最后的解析结果是：REF_getStatic、
 REF_putStatic、REF_invokeStatic的方法句柄，且这个方法句柄所对应的类没有初始化则需要先触发其初始化
 */
public class SuperClass{
    static{
        System.out.println("SuperClass init");
    }
    
    public static int VALUE = 123;
}
class SubClass extends SuperClass{
    static{
        System.out.println("SubClass init");
    }
    
    public static final String HELLO_WORD = "hello word";
}

class NotInitialization{
    public static void main(String[] args){
        
        /**
        * 这里只会输出“SuperClass init”, 而不会输出“SubClass init”. 
        * 对于静态字段，只有直接定义这个字段的类才会被初始化
        * 因此通过子类引用父类中定义的静态字段，只会触发父类的初始化不会触发子类的初始化   
        */
        System.out.println(SubClass.VALUE);//SuperClass init,123
        
        /**
        * 这里也不会输出“SubClass init”, 
        * 这里因为虽然在Java源代码中引用了SubClass类中的常量HELLOWORD, 
        * 但是在编译阶段通过常量传播优化，
        * 已经将此常量的值“hellow word”放到了NotInitialization类的常量池中,
        * 以后NotInitialization对常量 SubClass.HELLWORD 的引用实际都被转化
        * 为NotInitialization类对自身常量池的引用了
        */
        System.out.println(SubClass.HELLO_WORD);// hello word
    
    }
}