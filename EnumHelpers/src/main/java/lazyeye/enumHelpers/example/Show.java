package lazyeye.enumHelpers.example;

import java.util.Date;
import java.util.GregorianCalendar;

public class Show {

	public static void main(String[] args) {
		System.out.println(Weekday.find(new Date()));
		System.out.println(Weekday.find(null));
		System.out.println(Weekday.find(new GregorianCalendar(1953, 8, 28).getTime()));
		System.out.println(Weekday.find(new GregorianCalendar(1958, 2, 17).getTime()));
		System.out.println(RegexCompassPoint.find("N"));
		System.out.println(RegexCompassPoint.find("nne"));
		System.out.println(RegexCompassPoint.find("ne"));
		System.out.println(RegexCompassPoint.find("ene"));
		System.out.println(RegexCompassPoint.find("east"));
		System.out.println(RegexCompassPoint.find("ese"));
		System.out.println(RegexCompassPoint.find("se"));
		System.out.println(RegexCompassPoint.find("sse"));
		System.out.println(RegexCompassPoint.find("s"));
		System.out.println(RegexCompassPoint.find("ssw"));
		System.out.println(RegexCompassPoint.find("sw"));
		System.out.println(RegexCompassPoint.find("wsw"));
		System.out.println(RegexCompassPoint.find("w"));
		System.out.println(RegexCompassPoint.find("wnw"));
		System.out.println(RegexCompassPoint.find("nw"));
		System.out.println(RegexCompassPoint.find("nnw"));
		System.out.println(RegexCompassPoint.find("zoth"));
		System.out.println(CompassPoint.find("e"));
	}

}
