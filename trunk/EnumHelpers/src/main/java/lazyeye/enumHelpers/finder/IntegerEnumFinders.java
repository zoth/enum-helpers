package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.AnnotationKeyedProvider;
import lazyeye.enumHelpers.finder.core.BaseEnumFinder;
import lazyeye.enumHelpers.finder.core.KeyProvider;
import lazyeye.enumHelpers.finder.matchers.EqualsMatcher;
import lazyeye.enumHelpers.finder.matchers.MatcherStrategy;

public class IntegerEnumFinders {
	
	public static <E extends Enum<E>> IntegerEnumFinder<E> fromAnnotatedKey(
			Class<E> clazz, String tag, MatcherStrategy<Integer, Integer> matcher) {
		KeyProvider<E, Integer> keyProvider = new AnnotationKeyedProvider<E,Integer>(clazz, Integer.class, tag);
		return new IntegerEnumFinder<E>(new BaseEnumFinder<E,Integer,Integer>(clazz, matcher, keyProvider));
	}

	public static <E extends Enum<E>> IntegerEnumFinder<E> fromAnnotatedKeyMatchEquals(
			Class<E> clazz, String annotatedId) {
		return fromAnnotatedKey(clazz, annotatedId, new EqualsMatcher<Integer, Integer>());
	}
	
	public static <E extends Enum<E>> IntegerEnumFinder<E> fromKeyProvider(
			Class<E> clazz, MatcherStrategy<Integer, Integer> matcher, IntegerKeyedProvider<E> keyProvider) {
		return new IntegerEnumFinder<E>(new BaseEnumFinder<E,Integer,Integer>(clazz, matcher, keyProvider));
	}

	public static <E extends Enum<E>> IntegerEnumFinder<E> fromKeyProviderMatchEquals(
			Class<E> clazz, IntegerKeyedProvider<E> keyProvider) {
		return fromKeyProvider(clazz, new EqualsMatcher<Integer, Integer>(), keyProvider);
	}
	
}
