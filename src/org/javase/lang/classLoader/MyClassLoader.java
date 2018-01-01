package org.javase.lang.classLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyClassLoader extends ClassLoader {

	private String classDir;

	public MyClassLoader() {
		
	}
	
	public MyClassLoader(String classDir) {
		this.classDir = classDir;
	}
	
	public static void main(String[] args) throws Exception{
		String srcPath = args[0];
		String destDir = args[1];
		String destName = srcPath.substring(srcPath.lastIndexOf(File.separator) + 1);
		String destPath = destDir + File.separator + destName;
		FileInputStream fis = new FileInputStream(srcPath);
		FileOutputStream fos = new FileOutputStream(destPath);
		cryper(fis, fos);
		fos.close();
		fis.close();
	}
	
	/**
	 * 通过自定义类加载器加载类
	 */
	@SuppressWarnings("deprecation")
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String className = classDir + File.separator + name.substring(name.lastIndexOf(".")+1) + ".class";
		FileInputStream fis;
		try {
			fis = new FileInputStream(className);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			cryper(fis, bos);
			fis.close();
			byte[] byteArray = bos.toByteArray();
			return this.defineClass(byteArray, 0,byteArray.length);// 返回自定义的类加载器
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.findClass(name);// 返回父类的类加载器
	}

	/**
	 * 异或加密
	 * @param fis 输入流
	 * @param fos 输出流
	 */
	private static void cryper(InputStream fis, OutputStream fos) {
		try {
				int b = -1;
				while((b=fis.read())!=-1) {
					fos.write(b ^ 0xff);// 异或加密
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
