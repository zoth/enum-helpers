package lazyeye.enumHelpers.example;

import lazyeye.enumHelpers.finder.StringEnumFinder;
import lazyeye.enumHelpers.finder.StringFinderFactory;
import lazyeye.enumHelpers.finder.core.CodeProvider;

public enum RegexCompassPoint {
	NORTH("(?i:n|north)", "North"),
	EAST("(?i:e|east)", "East"),
	SOUTH("(?i:s|south)", "South"),
	WEST("(?i:w|west)", "West"), 
	UNKNOWN(null, "unknown");

	private final String regex;
	public final String name;

	private static StringEnumFinder<RegexCompassPoint> helper = StringFinderFactory
			.codeProviderRegex(RegexCompassPoint.class,
					new CodeProvider<RegexCompassPoint, String>() {
						public String code(RegexCompassPoint enum1) {
							return enum1.regex;
						}
					});

	RegexCompassPoint(String r, String n) {
		regex = r;
		name = n;
	}

	public static RegexCompassPoint find(String s, RegexCompassPoint defaultValue) {
		return helper.find(s, defaultValue);
	}

	public static RegexCompassPoint find(String s) {
		return find(s, UNKNOWN);
	}
}
