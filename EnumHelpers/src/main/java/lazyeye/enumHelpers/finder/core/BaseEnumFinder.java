package lazyeye.enumHelpers.finder.core;

import java.util.Arrays;
import java.util.List;

import lazyeye.enumHelpers.finder.matchers.MatcherStrategy;

public class BaseEnumFinder<E extends Enum<E>, I, K> implements EnumFinder<E, I> {

	private List<E> enums;
	private MatcherStrategy<I, K> matcher;
	private KeyProvider<E, K> keyFinder;

	public BaseEnumFinder(Class<E> clazz, MatcherStrategy<I, K> matcher_, KeyProvider<E, K> keyFinder_) {
		enums = Arrays.asList(clazz.getEnumConstants());
		matcher = matcher_;
		keyFinder = keyFinder_;
	}

	public E find(I input, E defaultValue) {
		if (input != null) {
			for (E enum_ : enums) {
				if (matcher.matches(input, keyFinder.key(enum_))) {
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
