package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.TagCodeProvider;
import lazyeye.enumHelpers.finder.core.BaseEnumFinder;
import lazyeye.enumHelpers.finder.core.CodeProvider;
import lazyeye.enumHelpers.finder.core.CodeProviderEnumFinder;
import lazyeye.enumHelpers.finder.matchers.EqualsIgnoreCaseMatcher;
import lazyeye.enumHelpers.finder.matchers.EqualsMatcher;
import lazyeye.enumHelpers.finder.matchers.MatcherStrategy;
import lazyeye.enumHelpers.finder.matchers.PostfixMatcher;
import lazyeye.enumHelpers.finder.matchers.PrefixMatcher;
import lazyeye.enumHelpers.finder.matchers.RegexMatcher;

public class StringFinderFactory {

	public static <E extends Enum<E> & StringFinderCodeInterface> StringEnumFinder<E> codedEquals(
			Class<E> clazz) {
		return stringCoded(clazz, new EqualsMatcher<String, String>());
	}

	public static <E extends Enum<E> & StringFinderCodeInterface> StringEnumFinder<E> codedEqualsIgnoreCase(
			Class<E> clazz) {
		return stringCoded(clazz, new EqualsIgnoreCaseMatcher());
	}

	public static <E extends Enum<E> & StringFinderCodeInterface> StringEnumFinder<E> codedPrefix(
			Class<E> clazz) {
		return stringCoded(clazz, new PrefixMatcher());
	}

	public static <E extends Enum<E> & StringFinderCodeInterface> StringEnumFinder<E> codedPostfix(
			Class<E> clazz) {
		return stringCoded(clazz, new PostfixMatcher());
	}

	public static <E extends Enum<E> & StringFinderCodeInterface> StringEnumFinder<E> codedRegex(
			Class<E> clazz) {
		CodeProvider<E, String> codingFinder = new CodeProviderEnumFinder<E,String>();
		RegexMatcher<E> matcher = new RegexMatcher<E>(clazz,codingFinder);
		return new StringEnumFinder<E>(new BaseEnumFinder<E,String,String>(clazz, matcher, codingFinder));
	}
	
	public static <E extends Enum<E> & StringFinderCodeInterface> StringEnumFinder<E> stringCoded(
			Class<E> clazz, MatcherStrategy<String, String> matcher) {
		CodeProvider<E, String> codingFinder = new CodeProviderEnumFinder<E,String>();
		return new StringEnumFinder<E>(new BaseEnumFinder<E,String,String>(clazz, matcher, codingFinder));
	}

	public static <E extends Enum<E>> StringEnumFinder<E> tagCode(
			Class<E> clazz, String tag, MatcherStrategy<String, String> matcher) {
		CodeProvider<E, String> codingFinder = new TagCodeProvider<E,String>(clazz, String.class, tag);
		return new StringEnumFinder<E>(new BaseEnumFinder<E,String,String>(clazz, matcher, codingFinder));
	}

	public static <E extends Enum<E>> StringEnumFinder<E> tagCodeEquals(
			Class<E> clazz, String tag) {
		return tagCode(clazz, tag, new EqualsMatcher<String, String>());
	}

	public static <E extends Enum<E>> StringEnumFinder<E> tagCodeEqualsIgnoreCase(
			Class<E> clazz, String tag) {
		return tagCode(clazz, tag, new EqualsIgnoreCaseMatcher());
	}

	public static <E extends Enum<E>> StringEnumFinder<E> tagCodePrefix(
			Class<E> clazz, String tag) {
		return tagCode(clazz, tag, new PrefixMatcher());
	}

	public static <E extends Enum<E>> StringEnumFinder<E> tagCodePostfix(
			Class<E> clazz, String tag) {
		return tagCode(clazz, tag, new PostfixMatcher());
	}

	public static <E extends Enum<E>> StringEnumFinder<E> tagCodeRegex(
			Class<E> clazz, String tag) {
		CodeProvider<E, String> codingFinder = new TagCodeProvider<E,String>(clazz, String.class, tag);
		RegexMatcher<E> matcher = new RegexMatcher<E>(clazz,codingFinder);
		return new StringEnumFinder<E>(new BaseEnumFinder<E,String,String>(clazz, matcher, codingFinder));
	}


	public static <E extends Enum<E>> StringEnumFinder<E> codeProviderRegex(
			Class<E> clazz, CodeProvider<E, String> codingFinder) {
		RegexMatcher<E> matcher = new RegexMatcher<E>(clazz,codingFinder);
		return new StringEnumFinder<E>(new BaseEnumFinder<E,String,String>(clazz, matcher, codingFinder));
	}

	public static <E extends Enum<E>> StringEnumFinder<E> codeProviderFinder(
			Class<E> clazz, MatcherStrategy<String, String> matcher, CodeProvider<E, String> codingFinder) {
		return new StringEnumFinder<E>(new BaseEnumFinder<E,String,String>(clazz, matcher, codingFinder));
	}
	
	public static <E extends Enum<E>> StringEnumFinder<E> codeProviderEquals(
			Class<E> clazz, CodeProvider<E, String> codingFinder) {
		return codeProviderFinder(clazz, new EqualsMatcher<String, String>(), codingFinder);
	}

	public static <E extends Enum<E>> StringEnumFinder<E> codeProviderEqualsIgnoreCase(
			Class<E> clazz, CodeProvider<E, String> codingFinder) {
		return codeProviderFinder(clazz, new EqualsIgnoreCaseMatcher(), codingFinder);
	}

	public static <E extends Enum<E>> StringEnumFinder<E> codeProviderPrefix(
			Class<E> clazz, CodeProvider<E, String> codingFinder) {
		return codeProviderFinder(clazz, new PrefixMatcher(), codingFinder);
	}

	public static <E extends Enum<E>> StringEnumFinder<E> codeProviderPostfix(
			Class<E> clazz, CodeProvider<E, String> codingFinder) {
		return codeProviderFinder(clazz, new PostfixMatcher(), codingFinder);
	}


}
