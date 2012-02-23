package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.AnnotatedKeyProvider;
import lazyeye.enumHelpers.finder.core.EnumFinderComposite;
import lazyeye.enumHelpers.finder.core.KeyMatcher;
import lazyeye.enumHelpers.finder.core.KeyProvider;
import lazyeye.enumHelpers.finder.matchers.EqualsMatcher;

/**
 * @author Tom McGee
 * 
 * IntegerEnumFinders is a set of factory methods the create IntegerEnumFinder instances
 * while hiding the complexity of creating them.
 *
 */
public class IntegerEnumFinders {
	
	/**
	 * 
	 * The fromAnnotatedKey method is a factory that builds an instance of IntegerEnumFinder.
	 * The target Enum is marked with a EnumFinderKey annotation to show what field or method
	 * will provide the key used for matching. 
	 * 
	 * @param <E>      target Enum type.
	 * @param clazz    class of the target Enum.
	 * @param tag      value of EnumFinderKey annotation.
	 * @param matcher  strategy for matching the input to the key.
	 * @return         the IntegerEnumFinder that is built.
	 */
	public static <E extends Enum<E>> IntegerEnumFinder<E> fromAnnotatedKey(
			Class<E> clazz, String tag, KeyMatcher<Integer, Integer> matcher) {
		KeyProvider<E, Integer> keyProvider = new AnnotatedKeyProvider<E,Integer>(clazz, Integer.class, tag);
		return new IntegerEnumFinder<E>(new EnumFinderComposite<E,Integer,Integer>(clazz, matcher, keyProvider));
	}

	/**
	 * 
	 * The fromAnnotatedKeyMatchEquals method is a factory that builds an instance of IntegerEnumFinder.
	 * The target Enum is marked with a EnumFinderKey annotation to show what field or method
	 * will provide the key used for matching. The matching strategy is a simple equals test.
	 * 
	 * @param <E>    target Enum type.
	 * @param clazz  class of the target Enum.
	 * @param tag    value of EnumFinderKey annotation.
	 * @return       the IntegerEnumFinder that is built.
	 */
	public static <E extends Enum<E>> IntegerEnumFinder<E> fromAnnotatedKeyMatchEquals(
			Class<E> clazz, String tag) {
		return fromAnnotatedKey(clazz, tag, new EqualsMatcher<Integer, Integer>());
	}
	
	/**
	 * 
	 * The fromKeyProvider method is a factory that builds an instance of IntegerEnumFinder.
	 * The key value from the target Enum is obtained from the strategy of the KeyProvider argument. 
	 * 
	 * @param <E>          target Enum type.
	 * @param clazz        class of the target Enum.
	 * @param matcher      strategy for matching the input to the key.
	 * @param keyProvider  strategy for getting the key value from the target Enum.
	 * @return             the IntegerEnumFinder that is built.
	 */
	public static <E extends Enum<E>> IntegerEnumFinder<E> fromKeyProvider(
			Class<E> clazz, KeyMatcher<Integer, Integer> matcher, IntegerKeyProvider<E> keyProvider) {
		return new IntegerEnumFinder<E>(new EnumFinderComposite<E,Integer,Integer>(clazz, matcher, keyProvider));
	}

	/**
	 * 
	 * The fromKeyProviderMatchEquals method is a factory that builds an instance of IntegerEnumFinder.
	 * The key value from the target Enum is obtained from the strategy of the KeyProvider argument. 
     * The matching strategy is a simple equals test.
	 * 
	 * @param <E>          target Enum type.
	 * @param clazz        class of the target Enum.
	 * @param keyProvider  strategy for getting the key value from the target Enum.
	 * @return             the IntegerEnumFinder that is built.
	 */
	public static <E extends Enum<E>> IntegerEnumFinder<E> fromKeyProviderMatchEquals(
			Class<E> clazz, IntegerKeyProvider<E> keyProvider) {
		return fromKeyProvider(clazz, new EqualsMatcher<Integer, Integer>(), keyProvider);
	}
	
}
