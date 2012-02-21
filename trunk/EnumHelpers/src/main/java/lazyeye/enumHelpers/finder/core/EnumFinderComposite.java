package lazyeye.enumHelpers.finder.core;

import java.util.Arrays;
import java.util.List;


/**
 * @author Tom McGee
 *
 * @param <E>
 * @param <I>
 * @param <K>
 */
public class EnumFinderComposite<E extends Enum<E>, I, K> implements EnumFinder<E, I> {

	private List<E> enums;
	private KeyMatcher<I, K> matcher;
	private KeyProvider<E, K> provider;

	/**
	 * @param clazz
	 * @param matcher_
	 * @param provider_
	 */
	public EnumFinderComposite(Class<E> clazz, KeyMatcher<I, K> matcher_, KeyProvider<E, K> provider_) {
		enums = Arrays.asList(clazz.getEnumConstants());
		matcher = matcher_;
		provider = provider_;
	}

	/* (non-Javadoc)
	 * @see lazyeye.enumHelpers.finder.core.EnumFinder#find(java.lang.Object, java.lang.Enum)
	 */
	public E find(I input, E defaultValue) {
		if (input != null) {
			for (E enum_ : enums) {
				if (matcher.matches(input, provider.key(enum_))) {
					return enum_;
				}
			}
		}
		return defaultValue;
	}

	/* (non-Javadoc)
	 * @see lazyeye.enumHelpers.finder.core.EnumFinder#find(java.lang.Object)
	 */
	public E find(I input) {
		return find(input, null);
	}

}
