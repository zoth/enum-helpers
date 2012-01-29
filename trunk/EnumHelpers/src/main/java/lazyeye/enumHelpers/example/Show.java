package lazyeye.enumHelpers.example;

import java.util.Date;
import java.util.GregorianCalendar;

public class Show {

	public static void main(String[] args) {
		System.out.println(Weekday.find(new Date()));
		System.out.println(Weekday.find(null));
		System.out.println(Weekday.find(new GregorianCalendar(1953, 8, 28).getTime()));
		System.out.println(Weekday.find(new GregorianCalendar(1958, 2, 17).getTime()));
		System.out.println(RegexCompassPoint.find("N").name);
		System.out.println(RegexCompassPoint.find("nne").name);
		System.out.println(RegexCompassPoint.find("ne").name);
		System.out.println(RegexCompassPoint.find("ene").name);
		System.out.println(RegexCompassPoint.find("east").name);
		System.out.println(RegexCompassPoint.find("ese").name);
		System.out.println(RegexCompassPoint.find("se").name);
		System.out.println(RegexCompassPoint.find("sse").name);
		System.out.println(RegexCompassPoint.find("s").name);
		System.out.println(RegexCompassPoint.find("ssw").name);
		System.out.println(RegexCompassPoint.find("sw").name);
		System.out.println(RegexCompassPoint.find("wsw").name);
		System.out.println(RegexCompassPoint.find("w").name);
		System.out.println(RegexCompassPoint.find("wnw").name);
		System.out.println(RegexCompassPoint.find("nw").name);
		System.out.println(RegexCompassPoint.find("nnw").name);
		System.out.println(RegexCompassPoint.find("zoth").name);
		System.out.println(CompassPoint2.find("e"));
	}

}
