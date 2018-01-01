package lang.test;

/**
 * 类的初始化时机
 * @author kevin
 * @date 2018/01/01
 * @Modified By:
 **/
public class InitSort {
    public static void main(String[] args){
        //现有基类A，A的构造函数中输出“A init”，A中有一静态块内输出“A Instance”，
        //A的一个派生类B的构造函数中输出“B init”, B类中的静态块中输出“B instance”。
        //问：A a = new B(); 输出结果及正确的顺序？
        A a = new B();// A static->B static->A Constructor->B Constructor->

        /*对于类的初始化虚拟机规范中明确指出有且只有以下五中情况会立即执行对类的初始化：

        1、遇到 new、getstatic、putstatic或invokestatic 着四条指令时，这四条指令分别代表：
        使用new关键字实例化对象、读取或设置静态字段、调用一个类的静态方法。

        2、使用jav.lang.reflect包中的方法对类进行反射调用。

        3、当初始化一个类的时候，如果该类的父类没有初始化，则需要先初始化起父类

        4、当虚拟机启动时，用户需要指定一个要执行的主类（包括main()方法的那个类），虚拟机会先初始化这个主类

        5、使用jdk1.7的动态语言支持时，如果一个java.lang.MethodHandle实例最后的解析结果是：REF_getStatic、
        REF_putStatic、REF_invokeStatic的方法句柄，且这个方法句柄所对应的类没有初始化则需要先触发其初始化*/
    }
}

class A{
    public A(){
        System.out.print("A Constructor->");
    }

    static{
        System.out.print("A static->");
    }
}

class B extends A{
    public B(){
        System.out.print("B Constructor->");
    }

    static{
        System.out.print("B static->");
    }
}


