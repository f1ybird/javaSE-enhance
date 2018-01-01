package org.javase.lang.reflect;

import java.lang.reflect.Field;

/**
 * 反射测试类
 * 
 * @author kevin
 *
 */
public class ReflectTest01 {

	public static void main(String[] args) {
		Reflect01 obj = new Reflect01();
		System.out.println(obj);
		
		// 需求：如果一个类中的string成员变量含有字母b，则把字母b换成字母x
		// 方案：使用字段的反射
		try {
			changeFieldValue(obj);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 需求：使用反射获取方法进行调用
		try {
			//String str = "hello";
			//System.out.println(str.charAt(1));
			//System.out.println(str.replace('l', 'x'));
			
			// 1.charAt(int index)方法，返回字符串对应索引处的字符
			//Method methodCharAt = String.class.getMethod("charAt", int.class);
			//System.out.println(methodCharAt.invoke(str, new Object[] {1}));// e
			
			// 2.replace(char oldChar, char new newChar)方法，返回字符串对应索引处的字符
			//Method methodReplace = String.class.getMethod("replace",  new Class[] {char.class,char.class});
			//System.out.println(methodReplace.invoke(str, new Object[] {'l','x'}));// hexxo
			
			// 3.此处传入的第一个参数为null，说明方法的调用者不用进行创建即可使用，也就是说这是一个静态方法
			//System.out.println(methodReplace.invoke(null, new Object[] {'l','x'}));// hexxo
			
			// 接收参数为数组时的方法反射，以main方法为例
			// 获取main方法的参数列表，需要在run configurations中传入参数org.javase.other.ListTest，否则会报数组越界异常
			//String clazz = args[0];
			//Method methodMain = Class.forName(clazz).getMethod("main", String[].class);
			//System.out.println(methodMain.invoke(null, new Object[] {new String[]{"aaa","bbb","ccc"}}));
			//System.out.println(methodMain.invoke(null, (Object)new String[]{"aaa","bbb","ccc"}));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 替换Reflect01类中成员变量为String中字母b为字母x
	 */
	private static void changeFieldValue(Object obj) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = obj.getClass().getFields();
		for (Field field : fields) {
			// 此处使用==而不使用equals的原因是字节码对象在内存中只有一份
			if(field.getType() == String.class) {
				String oldValue = (String) field.get(obj);
				String newValue = oldValue.replace('b', 'x');
				field.set(obj, newValue);
			}
		}
	}
}

class Test{
	public static void main(String[] args) {
		for (String arg : args) {
			System.out.println(arg);
		}
	}
}