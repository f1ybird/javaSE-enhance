package org.javase.other;

/**
 
	Java 语言里的 equals方法其实是交给开发者去覆写的，让开发者自己去定义满足什么条件的两个Object是equal的。
	所以我们不能单纯的说equals到底比较的是什么。你想知道一个类的equals方法是什么意思就是要去看定义。
	Java中默认的 equals方法实现如下：

	public boolean equals(Object obj) {
	    return (this == obj);
	}


 * @author kevin
 *
 */
public class ObjectTest {
	
	public static void main(String[] args) {
		// == 判断基本值类型或者引用类型是否为同一个，equals判断引用类型的内容是否一致
		// ==为true的equals一定为true
		String str1 = "abc";
		String str2 = "abc";
		if(str1.equals(str2)) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}

}
