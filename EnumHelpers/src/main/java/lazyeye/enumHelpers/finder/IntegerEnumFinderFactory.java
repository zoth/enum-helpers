package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.AnnotatedCodeFinder;
import lazyeye.enumHelpers.finder.core.BaseEnumFinder;
import lazyeye.enumHelpers.finder.core.CodingFinder;
import lazyeye.enumHelpers.finder.core.CodingEnumFinder;
import lazyeye.enumHelpers.finder.matchers.EqualsMatcher;
import lazyeye.enumHelpers.finder.matchers.MatcherStrategy;

public class IntegerEnumFinderFactory {

	public static <E extends Enum<E> & IntegerCodedEnum> IntegerEnumFinder<E> codedEqualsFinder(
			Class<E> clazz) {
		return integerCodedEnumFinder(clazz, new EqualsMatcher<Integer, Integer>());
	}
	
	public static <E extends Enum<E> & IntegerCodedEnum> IntegerEnumFinder<E> integerCodedEnumFinder(
			Class<E> clazz, MatcherStrategy<Integer, Integer> matcher) {
		CodingFinder<E, Integer> codeFinder = new CodingEnumFinder<E,Integer>();
		return new IntegerEnumFinder<E>(new BaseEnumFinder<E,Integer,Integer>(clazz, matcher, codeFinder));
	}

	
	public static <E extends Enum<E>> IntegerEnumFinder<E> integerAnnotatedCodedEnumFinder(
			Class<E> clazz, String tag, MatcherStrategy<Integer, Integer> matcher) {
		CodingFinder<E, Integer> codeFinder = new AnnotatedCodeFinder<E,Integer>(clazz, Integer.class, tag);
		return new IntegerEnumFinder<E>(new BaseEnumFinder<E,Integer,Integer>(clazz, matcher, codeFinder));
	}

	public static <E extends Enum<E>> IntegerEnumFinder<E> annotatedEqualsFinder(
			Class<E> clazz, String tag) {
		return integerAnnotatedCodedEnumFinder(clazz, tag, new EqualsMatcher<Integer, Integer>());
	}
	
	public static <E extends Enum<E>> IntegerEnumFinder<E> codingFinder(
			Class<E> clazz, MatcherStrategy<Integer, Integer> matcher, CodingFinder<E, Integer> codingFinder) {
		return new IntegerEnumFinder<E>(new BaseEnumFinder<E,Integer,Integer>(clazz, matcher, codingFinder));
	}

	public static <E extends Enum<E>> IntegerEnumFinder<E> codingEqualsFinder(
			Class<E> clazz, CodingFinder<E, Integer> codingFinder) {
		return codingFinder(clazz, new EqualsMatcher<Integer, Integer>(), codingFinder);
	}
	

}
