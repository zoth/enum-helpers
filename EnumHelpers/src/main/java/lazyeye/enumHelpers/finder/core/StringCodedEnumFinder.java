package lazyeye.enumHelpers.finder.core;

import lazyeye.enumHelpers.finder.StringEnumFinder;
import lazyeye.enumHelpers.finder.core.strategy.MatcherStrategy;


public class StringCodedEnumFinder<E extends Enum<E> & CodedEnum<String>> extends CodedEnumFinder<E, String, String> implements StringEnumFinder<E> {
	public StringCodedEnumFinder(Class<E> clazz,
			MatcherStrategy<String, String> matcher) {
		super(clazz, matcher);
	}

}
