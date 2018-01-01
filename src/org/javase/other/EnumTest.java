package org.javase.other;

/**
 * 枚举测试类
 * 
 * @author kevin
 *
 */
public class EnumTest {

	public static void main(String[] args) {
		WeekDay day = WeekDay.Sun;
		System.out.println(day.nextDay());

		System.out.println(WeekDay2.values().length);// 返回枚举类的一个数组的大小
		
		System.out.println(TranfficLamp.RED);
	}

	/**
	 * 普通枚举类
	 * 
	 * @author kevin
	 *
	 */
	public enum WeekDay2 {
		SUN, MON, TUE, WED, THR, FRI, SAT;
	}

	/**
	 * 复杂枚举类
	 * 
	 * @author kevin
	 *
	 */
	public enum TranfficLamp {
		/**
		 * TranfficLamp枚举类的匿名内部类实现了父类的nextLamp()方法
		 */
		RED(30) {
			public TranfficLamp nextLamp() {
				return GREEN;
			}
		},
		YELLOW(5) {
			public TranfficLamp nextLamp() {
				return RED;
			}
		},
		GREEN(25) {
			public TranfficLamp nextLamp() {
				return YELLOW;
			}
		};
		@SuppressWarnings("unused")
		private int time;

		private TranfficLamp(int time) {
			this.time = time;
		}

		public abstract TranfficLamp nextLamp();
	}
}
