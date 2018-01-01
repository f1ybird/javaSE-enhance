package org.javase.lang.system;

/**
 * System测试类
 * 
 * @author kevin
 *
 */
public class SystemTest {

	public static void main(String[] args) {
		// 数组拷贝
		String[] arr1 = {"1","2","3"};
		String[] arr2 = new String[10];
		System.out.print("before copy : ");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
		System.arraycopy(arr1, 0, arr2, 2, 3);
		System.out.print("after copy :");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
	}
}
