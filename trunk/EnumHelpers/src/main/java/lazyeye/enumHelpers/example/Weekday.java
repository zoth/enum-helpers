package lazyeye.enumHelpers.example;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import lazyeye.enumHelpers.finder.core.IndexFinder;
import lazyeye.enumHelpers.finder.core.OrdinalEnumFinder;

public enum Weekday {
	UNKNOWN,SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY;
	
	private static OrdinalEnumFinder<Weekday,Date> helper = 
		new OrdinalEnumFinder<Weekday,Date>(Weekday.class, new IndexFinder<Date>() {
			public int findIndex(Date input) {
				if(input != null){
					GregorianCalendar calendar = new GregorianCalendar();
					calendar.setTime(input);
					return calendar.get(Calendar.DAY_OF_WEEK);
				}
				return 0;
			}
		});
	
	public static Weekday find(Date d, Weekday defaultValue){
		return helper.find(d, defaultValue);
	}
	
	public static Weekday find(Date d){
		return find(d, UNKNOWN);
	}
}
