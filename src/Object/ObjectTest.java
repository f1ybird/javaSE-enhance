package Object;

/**
 * Object测试类
 *
 * @author kevin
 * @create 2017-12-19 0:02
 **/
public class ObjectTest implements Cloneable{

    public static void main(String[] args) {
        Object o1 = new Object();
        // The method clone() from the type Object is not visible
        // Object clone = o1.clone();
        ObjectTest x = new ObjectTest();
        try {
            // x.clone() != x
            if(x.clone() != x){
                System.out.println(true);
            }else{
                System.out.println(false);
            }

            // x.getClass() == x.clone().getClass()
            if(x.getClass() == x.clone().getClass()){
                System.out.println(true);
            }else{
                System.out.println(false);
            }

            // x.clone().equals(x)
            if( x.clone().equals(x)){
                System.out.println(true);
            }else{
                System.out.println(false);
            }

            // 测试equals()方法  两个对象相等 <=>  equals()相等  => hashCode()相等 dfss
            User u1 = new User("1","张三",18);
            User u2 = new User("2","李三",18);
            User u3 = new User("1","王五",39);
            System.out.println(u1.equals(u3));
            System.out.println(u1.equals(u2));
            System.out.println(u2.hashCode());// 26081961的16进制=18DFAA9
            System.out.println(u2.toString());// Object.User@18dfaa9


            //  JVM垃圾回收机制finalize()

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
