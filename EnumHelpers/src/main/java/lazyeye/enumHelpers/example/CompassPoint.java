package lazyeye.enumHelpers.example;

import lazyeye.enumHelpers.finder.EnumFinderKey;
import lazyeye.enumHelpers.finder.StringEnumFinder;
import lazyeye.enumHelpers.finder.StringEnumFinders;

public enum CompassPoint {
	NORTH("n"),
	EAST("e"),
	SOUTH("s"),
	WEST("w"),
	UNKNOWN(null);

	@EnumFinderKey("id")
	public final String id;

	CompassPoint(String id_) {
		id = id_;
	}

	
	private static StringEnumFinder<CompassPoint> finder = StringEnumFinders.fromAnnotatedKeyMatchEquals(CompassPoint.class, "id");
	
	public static CompassPoint find(String input){
		return finder.find(input);
	}
	
}
