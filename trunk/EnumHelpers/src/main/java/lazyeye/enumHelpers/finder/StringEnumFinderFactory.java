package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.AnnotatedCodeFinder;
import lazyeye.enumHelpers.finder.core.BaseEnumFinder;
import lazyeye.enumHelpers.finder.core.CodingFinder;
import lazyeye.enumHelpers.finder.core.CodingEnumFinder;
import lazyeye.enumHelpers.finder.matchers.EqualsIgnoreCaseMatcher;
import lazyeye.enumHelpers.finder.matchers.EqualsMatcher;
import lazyeye.enumHelpers.finder.matchers.MatcherStrategy;
import lazyeye.enumHelpers.finder.matchers.PostfixMatcher;
import lazyeye.enumHelpers.finder.matchers.PrefixMatcher;
import lazyeye.enumHelpers.finder.matchers.RegexMatcher;

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
		CodingFinder<E, String> codingFinder = new CodingEnumFinder<E,String>();
		RegexMatcher<E> matcher = new RegexMatcher<E>(clazz,codingFinder);
		return new StringEnumFinder<E>(new BaseEnumFinder<E,String,String>(clazz, matcher, codingFinder));
	}
	
	public static <E extends Enum<E> & StringCodedEnum> StringEnumFinder<E> stringCodedEnumFinder(
			Class<E> clazz, MatcherStrategy<String, String> matcher) {
		CodingFinder<E, String> codingFinder = new CodingEnumFinder<E,String>();
		return new StringEnumFinder<E>(new BaseEnumFinder<E,String,String>(clazz, matcher, codingFinder));
	}

	public static <E extends Enum<E>> StringEnumFinder<E> annotatedCodedEnumFinder(
			Class<E> clazz, String tag, MatcherStrategy<String, String> matcher) {
		CodingFinder<E, String> codingFinder = new AnnotatedCodeFinder<E,String>(clazz, String.class, tag);
		return new StringEnumFinder<E>(new BaseEnumFinder<E,String,String>(clazz, matcher, codingFinder));
	}

	public static <E extends Enum<E>> StringEnumFinder<E> annotatedEqualsFinder(
			Class<E> clazz, String tag) {
		return annotatedCodedEnumFinder(clazz, tag, new EqualsMatcher<String, String>());
	}

	public static <E extends Enum<E>> StringEnumFinder<E> annotatedEqualsIgnoreCaseFinder(
			Class<E> clazz, String tag) {
		return annotatedCodedEnumFinder(clazz, tag, new EqualsIgnoreCaseMatcher());
	}

	public static <E extends Enum<E>> StringEnumFinder<E> annotatedPrefixFinder(
			Class<E> clazz, String tag) {
		return annotatedCodedEnumFinder(clazz, tag, new PrefixMatcher());
	}

	public static <E extends Enum<E>> StringEnumFinder<E> annotatedPostfixFinder(
			Class<E> clazz, String tag) {
		return annotatedCodedEnumFinder(clazz, tag, new PostfixMatcher());
	}

	public static <E extends Enum<E>> StringEnumFinder<E> annotatedRegexFinder(
			Class<E> clazz, String tag) {
		CodingFinder<E, String> codingFinder = new AnnotatedCodeFinder<E,String>(clazz, String.class, tag);
		RegexMatcher<E> matcher = new RegexMatcher<E>(clazz,codingFinder);
		return new StringEnumFinder<E>(new BaseEnumFinder<E,String,String>(clazz, matcher, codingFinder));
	}


	public static <E extends Enum<E>> StringEnumFinder<E> codingRegexFinder(
			Class<E> clazz, CodingFinder<E, String> codingFinder) {
		RegexMatcher<E> matcher = new RegexMatcher<E>(clazz,codingFinder);
		return new StringEnumFinder<E>(new BaseEnumFinder<E,String,String>(clazz, matcher, codingFinder));
	}

	public static <E extends Enum<E>> StringEnumFinder<E> codingFinder(
			Class<E> clazz, MatcherStrategy<String, String> matcher, CodingFinder<E, String> codingFinder) {
		return new StringEnumFinder<E>(new BaseEnumFinder<E,String,String>(clazz, matcher, codingFinder));
	}
	
	public static <E extends Enum<E>> StringEnumFinder<E> codingEqualsFinder(
			Class<E> clazz, CodingFinder<E, String> codingFinder) {
		return codingFinder(clazz, new EqualsMatcher<String, String>(), codingFinder);
	}

	public static <E extends Enum<E>> StringEnumFinder<E> codingEqualsIgnoreCaseFinder(
			Class<E> clazz, CodingFinder<E, String> codingFinder) {
		return codingFinder(clazz, new EqualsIgnoreCaseMatcher(), codingFinder);
	}

	public static <E extends Enum<E>> StringEnumFinder<E> codingPrefixFinder(
			Class<E> clazz, CodingFinder<E, String> codingFinder) {
		return codingFinder(clazz, new PrefixMatcher(), codingFinder);
	}

	public static <E extends Enum<E>> StringEnumFinder<E> codingPostfixFinder(
			Class<E> clazz, CodingFinder<E, String> codingFinder) {
		return codingFinder(clazz, new PostfixMatcher(), codingFinder);
	}


}
