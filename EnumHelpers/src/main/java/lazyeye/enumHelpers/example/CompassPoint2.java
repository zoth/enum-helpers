package lazyeye.enumHelpers.example;

import lazyeye.enumHelpers.finder.EnumCoding;
import lazyeye.enumHelpers.finder.core.AnnotatedCodedEnumFinder;
import lazyeye.enumHelpers.finder.core.EnumFinder;
import lazyeye.enumHelpers.finder.core.strategy.EqualsMatcher;

public enum CompassPoint2 {
	NORTH("n", "North"), EAST("e", "East"), SOUTH("s", "South"), WEST("w",
			"West"), UNKNOWN(null, null);

	private String id;
	private String name;

	CompassPoint2(String id_, String name_) {
		id = id_;
		name = name_;
	}

	@EnumCoding("id")
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	private static EnumFinder<CompassPoint2, String> finder = AnnotatedCodedEnumFinder
			.simpleAnnotatedCodedEnumFinder(CompassPoint2.class, String.class,
					"id", new EqualsMatcher<String,String>());
	
	public static CompassPoint2 find(String input){
		return finder.find(input);
	}
}
