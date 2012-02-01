package lazyeye.enumHelpers.example;

import lazyeye.enumHelpers.finder.StringFinderCodeInterface;
import lazyeye.enumHelpers.finder.StringEnumFinder;
import lazyeye.enumHelpers.finder.StringFinderFactory;

public enum RegexCompassPoint implements StringFinderCodeInterface {
	NORTH("(?i:n|north)", "North"),
	EAST("(?i:e|east)", "East"),
	SOUTH("(?i:s|south)", "South"),
	WEST("(?i:w|west)", "West"), 
	UNKNOWN(null, "unknown");

	private final String regex;
	public final String name;

	private static StringEnumFinder<RegexCompassPoint> helper = StringFinderFactory.codedRegex(RegexCompassPoint.class);

	RegexCompassPoint(String r, String n) {
		regex = r;
		name = n;
	}

	public String finderCode() {
		return regex;
	}

	public static RegexCompassPoint find(String s, RegexCompassPoint defaultValue) {
		return helper.find(s, defaultValue);
	}

	public static RegexCompassPoint find(String s) {
		return find(s, UNKNOWN);
	}
}
