package fx.leyu.jdk.util;

import java.util.Calendar;

public class CalendarApiTest {

	public static void main(String[] args) {
		instanceTest();
	}

	public static void instanceTest() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, Calendar.FEBRUARY);
		c.set(Calendar.DAY_OF_MONTH, 32);
		
		System.out.println(c.get(Calendar.MONTH));  
		System.out.println(c.getTime());
	}

}
