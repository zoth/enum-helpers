package lazyeye.enumHelpers.example;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import lazyeye.enumHelpers.finder.core.EnumFinder;
import lazyeye.enumHelpers.finder.core.EnumFinderComposite;
import lazyeye.enumHelpers.finder.core.KeyMatcher;
import lazyeye.enumHelpers.finder.IntegerKeyProvider;

public enum Weekday {
	
	UNKNOWN(null),
	SUNDAY(1),
	MONDAY(2),
	TUESDAY(3),
	WEDNESDAY(4),
	THURSDAY(5),
	FRIDAY(6),
	SATURDAY(7);
	
	public final Integer id;
	
	Weekday(Integer id_){
		id = id_;
	}
	
	private static EnumFinder<Weekday, Date> finder = new EnumFinderComposite<Weekday, Date, Integer>(
			Weekday.class, new KeyMatcher<Date, Integer>() {

				public boolean matches(Date input, Integer key) {
					if (input != null && key != null) {
						GregorianCalendar calendar = new GregorianCalendar();
						calendar.setTime(input);
						return calendar.get(Calendar.DAY_OF_WEEK) == key.intValue();
					}
					return false;
				}
			}, new IntegerKeyProvider<Weekday>() {

				public Integer key(Weekday enum1) {
					return enum1.id;
				}
			});
	
	public static Weekday find(Date d){
		return finder.find(d, UNKNOWN);
	}
}
