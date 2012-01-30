package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.AnnotatedCodedEnumFinder;
import lazyeye.enumHelpers.finder.core.CodedEnumFinder;
import lazyeye.enumHelpers.finder.core.ListEnumFinder;
import lazyeye.enumHelpers.finder.core.strategy.EqualsMatcher;
import lazyeye.enumHelpers.finder.core.strategy.MatcherStrategy;

public class IntegerEnumFinderFactory {

	public static <E extends Enum<E> & IntegerCodedEnum> IntegerEnumFinder<E> codedEqualsFinder(
			Class<E> clazz) {
		return integerCodedEnumFinder(clazz, new EqualsMatcher<Integer, Integer>());
	}

	public static <E extends Enum<E> & IntegerCodedEnum> IntegerEnumFinder<E> integerCodedEnumFinder(Class<E> clazz, MatcherStrategy<Integer, Integer> matcher){
		return new IntegerEnumFinder<E>(new CodedEnumFinder<E, Integer, Integer>(clazz, matcher));
	}

	public static <E extends Enum<E> & IntegerCodedEnum> IntegerEnumFinder<E> integerListEnumFinder(Class<E> clazz, MatcherStrategy<Integer, Integer> matcher, Integer... codes){
		return new IntegerEnumFinder<E>(new ListEnumFinder<E, Integer, Integer>(clazz, matcher, codes));
	}
	
	public static <E extends Enum<E>> IntegerEnumFinder<E> integerAnnotatedCodedEnumFinder(
			Class<E> clazz, String tag, MatcherStrategy<Integer, Integer> matcher) {
		return new IntegerEnumFinder<E>(new AnnotatedCodedEnumFinder<E, Integer, Integer>(clazz, Integer.class, tag, matcher));
	}

	public static <E extends Enum<E>> IntegerEnumFinder<E> annotatedEqualsFinder(
			Class<E> clazz, String tag) {
		return integerAnnotatedCodedEnumFinder(clazz, tag, new EqualsMatcher<Integer, Integer>());
	}
	

}
