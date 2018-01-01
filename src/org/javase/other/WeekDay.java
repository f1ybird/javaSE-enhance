package org.javase.other;

/**
 * 普通类模拟枚举
 * 
 * @author kevin
 *
 */
public abstract class WeekDay {

	private WeekDay() {
	}

	/**
	 * WeekDay枚举类的匿名内部类实现了父类的nextDay()方法
	 */
	public static final WeekDay Sun = new WeekDay() {
		public WeekDay nextDay() {
			return Mon;
		}
	};
	public static final WeekDay Mon = new WeekDay() {
		public WeekDay nextDay() {
			return Sun;
		}
	};
	
	
	public abstract WeekDay nextDay();

	/*public WeekDay nextDay() {
		if (this == Sun) {
			return Mon;
		}else if(this == Mon) {
			return Tue;
		}else if(this == Tue) {
			return Wed;
		}else if(this == Wed) {
			return Thu;
		}else if(this == Mon) {
			return Mon;
		}else if(this == Fri) {
			return Fri;
		}else {
			return Sun;
		}
	}*/
	
	public String toString() {
		return this == Sun ? "Sun" : "Mon";
	}
}
