package lang.myInterface;

//代码2：外部类对内部类可见
//(内部类可以访问外部类的所有成员变量和方法) 
public class Outer2 {
    //外部类私有数据域 
    private int data = 0;

    //内部类 
    class Inner {
        void print() {
            //内部类访问外部私有数据域 
            System.out.println(data);
        }
    }

    public Inner getInner(){
        return new Inner();
    }
    
    public static void main(String[] args){
        Outer2 outer2 = new Outer2();
        outer2.getInner().print();
    }
} 