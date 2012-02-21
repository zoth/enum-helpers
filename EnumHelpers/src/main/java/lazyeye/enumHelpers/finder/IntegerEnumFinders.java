package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.AnnotatedKeyProvider;
import lazyeye.enumHelpers.finder.core.EnumFinderComposite;
import lazyeye.enumHelpers.finder.core.KeyMatcher;
import lazyeye.enumHelpers.finder.core.KeyProvider;
import lazyeye.enumHelpers.finder.matchers.EqualsMatcher;

public class IntegerEnumFinders {
	
	public static <E extends Enum<E>> IntegerEnumFinder<E> fromAnnotatedKey(
			Class<E> clazz, String tag, KeyMatcher<Integer, Integer> matcher) {
		KeyProvider<E, Integer> keyProvider = new AnnotatedKeyProvider<E,Integer>(clazz, Integer.class, tag);
		return new IntegerEnumFinder<E>(new EnumFinderComposite<E,Integer,Integer>(clazz, matcher, keyProvider));
	}

	public static <E extends Enum<E>> IntegerEnumFinder<E> fromAnnotatedKeyMatchEquals(
			Class<E> clazz, String annotatedId) {
		return fromAnnotatedKey(clazz, annotatedId, new EqualsMatcher<Integer, Integer>());
	}
	
	public static <E extends Enum<E>> IntegerEnumFinder<E> fromKeyProvider(
			Class<E> clazz, KeyMatcher<Integer, Integer> matcher, IntegerKeyProvider<E> keyProvider) {
		return new IntegerEnumFinder<E>(new EnumFinderComposite<E,Integer,Integer>(clazz, matcher, keyProvider));
	}

	public static <E extends Enum<E>> IntegerEnumFinder<E> fromKeyProviderMatchEquals(
			Class<E> clazz, IntegerKeyProvider<E> keyProvider) {
		return fromKeyProvider(clazz, new EqualsMatcher<Integer, Integer>(), keyProvider);
	}
	
}
