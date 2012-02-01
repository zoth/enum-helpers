package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.AnnotationKeyedProvider;
import lazyeye.enumHelpers.finder.core.BaseEnumFinder;
import lazyeye.enumHelpers.finder.core.KeyProvider;
import lazyeye.enumHelpers.finder.matchers.EqualsIgnoreCaseMatcher;
import lazyeye.enumHelpers.finder.matchers.EqualsMatcher;
import lazyeye.enumHelpers.finder.matchers.MatcherStrategy;
import lazyeye.enumHelpers.finder.matchers.PostfixMatcher;
import lazyeye.enumHelpers.finder.matchers.PrefixMatcher;
import lazyeye.enumHelpers.finder.matchers.RegexMatcher;

public class StringEnumFinders {

	public static <E extends Enum<E>> StringEnumFinder<E> fromAnnotatedKey(
			Class<E> clazz, String tag, MatcherStrategy<String, String> matcher) {
		KeyProvider<E, String> keyProvider = new AnnotationKeyedProvider<E,String>(clazz, String.class, tag);
		return new StringEnumFinder<E>(new BaseEnumFinder<E,String,String>(clazz, matcher, keyProvider));
	}

	public static <E extends Enum<E>> StringEnumFinder<E> fromAnnotatedKeyMatchEquals(
			Class<E> clazz, String tag) {
		return fromAnnotatedKey(clazz, tag, new EqualsMatcher<String, String>());
	}

	public static <E extends Enum<E>> StringEnumFinder<E> fromAnnotatedKeyMatchEqualsIgnoreCase(
			Class<E> clazz, String tag) {
		return fromAnnotatedKey(clazz, tag, new EqualsIgnoreCaseMatcher());
	}

	public static <E extends Enum<E>> StringEnumFinder<E> fromAnnotatedKeyMatchPrefix(
			Class<E> clazz, String tag) {
		return fromAnnotatedKey(clazz, tag, new PrefixMatcher());
	}

	public static <E extends Enum<E>> StringEnumFinder<E> fromAnnotatedKeyMatchPostfix(
			Class<E> clazz, String tag) {
		return fromAnnotatedKey(clazz, tag, new PostfixMatcher());
	}

	public static <E extends Enum<E>> StringEnumFinder<E> fromAnnotatedKeyMatchRegex(
			Class<E> clazz, String tag) {
		KeyProvider<E, String> keyProvider = new AnnotationKeyedProvider<E,String>(clazz, String.class, tag);
		RegexMatcher<E> matcher = new RegexMatcher<E>(clazz,keyProvider);
		return new StringEnumFinder<E>(new BaseEnumFinder<E,String,String>(clazz, matcher, keyProvider));
	}


	public static <E extends Enum<E>> StringEnumFinder<E> fromKeyProviderMatchRegex(
			Class<E> clazz, KeyProvider<E, String> keyProvider) {
		RegexMatcher<E> matcher = new RegexMatcher<E>(clazz,keyProvider);
		return new StringEnumFinder<E>(new BaseEnumFinder<E,String,String>(clazz, matcher, keyProvider));
	}

	public static <E extends Enum<E>> StringEnumFinder<E> fromKeyProvider(
			Class<E> clazz, MatcherStrategy<String, String> matcher, StringKeyedProvider<E> keyProvider) {
		return new StringEnumFinder<E>(new BaseEnumFinder<E,String,String>(clazz, matcher, keyProvider));
	}
	
	public static <E extends Enum<E>> StringEnumFinder<E> fromKeyProviderMatchEquals(
			Class<E> clazz, StringKeyedProvider<E> keyProvider) {
		return fromKeyProvider(clazz, new EqualsMatcher<String, String>(), keyProvider);
	}

	public static <E extends Enum<E>> StringEnumFinder<E> fromKeyProviderMatchEqualsIgnoreCase(
			Class<E> clazz, StringKeyedProvider<E> keyProvider) {
		return fromKeyProvider(clazz, new EqualsIgnoreCaseMatcher(), keyProvider);
	}

	public static <E extends Enum<E>> StringEnumFinder<E> fromKeyProviderMatchPrefix(
			Class<E> clazz, StringKeyedProvider<E> keyProvider) {
		return fromKeyProvider(clazz, new PrefixMatcher(), keyProvider);
	}

	public static <E extends Enum<E>> StringEnumFinder<E> fromKeyProviderMatchPostfix(
			Class<E> clazz, StringKeyedProvider<E> keyProvider) {
		return fromKeyProvider(clazz, new PostfixMatcher(), keyProvider);
	}


}
