package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.AnnotatedKeyProvider;
import lazyeye.enumHelpers.finder.core.EnumFinderComposite;
import lazyeye.enumHelpers.finder.core.KeyMatcher;
import lazyeye.enumHelpers.finder.core.KeyProvider;
import lazyeye.enumHelpers.finder.matchers.EqualsIgnoreCaseMatcher;
import lazyeye.enumHelpers.finder.matchers.EqualsMatcher;
import lazyeye.enumHelpers.finder.matchers.PostfixMatcher;
import lazyeye.enumHelpers.finder.matchers.PrefixMatcher;
import lazyeye.enumHelpers.finder.matchers.RegexMatcher;

/**
 * @author Tom McGee
 * 
 * StringEnumFinders is a set of factory methods the create StringEnumFinder instances
 * while hiding the complexity of creating them.
 *
 */
public class StringEnumFinders {

	/**
	 * 
	 * The fromAnnotatedKey method is a factory that builds an instance of StringEnumFinder.
	 *  
	 * @param <E>
	 * @param clazz
	 * @param tag
	 * @param matcher
	 * @return
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromAnnotatedKey(
			Class<E> clazz, String tag, KeyMatcher<String, String> matcher) {
		KeyProvider<E, String> keyProvider = new AnnotatedKeyProvider<E,String>(clazz, String.class, tag);
		return new StringEnumFinder<E>(new EnumFinderComposite<E,String,String>(clazz, matcher, keyProvider));
	}

	/**
	 * @param <E>
	 * @param clazz
	 * @param tag
	 * @return
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromAnnotatedKeyMatchEquals(
			Class<E> clazz, String tag) {
		return fromAnnotatedKey(clazz, tag, new EqualsMatcher<String, String>());
	}

	/**
	 * @param <E>
	 * @param clazz
	 * @param tag
	 * @return
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromAnnotatedKeyMatchEqualsIgnoreCase(
			Class<E> clazz, String tag) {
		return fromAnnotatedKey(clazz, tag, new EqualsIgnoreCaseMatcher());
	}

	/**
	 * @param <E>
	 * @param clazz
	 * @param tag
	 * @return
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromAnnotatedKeyMatchPrefix(
			Class<E> clazz, String tag) {
		return fromAnnotatedKey(clazz, tag, new PrefixMatcher());
	}

	/**
	 * @param <E>
	 * @param clazz
	 * @param tag
	 * @return
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromAnnotatedKeyMatchPostfix(
			Class<E> clazz, String tag) {
		return fromAnnotatedKey(clazz, tag, new PostfixMatcher());
	}

	/**
	 * @param <E>
	 * @param clazz
	 * @param tag
	 * @return
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromAnnotatedKeyMatchRegex(
			Class<E> clazz, String tag) {
		KeyProvider<E, String> keyProvider = new AnnotatedKeyProvider<E,String>(clazz, String.class, tag);
		RegexMatcher<E> matcher = new RegexMatcher<E>(clazz,keyProvider);
		return new StringEnumFinder<E>(new EnumFinderComposite<E,String,String>(clazz, matcher, keyProvider));
	}

	/**
	 * @param <E>
	 * @param clazz
	 * @param keyProvider
	 * @return
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromKeyProviderMatchRegex(
			Class<E> clazz, KeyProvider<E, String> keyProvider) {
		RegexMatcher<E> matcher = new RegexMatcher<E>(clazz,keyProvider);
		return new StringEnumFinder<E>(new EnumFinderComposite<E,String,String>(clazz, matcher, keyProvider));
	}

	/**
	 * @param <E>
	 * @param clazz
	 * @param matcher
	 * @param keyProvider
	 * @return
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromKeyProvider(
			Class<E> clazz, KeyMatcher<String, String> matcher, StringKeyProvider<E> keyProvider) {
		return new StringEnumFinder<E>(new EnumFinderComposite<E,String,String>(clazz, matcher, keyProvider));
	}
	
	/**
	 * @param <E>
	 * @param clazz
	 * @param keyProvider
	 * @return
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromKeyProviderMatchEquals(
			Class<E> clazz, StringKeyProvider<E> keyProvider) {
		return fromKeyProvider(clazz, new EqualsMatcher<String, String>(), keyProvider);
	}

	/**
	 * @param <E>
	 * @param clazz
	 * @param keyProvider
	 * @return
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromKeyProviderMatchEqualsIgnoreCase(
			Class<E> clazz, StringKeyProvider<E> keyProvider) {
		return fromKeyProvider(clazz, new EqualsIgnoreCaseMatcher(), keyProvider);
	}

	/**
	 * @param <E>
	 * @param clazz
	 * @param keyProvider
	 * @return
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromKeyProviderMatchPrefix(
			Class<E> clazz, StringKeyProvider<E> keyProvider) {
		return fromKeyProvider(clazz, new PrefixMatcher(), keyProvider);
	}

	/**
	 * @param <E>
	 * @param clazz
	 * @param keyProvider
	 * @return
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromKeyProviderMatchPostfix(
			Class<E> clazz, StringKeyProvider<E> keyProvider) {
		return fromKeyProvider(clazz, new PostfixMatcher(), keyProvider);
	}


}
