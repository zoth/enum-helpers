package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.AnnotatedCodedEnumFinder;
import lazyeye.enumHelpers.finder.core.CodedEnum;
import lazyeye.enumHelpers.finder.core.CodedEnumFinder;
import lazyeye.enumHelpers.finder.core.EnumFinder;
import lazyeye.enumHelpers.finder.core.ListEnumFinder;
import lazyeye.enumHelpers.finder.core.strategy.EqualsMatcher;
import lazyeye.enumHelpers.finder.core.strategy.MatcherStrategy;

public class IntegerEnumFinderFactory {

	public static <E extends Enum<E> & CodedEnum<Integer>> EnumFinder<E,Integer> codedEqualsFinder(
			Class<E> clazz) {
		return integerCodedEnumFinder(clazz, new EqualsMatcher<Integer, Integer>());
	}

	public static <E extends Enum<E> & CodedEnum<Integer>> EnumFinder<E,Integer> integerCodedEnumFinder(Class<E> clazz, MatcherStrategy<Integer, Integer> matcher){
		return CodedEnumFinder.simpleCodedEnumFinder(clazz, matcher);
	}

	public static <E extends Enum<E> & CodedEnum<Integer>> EnumFinder<E, Integer> integerListEnumFinder(Class<E> clazz, MatcherStrategy<Integer, Integer> matcher, Integer... codes){
		return ListEnumFinder.simpleListEnumFinder(clazz, matcher, codes);
	}
	
	public static <E extends Enum<E> & CodedEnum<Integer>> EnumFinder<E,Integer> integerAnnotatedCodedEnumFinder(
			Class<E> clazz, String tag, MatcherStrategy<Integer, Integer> matcher) {
		return AnnotatedCodedEnumFinder.simpleAnnotatedCodedEnumFinder(clazz, Integer.class, tag, matcher);
	}

	public static <E extends Enum<E> & CodedEnum<Integer>> EnumFinder<E,Integer> annotatedEqualsFinder(
			Class<E> clazz, String tag) {
		return integerAnnotatedCodedEnumFinder(clazz, tag, new EqualsMatcher<Integer, Integer>());
	}
	

}
