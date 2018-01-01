package lang.test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * java中创建对象的5种方式
 * <p>
 * 使用new关键字调用了构造函数
 * 使用Class类的newInstance方法 调用了构造函数
 * 使用Constructor类的newInstance方法 调用了构造函数
 * 使用clone方法 没有调用构造函数
 * 使用反序列化 没有调用构造函数
 *
 * @author kevin
 * @date 2018/01/01
 * @Modified By:
 **/
public class ClassTest {
    public static void main(String[] args) {
        try {
            // 1 使用new关键字调用了构造函数
            // User user = new User();
            // 2 使用Class类的newInstance方法
            // User user1 = User.class.newInstance();
            // User user2 = (User)Class.forName("lang.test.User").newInstance();
            // 3.使用Constructor类的newInstance方法
            // User user3 = User.class.getConstructor().newInstance();
            // 4.使用clone方法
             User user4 = new User();
             User user5 = (User) user4.clone();
            // Serialization
             ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"));
             out.writeObject(user5);
             out.close();
             //Deserialization
             ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
             User user6 = (User) in.readObject();
             in.close();
             user6.setName("Akash");
             System.out.println(user6.getName() + ", hashcode : " + user6.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
