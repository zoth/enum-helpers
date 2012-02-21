package lazyeye.enumHelpers.finder.core;

import java.util.Arrays;
import java.util.List;


public class EnumFinderComposite<E extends Enum<E>, I, K> implements EnumFinder<E, I> {

	private List<E> enums;
	private KeyMatcher<I, K> matcher;
	private KeyProvider<E, K> provider;

	public EnumFinderComposite(Class<E> clazz, KeyMatcher<I, K> matcher_, KeyProvider<E, K> provider_) {
		enums = Arrays.asList(clazz.getEnumConstants());
		matcher = matcher_;
		provider = provider_;
	}

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

	public E find(I input) {
		return find(input, null);
	}

}
