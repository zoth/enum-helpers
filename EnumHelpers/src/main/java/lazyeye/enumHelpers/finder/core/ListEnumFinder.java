package lazyeye.enumHelpers.finder.core;

import java.util.Arrays;
import java.util.List;

import lazyeye.enumHelpers.finder.core.strategy.MatcherStrategy;

public class ListEnumFinder<E extends Enum<E>, I, C> implements EnumFinder<E,I>, EnumFinderCoding<E, C> {

	private MatcherStrategy<I, C> matcher;
	private List<E> enums;
	private List<C> codes;

	public ListEnumFinder(Class<E> clazz, MatcherStrategy<I, C> matcher_,
			C... codes_) {
		matcher = matcher_;
		enums = Arrays.asList(clazz.getEnumConstants());
		if (enums.size() != codes_.length) {
			throw new IllegalArgumentException(
					"Enum constants size must match codes list size.");
		}
		codes = Arrays.asList(codes_);
	}

	public E find(I input, E defaultValue) {
		for (int i = 0; i < codes.size(); ++i) {
			if (matcher.matches(input, codes.get(i))) {
				return enums.get(i);
			}
		}
		return defaultValue;
	}

	public E find(I input) {
		return find(input, null);
	}

	public C enumCoding(E enum_) {
		return codes.get(enums.indexOf(enum_));
	}

}
