package lazyeye.enumHelpers.example;

import lazyeye.enumHelpers.finder.EnumFinderKey;
import lazyeye.enumHelpers.finder.StringEnumFinder;
import lazyeye.enumHelpers.finder.StringEnumFinders;

public enum RegexCompassPoint {
	NORTH("(?i:n|north)"),
	EAST("(?i:e|east)"),
	SOUTH("(?i:s|south)"),
	WEST("(?i:w|west)"), 
	UNKNOWN(null);

	@EnumFinderKey("regex")
	public final String regex;

	RegexCompassPoint(String r) {
		regex = r;
	}

	private static StringEnumFinder<RegexCompassPoint> helper = 
		StringEnumFinders.fromAnnotatedKeyMatchRegex(RegexCompassPoint.class,"regex");

	public static RegexCompassPoint find(String s) {
		return helper.find(s, UNKNOWN);
	}
}
