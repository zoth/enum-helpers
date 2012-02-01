package lazyeye.enumHelpers.example;

import lazyeye.enumHelpers.finder.TagCode;
import lazyeye.enumHelpers.finder.StringEnumFinder;
import lazyeye.enumHelpers.finder.StringEnumFinders;

public enum CompassPoint2 {
	NORTH("n", "North"), EAST("e", "East"), SOUTH("s", "South"), WEST("w",
			"West"), UNKNOWN(null, null);

	private String id;
	private String name;

	CompassPoint2(String id_, String name_) {
		id = id_;
		name = name_;
	}

	@TagCode("id")
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	private static StringEnumFinder<CompassPoint2> finder = StringEnumFinders.tagCodeEquals(CompassPoint2.class, "id");
	
	public static CompassPoint2 find(String input){
		return finder.find(input);
	}
	
}
