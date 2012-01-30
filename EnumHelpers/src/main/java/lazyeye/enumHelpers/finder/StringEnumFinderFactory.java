package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.AnnotatedCodedEnumFinder;
import lazyeye.enumHelpers.finder.core.CodedEnumFinder;
import lazyeye.enumHelpers.finder.core.ListEnumFinder;
import lazyeye.enumHelpers.finder.core.strategy.EqualsIgnoreCaseMatcher;
import lazyeye.enumHelpers.finder.core.strategy.EqualsMatcher;
import lazyeye.enumHelpers.finder.core.strategy.MatcherStrategy;
import lazyeye.enumHelpers.finder.core.strategy.PostfixMatcher;
import lazyeye.enumHelpers.finder.core.strategy.PrefixMatcher;
import lazyeye.enumHelpers.finder.core.strategy.RegexMatcher;

public class StringEnumFinderFactory {

	public static <E extends Enum<E> & StringCodedEnum> StringEnumFinder<E> codedEqualsFinder(
			Class<E> clazz) {
		return stringCodedEnumFinder(clazz, new EqualsMatcher<String, String>());
	}

	public static <E extends Enum<E> & StringCodedEnum> StringEnumFinder<E> codedEqualsIgnoreCaseFinder(
			Class<E> clazz) {
		return stringCodedEnumFinder(clazz, new EqualsIgnoreCaseMatcher());
	}

	public static <E extends Enum<E> & StringCodedEnum> StringEnumFinder<E> codedPrefixFinder(
			Class<E> clazz) {
		return stringCodedEnumFinder(clazz, new PrefixMatcher());
	}

	public static <E extends Enum<E> & StringCodedEnum> StringEnumFinder<E> codedPostfixFinder(
			Class<E> clazz) {
		return stringCodedEnumFinder(clazz, new PostfixMatcher());
	}

	public static <E extends Enum<E> & StringCodedEnum> StringEnumFinder<E> codedRegexFinder(
			Class<E> clazz) {
		RegexMatcher<E> matcher = new RegexMatcher<E>(clazz);
		CodedEnumFinder<E,String,String> finder = new CodedEnumFinder<E, String, String>(clazz, matcher);
		matcher.setup(finder);
		return new StringEnumFinder<E>(finder);
	}
	
	public static <E extends Enum<E> & StringCodedEnum> StringEnumFinder<E> stringCodedEnumFinder(
			Class<E> clazz, MatcherStrategy<String, String> matcher) {
		return new StringEnumFinder<E>(new CodedEnumFinder<E, String, String>(clazz, matcher));
	}
	
	public static <E extends Enum<E>> StringEnumFinder<E> stringAnnotatedCodedEnumFinder(
			Class<E> clazz, String tag, MatcherStrategy<String, String> matcher) {
		return new StringEnumFinder<E>(new AnnotatedCodedEnumFinder<E, String, String>(clazz, String.class, tag, matcher));
	}
	
	public static <E extends Enum<E>> StringEnumFinder<E> annotatedEqualsFinder(
			Class<E> clazz, String tag) {
		return stringAnnotatedCodedEnumFinder(clazz, tag, new EqualsMatcher<String, String>());
	}

	public static <E extends Enum<E>> StringEnumFinder<E> annotatedEqualsIgnoreCaseFinder(
			Class<E> clazz, String tag) {
		return stringAnnotatedCodedEnumFinder(clazz, tag, new EqualsIgnoreCaseMatcher());
	}

	public static <E extends Enum<E>> StringEnumFinder<E> annotatedPrefixFinder(
			Class<E> clazz, String tag) {
		return stringAnnotatedCodedEnumFinder(clazz, tag, new PrefixMatcher());
	}

	public static <E extends Enum<E>> StringEnumFinder<E> annotatedPostfixFinder(
			Class<E> clazz, String tag) {
		return stringAnnotatedCodedEnumFinder(clazz, tag, new PostfixMatcher());
	}

	public static <E extends Enum<E>> StringEnumFinder<E> annotatedRegexFinder(
			Class<E> clazz, String tag) {
		RegexMatcher<E> matcher = new RegexMatcher<E>(clazz);
		AnnotatedCodedEnumFinder<E,String,String> finder = new AnnotatedCodedEnumFinder<E, String, String>(clazz, String.class, tag, matcher);
		matcher.setup(finder);
		return new StringEnumFinder<E>(finder);
	}

	public static <E extends Enum<E>> StringEnumFinder<E> stringListEnumFinder(Class<E> clazz, MatcherStrategy<String, String> matcher, String... codes){
		return new StringEnumFinder<E>(new ListEnumFinder<E, String, String>(clazz, matcher, codes));
	}
	
	public static <E extends Enum<E>> StringEnumFinder<E> listEqualsFinder(
			Class<E> clazz, String... codes) {
		return stringListEnumFinder(clazz, new EqualsMatcher<String, String>(), codes);
	}

	public static <E extends Enum<E>> StringEnumFinder<E> listEqualsIgnoreCaseFinder(
			Class<E> clazz, String... codes) {
		return stringListEnumFinder(clazz, new EqualsIgnoreCaseMatcher(), codes);
	}

	public static <E extends Enum<E>> StringEnumFinder<E> listPrefixFinder(
			Class<E> clazz, String... codes) {
		return stringListEnumFinder(clazz, new PrefixMatcher(), codes);
	}

	public static <E extends Enum<E>> StringEnumFinder<E> listPostfixFinder(
			Class<E> clazz, String... codes) {
		return stringListEnumFinder(clazz, new PostfixMatcher(), codes);
	}
	
	public static <E extends Enum<E>> StringEnumFinder<E> listRegexFinder(
			Class<E> clazz, String... codes) {
		RegexMatcher<E> matcher = new RegexMatcher<E>(clazz);
		ListEnumFinder<E, String, String> finder = new ListEnumFinder<E, String, String>(clazz, matcher, codes);
		matcher.setup(finder);
		return new StringEnumFinder<E>(finder);
	}
	


}
