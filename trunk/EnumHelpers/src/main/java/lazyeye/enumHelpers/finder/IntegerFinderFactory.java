package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.TagCodeProvider;
import lazyeye.enumHelpers.finder.core.BaseEnumFinder;
import lazyeye.enumHelpers.finder.core.CodeProvider;
import lazyeye.enumHelpers.finder.core.CodeProviderEnumFinder;
import lazyeye.enumHelpers.finder.matchers.EqualsMatcher;
import lazyeye.enumHelpers.finder.matchers.MatcherStrategy;

public class IntegerFinderFactory {

	public static <E extends Enum<E> & IntegerFinderCodeInterface> IntegerEnumFinder<E> codedEquals(
			Class<E> clazz) {
		return integerCoded(clazz, new EqualsMatcher<Integer, Integer>());
	}
	
	public static <E extends Enum<E> & IntegerFinderCodeInterface> IntegerEnumFinder<E> integerCoded(
			Class<E> clazz, MatcherStrategy<Integer, Integer> matcher) {
		CodeProvider<E, Integer> codeFinder = new CodeProviderEnumFinder<E,Integer>();
		return new IntegerEnumFinder<E>(new BaseEnumFinder<E,Integer,Integer>(clazz, matcher, codeFinder));
	}

	
	public static <E extends Enum<E>> IntegerEnumFinder<E> integerAnnotatedCoded(
			Class<E> clazz, String tag, MatcherStrategy<Integer, Integer> matcher) {
		CodeProvider<E, Integer> codeFinder = new TagCodeProvider<E,Integer>(clazz, Integer.class, tag);
		return new IntegerEnumFinder<E>(new BaseEnumFinder<E,Integer,Integer>(clazz, matcher, codeFinder));
	}

	public static <E extends Enum<E>> IntegerEnumFinder<E> annotatedEquals(
			Class<E> clazz, String tag) {
		return integerAnnotatedCoded(clazz, tag, new EqualsMatcher<Integer, Integer>());
	}
	
	public static <E extends Enum<E>> IntegerEnumFinder<E> coding(
			Class<E> clazz, MatcherStrategy<Integer, Integer> matcher, CodeProvider<E, Integer> codingFinder) {
		return new IntegerEnumFinder<E>(new BaseEnumFinder<E,Integer,Integer>(clazz, matcher, codingFinder));
	}

	public static <E extends Enum<E>> IntegerEnumFinder<E> codingEquals(
			Class<E> clazz, CodeProvider<E, Integer> codingFinder) {
		return coding(clazz, new EqualsMatcher<Integer, Integer>(), codingFinder);
	}
	

}
