package lazyeye.enumHelpers.example;

import java.util.Date;
import java.util.GregorianCalendar;

public class Show {

	public static void main(String[] args) {
		System.out.println(Weekday.find(new Date()));
		System.out.println(Weekday.find(null));
		System.out.println(Weekday.find(new GregorianCalendar(1953, 8, 28).getTime()));
		System.out.println(Weekday.find(new GregorianCalendar(1958, 2, 17).getTime()));
		System.out.println(CompassPoint.find("N").name);
		System.out.println(CompassPoint.find("nne").name);
		System.out.println(CompassPoint.find("ne").name);
		System.out.println(CompassPoint.find("ene").name);
		System.out.println(CompassPoint.find("east").name);
		System.out.println(CompassPoint.find("ese").name);
		System.out.println(CompassPoint.find("se").name);
		System.out.println(CompassPoint.find("sse").name);
		System.out.println(CompassPoint.find("s").name);
		System.out.println(CompassPoint.find("ssw").name);
		System.out.println(CompassPoint.find("sw").name);
		System.out.println(CompassPoint.find("wsw").name);
		System.out.println(CompassPoint.find("w").name);
		System.out.println(CompassPoint.find("wnw").name);
		System.out.println(CompassPoint.find("nw").name);
		System.out.println(CompassPoint.find("nnw").name);
		System.out.println(CompassPoint.find("zoth").name);
	}

}
