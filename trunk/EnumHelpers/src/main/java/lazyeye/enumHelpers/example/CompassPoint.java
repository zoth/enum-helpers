package lazyeye.enumHelpers.example;

import lazyeye.enumHelpers.finder.StringCodedEnumFinderFactory;
import lazyeye.enumHelpers.finder.StringCodedEnum;
import lazyeye.enumHelpers.finder.StringCodedEnumFinder;

public enum CompassPoint implements StringCodedEnum {
	NORTH("(?i:n|north)", "North"),
	NORTH_NORTHEAST("(?i:nne|north-northeast)", "North-northeast"),
	NORTHEAST("(?i:ne|northeast)", "Northeast"),
	EAST_NORTHEAST("(?i:ene|east-northeast)", "East-northeast"),
	EAST("(?i:e|east)", "East"),
	EAST_SOUTHEAST("(?i:ese|east-southeast)", "East-southeast"),
	SOUTHEAST("(?i:se|southeast)", "Southeast"),
	SOUTH_SOUTHEAST("(?i:sse|south-southeast)", "South-southeast"),
	SOUTH("(?i:s|south)", "South"),
	SOUTH_SOUTHWEST("(?i:ssw|south-southwest)", "South-southwest"),
	SOUTHWEST("(?i:sw|southwest)", "Southwest"),
	WEST_SOUTHWEST("(?i:wsw|west-southwest)", "West-southwest"),
	WEST("(?i:w|west)", "West"), 
	WEST_NORTHWEST("(?i:wnw|west)", "West-northwest"),
	NORTHWEST("(?i:nw|northwest)", "Northwest"),
	NORTH_NORTHWEST("(?i:nnw|north-northwest)", "North-northwest"),
	
	UNKNOWN(null, "unknown");

	private final String regex;
	public final String name;

	private static StringCodedEnumFinder<CompassPoint> helper = StringCodedEnumFinderFactory.regexFinder(CompassPoint.class);

	CompassPoint(String r, String n) {
		regex = r;
		name = n;
	}

	public String finderCode() {
		return regex;
	}

	public static CompassPoint find(String s, CompassPoint defaultValue) {
		return helper.find(s, defaultValue);
	}

	public static CompassPoint find(String s) {
		return find(s, UNKNOWN);
	}
}
