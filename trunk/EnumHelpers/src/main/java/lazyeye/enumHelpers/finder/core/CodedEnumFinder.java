package lazyeye.enumHelpers.finder.core;

import java.util.Arrays;
import java.util.List;

import lazyeye.enumHelpers.finder.core.strategy.MatcherStrategy;

public class CodedEnumFinder<E extends Enum<E> & CodedEnum<C>, I, C> implements EnumFinder<E, I>, EnumFinderCoding<E, C> {

	private List<E> enums;
	private MatcherStrategy<I, C> matcher;

	public CodedEnumFinder(Class<E> clazz, MatcherStrategy<I, C> matcher_) {
		enums = Arrays.asList(clazz.getEnumConstants());
		matcher = matcher_;
	}

	public E find(I input, E defaultValue) {
		if (input != null) {
			for (E enum_ : enums) {
				if (matcher.matches(input, enum_.finderCode())) {
					return enum_;
				}
			}
		}
		return defaultValue;
	}

	public E find(I input) {
		return find(input, null);
	}

	public C enumCoding(E enum_) {
		return enum_.finderCode();
	}

}
