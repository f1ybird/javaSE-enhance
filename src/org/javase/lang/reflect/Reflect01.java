package org.javase.lang.reflect;

import java.util.Date;

public class Reflect01 {
	public Date birthday = new Date();
	public String str1 = "ball";
	public String str2 = "itcast";
	
	public int x;
	
	public Reflect01(int x) {
		this.x = x;
	}

	public Reflect01() {
		super();
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Reflect01 [str1=" + str1 + ", str2=" + str2 + "]";
	}

}
