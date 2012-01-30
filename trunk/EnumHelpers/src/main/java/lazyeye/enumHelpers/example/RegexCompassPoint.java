package lazyeye.enumHelpers.example;

import lazyeye.enumHelpers.finder.StringEnumFinderFactory;
import lazyeye.enumHelpers.finder.core.CodedEnum;
import lazyeye.enumHelpers.finder.core.EnumFinder;

public enum RegexCompassPoint implements CodedEnum<String> {
	NORTH("(?i:n|north)", "North"),
	EAST("(?i:e|east)", "East"),
	SOUTH("(?i:s|south)", "South"),
	WEST("(?i:w|west)", "West"), 
	UNKNOWN(null, "unknown");

	private final String regex;
	public final String name;

	private static EnumFinder<RegexCompassPoint, String> helper = StringEnumFinderFactory.codedRegexFinder(RegexCompassPoint.class);

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
