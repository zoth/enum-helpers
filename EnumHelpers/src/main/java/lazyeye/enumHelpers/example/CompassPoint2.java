package lazyeye.enumHelpers.example;

import lazyeye.enumHelpers.finder.EnumFinderKey;
import lazyeye.enumHelpers.finder.StringEnumFinder;
import lazyeye.enumHelpers.finder.StringEnumFinders;

public enum CompassPoint2 {
	NORTH("n", "North"), EAST("e", "East"), SOUTH("s", "South"), WEST("w",
			"West"), UNKNOWN(null, null);

	@EnumFinderKey("id")
	public final String id;
	
	public final String name;

	CompassPoint2(String id_, String name_) {
		id = id_;
		name = name_;
	}

	
	private static StringEnumFinder<CompassPoint2> finder = StringEnumFinders.fromAnnotatedKeyMatchEquals(CompassPoint2.class, "id");
	
	public static CompassPoint2 find(String input){
		return finder.find(input);
	}
	
}
