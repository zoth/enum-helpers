package lazyeye.enumHelpers.example;

import lazyeye.enumHelpers.finder.StringCodeProvider;
import lazyeye.enumHelpers.finder.StringEnumFinder;
import lazyeye.enumHelpers.finder.StringFinderFactory;

public enum RegexCompassPoint {
	NORTH("(?i:n|north)", "North"),
	EAST("(?i:e|east)", "East"),
	SOUTH("(?i:s|south)", "South"),
	WEST("(?i:w|west)", "West"), 
	UNKNOWN(null, "unknown");

	private final String regex;
	public final String name;


	RegexCompassPoint(String r, String n) {
		regex = r;
		name = n;
	}

	private static StringEnumFinder<RegexCompassPoint> helper = 
		StringFinderFactory.codeProviderRegex(RegexCompassPoint.class,
			new StringCodeProvider<RegexCompassPoint>() {
				public String code(RegexCompassPoint enum1) {
					return enum1.regex;
				}
			});

	public static RegexCompassPoint find(String s) {
		return helper.find(s, UNKNOWN);
	}
}
