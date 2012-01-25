package lazyeye.enumHelper.finder.core;

import lazyeye.enumHelper.finder.StringEnumFinder;
import lazyeye.enumHelper.finder.core.strategy.MatcherStrategy;


public class StringCodedEnumFinder<E extends Enum<E> & CodedEnum<String>> extends CodedEnumFinder<E, String, String> implements StringEnumFinder<E> {
	public StringCodedEnumFinder(Class<E> clazz,
			MatcherStrategy<String, String> matcher) {
		super(clazz, matcher);
	}

}
