package lazyeye.enumHelpers.finder.core;

import java.util.Arrays;
import java.util.List;

import lazyeye.enumHelpers.finder.matchers.MatcherStrategy;

public class BaseEnumFinder<E extends Enum<E>, I, C> implements EnumFinder<E, I> {

	private List<E> enums;
	private MatcherStrategy<I, C> matcher;
	private CodeProvider<E, C> codeFinder;

	public BaseEnumFinder(Class<E> clazz, MatcherStrategy<I, C> matcher_, CodeProvider<E, C> codeFinder_) {
		enums = Arrays.asList(clazz.getEnumConstants());
		matcher = matcher_;
		codeFinder = codeFinder_;
	}

	public E find(I input, E defaultValue) {
		if (input != null) {
			for (E enum_ : enums) {
				if (matcher.matches(input, codeFinder.code(enum_))) {
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
