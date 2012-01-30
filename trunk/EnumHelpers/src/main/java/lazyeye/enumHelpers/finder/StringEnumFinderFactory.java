package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.AnnotatedCodedEnumFinder;
import lazyeye.enumHelpers.finder.core.CodedEnum;
import lazyeye.enumHelpers.finder.core.CodedEnumFinder;
import lazyeye.enumHelpers.finder.core.EnumFinder;
import lazyeye.enumHelpers.finder.core.ListEnumFinder;
import lazyeye.enumHelpers.finder.core.strategy.EqualsIgnoreCaseMatcher;
import lazyeye.enumHelpers.finder.core.strategy.EqualsMatcher;
import lazyeye.enumHelpers.finder.core.strategy.MatcherStrategy;
import lazyeye.enumHelpers.finder.core.strategy.PostfixMatcher;
import lazyeye.enumHelpers.finder.core.strategy.PrefixMatcher;
import lazyeye.enumHelpers.finder.core.strategy.RegexMatcher;

public class StringEnumFinderFactory {

	public static <E extends Enum<E> & CodedEnum<String>> EnumFinder<E, String> codedEqualsFinder(
			Class<E> clazz) {
		return stringCodedEnumFinder(clazz, new EqualsMatcher<String, String>());
	}

	public static <E extends Enum<E> & CodedEnum<String>> EnumFinder<E, String> codedEqualsIgnoreCaseFinder(
			Class<E> clazz) {
		return stringCodedEnumFinder(clazz, new EqualsIgnoreCaseMatcher());
	}

	public static <E extends Enum<E> & CodedEnum<String>> EnumFinder<E, String> codedPrefixFinder(
			Class<E> clazz) {
		return stringCodedEnumFinder(clazz, new PrefixMatcher());
	}

	public static <E extends Enum<E> & CodedEnum<String>> EnumFinder<E, String> codedPostfixFinder(
			Class<E> clazz) {
		return stringCodedEnumFinder(clazz, new PostfixMatcher());
	}

	public static <E extends Enum<E> & CodedEnum<String>> EnumFinder<E,String> codedRegexFinder(
			Class<E> clazz) {
		return stringCodedEnumFinder(clazz, new RegexMatcher<E>(clazz));
	}
	
	public static <E extends Enum<E>> EnumFinder<E, String> stringListEnumFinder(Class<E> clazz, MatcherStrategy<String, String> matcher, String... codes){
		return ListEnumFinder.simpleListEnumFinder(clazz, matcher, codes);
	}
	
	public static <E extends Enum<E> & CodedEnum<String>> EnumFinder<E,String> stringCodedEnumFinder(
			Class<E> clazz, MatcherStrategy<String, String> matcher) {
		return CodedEnumFinder.simpleCodedEnumFinder(clazz, matcher);
	}
	
	public static <E extends Enum<E> & CodedEnum<String>> EnumFinder<E,String> stringAnnotatedCodedEnumFinder(
			Class<E> clazz, String tag, MatcherStrategy<String, String> matcher) {
		return AnnotatedCodedEnumFinder.simpleAnnotatedCodedEnumFinder(clazz, String.class, tag, matcher);
	}
	
	public static <E extends Enum<E> & CodedEnum<String>> EnumFinder<E, String> annotatedEqualsFinder(
			Class<E> clazz, String tag) {
		return stringAnnotatedCodedEnumFinder(clazz, tag, new EqualsMatcher<String, String>());
	}

	public static <E extends Enum<E> & CodedEnum<String>> EnumFinder<E, String> annotatedEqualsIgnoreCaseFinder(
			Class<E> clazz, String tag) {
		return stringAnnotatedCodedEnumFinder(clazz, tag, new EqualsIgnoreCaseMatcher());
	}

	public static <E extends Enum<E> & CodedEnum<String>> EnumFinder<E, String> annotatedPrefixFinder(
			Class<E> clazz, String tag) {
		return stringAnnotatedCodedEnumFinder(clazz, tag, new PrefixMatcher());
	}

	public static <E extends Enum<E> & CodedEnum<String>> EnumFinder<E, String> annotatedPostfixFinder(
			Class<E> clazz, String tag) {
		return stringAnnotatedCodedEnumFinder(clazz, tag, new PostfixMatcher());
	}

	public static <E extends Enum<E> & CodedEnum<String>> EnumFinder<E,String> annotatedRegexFinder(
			Class<E> clazz, String tag) {
		return stringAnnotatedCodedEnumFinder(clazz, tag, new RegexMatcher<E>(clazz));
	}
	


}
