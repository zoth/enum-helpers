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
	 * The target Enum is marked with a EnumFinderKey annotation to show what field or method
	 * will provide the key used for matching. 
	 *  
	 * @param <E>      target Enum.
	 * @param clazz    class of the target Enum.
	 * @param tag      value of EnumFinderKey annotation.
	 * @param matcher  strategy for matching the input to the key.
	 * @return         the StringEnumFinder that is built.
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromAnnotatedKey(
			Class<E> clazz, String tag, KeyMatcher<String, String> matcher) {
		KeyProvider<E, String> keyProvider = new AnnotatedKeyProvider<E,String>(clazz, String.class, tag);
		return new StringEnumFinder<E>(new EnumFinderComposite<E,String,String>(clazz, matcher, keyProvider));
	}

	/**
	 * 
	 * The fromAnnotatedKeyMatchEquals method is a factory that builds an instance of StringEnumFinder.
	 * The target Enum is marked with a EnumFinderKey annotation to show what field or method
	 * will provide the key used for matching. The matching strategy is a simple equals test.
	 *  
	 * @param <E>      target Enum.
	 * @param clazz    class of the target Enum.
	 * @param tag      value of EnumFinderKey annotation.
	 * @return         the StringEnumFinder that is built.
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromAnnotatedKeyMatchEquals(
			Class<E> clazz, String tag) {
		return fromAnnotatedKey(clazz, tag, new EqualsMatcher<String, String>());
	}

	/**
	 * 
	 * The fromAnnotatedKeyMatchEqualsIgnoreCase method is a factory that builds an instance of StringEnumFinder.
	 * The target Enum is marked with a EnumFinderKey annotation to show what field or method
	 * will provide the key used for matching. The matching strategy is an equals test where case is ignored.
	 *  
	 * @param <E>      target Enum.
	 * @param clazz    class of the target Enum.
	 * @param tag      value of EnumFinderKey annotation.
	 * @return         the StringEnumFinder that is built.
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromAnnotatedKeyMatchEqualsIgnoreCase(
			Class<E> clazz, String tag) {
		return fromAnnotatedKey(clazz, tag, new EqualsIgnoreCaseMatcher());
	}

	/**
	 * 
	 * The fromAnnotatedKeyMatchPrefix method is a factory that builds an instance of StringEnumFinder.
	 * The target Enum is marked with a EnumFinderKey annotation to show what field or method
	 * will provide the key used for matching. The matching strategy is a test where the input value is prefixed
	 * with the key value.
	 *  
	 * @param <E>      target Enum.
	 * @param clazz    class of the target Enum.
	 * @param tag      value of EnumFinderKey annotation.
	 * @return         the StringEnumFinder that is built.
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromAnnotatedKeyMatchPrefix(
			Class<E> clazz, String tag) {
		return fromAnnotatedKey(clazz, tag, new PrefixMatcher());
	}

	/**
	 * 
	 * The fromAnnotatedKeyMatchPostfix method is a factory that builds an instance of StringEnumFinder.
	 * The target Enum is marked with a EnumFinderKey annotation to show what field or method
	 * will provide the key used for matching. The matching strategy is a test where the input value is post-fixed
	 * with the key value.
	 *  
	 * @param <E>      target Enum.
	 * @param clazz    class of the target Enum.
	 * @param tag      value of EnumFinderKey annotation.
	 * @return         the StringEnumFinder that is built.
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromAnnotatedKeyMatchPostfix(
			Class<E> clazz, String tag) {
		return fromAnnotatedKey(clazz, tag, new PostfixMatcher());
	}

	/**
	 * 
	 * The fromAnnotatedKeyMatchRegex method is a factory that builds an instance of StringEnumFinder.
	 * The target Enum is marked with a EnumFinderKey annotation to show what field or method
	 * will provide the key used for matching. The matching strategy is at test where the input value matches
	 * a regex key value. 
	 *  
	 * @param <E>      target Enum.
	 * @param clazz    class of the target Enum.
	 * @param tag      value of EnumFinderKey annotation.
	 * @return         the StringEnumFinder that is built.
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromAnnotatedKeyMatchRegex(
			Class<E> clazz, String tag) {
		KeyProvider<E, String> keyProvider = new AnnotatedKeyProvider<E,String>(clazz, String.class, tag);
		RegexMatcher<E> matcher = new RegexMatcher<E>(clazz,keyProvider);
		return new StringEnumFinder<E>(new EnumFinderComposite<E,String,String>(clazz, matcher, keyProvider));
	}

	/**
	 * 
	 * The fromKeyProviderMatchRegex method is a factory that builds an instance of StringEnumFinder.
	 * The key value from the target Enum is obtained from the strategy of the KeyProvider argument. 
     * The matching strategy is at test where the input value matches a regex key value.
     * 
	 * @param <E>          target Enum.
	 * @param clazz        class of the target Enum.
	 * @param keyProvider  strategy for getting the key value from the target Enum.
	 * @return             the StringEnumFinder that is built.
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromKeyProviderMatchRegex(
			Class<E> clazz, KeyProvider<E, String> keyProvider) {
		RegexMatcher<E> matcher = new RegexMatcher<E>(clazz,keyProvider);
		return new StringEnumFinder<E>(new EnumFinderComposite<E,String,String>(clazz, matcher, keyProvider));
	}

	/**
	 * 
	 * The fromKeyProvider method is a factory that builds an instance of StringEnumFinder.
	 * The key value from the target Enum is obtained from the strategy of the KeyProvider argument. 
     * 
	 * @param <E>          target Enum.
	 * @param clazz        class of the target Enum.
	 * @param matcher      strategy for matching the input to the key.
	 * @param keyProvider  strategy for getting the key value from the target Enum.
	 * @return             the StringEnumFinder that is built.
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromKeyProvider(
			Class<E> clazz, KeyMatcher<String, String> matcher, StringKeyProvider<E> keyProvider) {
		return new StringEnumFinder<E>(new EnumFinderComposite<E,String,String>(clazz, matcher, keyProvider));
	}
	
	/**
	 * 
	 * The fromKeyProviderMatchEquals method is a factory that builds an instance of StringEnumFinder.
	 * The key value from the target Enum is obtained from the strategy of the KeyProvider argument. 
     * The matching strategy is a simple equals test.
     * 
	 * @param <E>          target Enum.
	 * @param clazz        class of the target Enum.
	 * @param keyProvider  strategy for getting the key value from the target Enum.
	 * @return             the StringEnumFinder that is built.
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromKeyProviderMatchEquals(
			Class<E> clazz, StringKeyProvider<E> keyProvider) {
		return fromKeyProvider(clazz, new EqualsMatcher<String, String>(), keyProvider);
	}

	/**
	 * 
	 * The fromKeyProviderMatchEqualsIgnoreCase method is a factory that builds an instance of StringEnumFinder.
	 * The key value from the target Enum is obtained from the strategy of the KeyProvider argument. 
     * The matching strategy is an equals test where case is ignored.
     * 
	 * @param <E>          target Enum.
	 * @param clazz        class of the target Enum.
	 * @param keyProvider  strategy for getting the key value from the target Enum.
	 * @return             the StringEnumFinder that is built.
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromKeyProviderMatchEqualsIgnoreCase(
			Class<E> clazz, StringKeyProvider<E> keyProvider) {
		return fromKeyProvider(clazz, new EqualsIgnoreCaseMatcher(), keyProvider);
	}

	/**
	 * 
	 * The fromKeyProviderMatchPrefix method is a factory that builds an instance of StringEnumFinder.
	 * The key value from the target Enum is obtained from the strategy of the KeyProvider argument. 
      * The matching strategy is a test where the input value is prefixed with the key value.
     * 
	 * @param <E>          target Enum.
	 * @param clazz        class of the target Enum.
	 * @param keyProvider  strategy for getting the key value from the target Enum.
	 * @return             the StringEnumFinder that is built.
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromKeyProviderMatchPrefix(
			Class<E> clazz, StringKeyProvider<E> keyProvider) {
		return fromKeyProvider(clazz, new PrefixMatcher(), keyProvider);
	}

	/**
	 * 
	 * The fromKeyProviderMatchPostfix method is a factory that builds an instance of StringEnumFinder.
	 * The key value from the target Enum is obtained from the strategy of the KeyProvider argument. 
     * The matching strategy is a test where the input value is post-fixed with the key value.
     *     
	 * @param <E>          target Enum.
	 * @param clazz        class of the target Enum.
	 * @param keyProvider  strategy for getting the key value from the target Enum.
	 * @return             the StringEnumFinder that is built.
	 */
	public static <E extends Enum<E>> StringEnumFinder<E> fromKeyProviderMatchPostfix(
			Class<E> clazz, StringKeyProvider<E> keyProvider) {
		return fromKeyProvider(clazz, new PostfixMatcher(), keyProvider);
	}


}
