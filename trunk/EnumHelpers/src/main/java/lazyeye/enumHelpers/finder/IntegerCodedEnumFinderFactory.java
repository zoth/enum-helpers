package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.CodedEnumFinder;
import lazyeye.enumHelpers.finder.core.EnumFinder;
import lazyeye.enumHelpers.finder.core.ListCodedEnumFinder;
import lazyeye.enumHelpers.finder.core.strategy.EqualsMatcher;
import lazyeye.enumHelpers.finder.core.strategy.MatcherStrategy;

public class IntegerCodedEnumFinderFactory {

	public static <E extends Enum<E> & IntegerCodedEnum> IntegerCodedEnumFinder<E> equalsFinder(
			Class<E> clazz) {
		return integerCodedEnumFinder(clazz, new EqualsMatcher<Integer, Integer>());
	}

	public static <E extends Enum<E> & IntegerCodedEnum> IntegerCodedEnumFinder<E> integerCodedEnumFinder(Class<E> clazz, MatcherStrategy<Integer, Integer> matcher){
		return (IntegerCodedEnumFinder<E>) CodedEnumFinder.simpleCodedEnumFinder(clazz, matcher);
	}

	public static <E extends Enum<E>> EnumFinder<E, Integer> integerListCodedEnumFinder(Class<E> clazz, MatcherStrategy<Integer, Integer> matcher, Integer... codes){
		return ListCodedEnumFinder.simpleListCodedEnumFinder(clazz, matcher, codes);
	}

}
