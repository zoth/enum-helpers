package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.AnnotationKeyedProvider;
import lazyeye.enumHelpers.finder.core.BaseEnumFinder;
import lazyeye.enumHelpers.finder.core.KeyProvider;
import lazyeye.enumHelpers.finder.matchers.EqualsMatcher;
import lazyeye.enumHelpers.finder.matchers.MatcherStrategy;

public class IntegerEnumFinders {
	
	public static <E extends Enum<E>> IntegerEnumFinder<E> tagCoded(
			Class<E> clazz, String tag, MatcherStrategy<Integer, Integer> matcher) {
		KeyProvider<E, Integer> keyProvider = new AnnotationKeyedProvider<E,Integer>(clazz, Integer.class, tag);
		return new IntegerEnumFinder<E>(new BaseEnumFinder<E,Integer,Integer>(clazz, matcher, keyProvider));
	}

	public static <E extends Enum<E>> IntegerEnumFinder<E> tagCodedEquals(
			Class<E> clazz, String tag) {
		return tagCoded(clazz, tag, new EqualsMatcher<Integer, Integer>());
	}
	
	public static <E extends Enum<E>> IntegerEnumFinder<E> coding(
			Class<E> clazz, MatcherStrategy<Integer, Integer> matcher, IntegerKeyedProvider<E> keyProvider) {
		return new IntegerEnumFinder<E>(new BaseEnumFinder<E,Integer,Integer>(clazz, matcher, keyProvider));
	}

	public static <E extends Enum<E>> IntegerEnumFinder<E> codingEquals(
			Class<E> clazz, IntegerKeyedProvider<E> keyProvider) {
		return coding(clazz, new EqualsMatcher<Integer, Integer>(), keyProvider);
	}
	
}
