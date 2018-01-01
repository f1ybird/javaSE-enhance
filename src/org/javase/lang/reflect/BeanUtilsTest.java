package org.javase.lang.reflect;

import java.beans.Introspector;
import java.util.Map;

import org.apache.commons.beanutils.BeanIntrospector;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * BeanUtils工具包使用
 * 
 * @author kevin
 *
 */
public class BeanUtilsTest {

	public static void main1(String[] args) throws Exception {
		Reflect01 pt = new Reflect01(3);
		System.out.println(BeanUtils.getProperty(pt, "x"));// get
		BeanUtils.setProperty(pt, "x", "44");// set(自动提供类型转换)
		System.out.println(BeanUtils.getProperty(pt, "x"));// get
	}
	
	public static void main2(String[] args) throws Exception {
		Reflect01 pt = new Reflect01(3);
		BeanUtils.setProperty(pt,"birthday.time","9999");// set
		System.out.println(BeanUtils.getProperty(pt, "birthday.time"));// get
	}
	
	public static void main3(String[] args) throws Exception {
		Reflect01 pt1 = new Reflect01(6);
		Reflect01 pt2 = new Reflect01(3);
		BeanUtils.copyProperties(pt1, pt2);// 拷贝pt2的属性到pt1中
		System.out.println(pt1.getX());
		System.out.println(pt2.getX());
	}

	public static void main4(String[] args) throws Exception {
		Reflect01 pt1 = new Reflect01(6);
		System.out.println(PropertyUtils.getProperty(pt1, "x"));
		PropertyUtils.setProperty(pt1, "x", 8);// 必须和bean中的值类型一致，不会自动转换类型
		System.out.println(PropertyUtils.getProperty(pt1, "x"));
		System.out.println(PropertyUtils.getPropertyType(pt1, "x"));
	}
	
	public static void main(String[] args) throws Exception {
		Reflect01 pt1 = new Reflect01(3);
		Reflect01 pt2 = (Reflect01) BeanUtils.cloneBean(pt1);
		System.out.println(pt2.getX());
	}
	
}
