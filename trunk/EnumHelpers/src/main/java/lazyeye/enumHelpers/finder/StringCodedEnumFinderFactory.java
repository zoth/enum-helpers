package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.CodedEnumFinder;
import lazyeye.enumHelpers.finder.core.EnumFinder;
import lazyeye.enumHelpers.finder.core.ListCodedEnumFinder;
import lazyeye.enumHelpers.finder.core.strategy.EqualsIgnoreCaseMatcher;
import lazyeye.enumHelpers.finder.core.strategy.EqualsMatcher;
import lazyeye.enumHelpers.finder.core.strategy.MatcherStrategy;
import lazyeye.enumHelpers.finder.core.strategy.PostfixMatcher;
import lazyeye.enumHelpers.finder.core.strategy.PrefixMatcher;
import lazyeye.enumHelpers.finder.core.strategy.RegexMatcher;

public class StringCodedEnumFinderFactory {

	public static <E extends Enum<E> & StringCodedEnum> StringCodedEnumFinder<E> equalsFinder(
			Class<E> clazz) {
		return stringCodedEnumFinder(clazz, new EqualsMatcher<String, String>());
	}

	public static <E extends Enum<E> & StringCodedEnum> StringCodedEnumFinder<E> equalsIgnoreCaseFinder(
			Class<E> clazz) {
		return stringCodedEnumFinder(clazz, new EqualsIgnoreCaseMatcher());
	}

	public static <E extends Enum<E> & StringCodedEnum> StringCodedEnumFinder<E> prefixFinder(
			Class<E> clazz) {
		return stringCodedEnumFinder(clazz, new PrefixMatcher());
	}

	public static <E extends Enum<E> & StringCodedEnum> StringCodedEnumFinder<E> postfixFinder(
			Class<E> clazz) {
		return stringCodedEnumFinder(clazz, new PostfixMatcher());
	}

	public static <E extends Enum<E> & StringCodedEnum> StringCodedEnumFinder<E> regexFinder(
			Class<E> clazz) {
		return stringCodedEnumFinder(clazz, new RegexMatcher<E>(clazz));
	}
	
	public static <E extends Enum<E>> EnumFinder<E, String> stringListCodedEnumFinder(Class<E> clazz, MatcherStrategy<String, String> matcher, String... codes){
		return ListCodedEnumFinder.simpleListCodedEnumFinder(clazz, matcher, codes);
	}
	
	public static <E extends Enum<E> & StringCodedEnum> StringCodedEnumFinder<E> stringCodedEnumFinder(Class<E> clazz, MatcherStrategy<String, String> matcher){
		return (StringCodedEnumFinder<E>) CodedEnumFinder.simpleCodedEnumFinder(clazz, matcher);
	}

}
