package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.CodedEnum;
import lazyeye.enumHelpers.finder.core.CodedEnumFinder;
import lazyeye.enumHelpers.finder.core.EnumFinder;
import lazyeye.enumHelpers.finder.core.OrdinalEnumFinder;
import lazyeye.enumHelpers.finder.core.StringCodedEnumFinder;
import lazyeye.enumHelpers.finder.core.strategy.EqualsIgnoreCaseMatcher;
import lazyeye.enumHelpers.finder.core.strategy.EqualsMatcher;
import lazyeye.enumHelpers.finder.core.strategy.IndexFinder;
import lazyeye.enumHelpers.finder.core.strategy.PostfixMatcher;
import lazyeye.enumHelpers.finder.core.strategy.PrefixMatcher;
import lazyeye.enumHelpers.finder.core.strategy.RegexMatcher;

public class EnumFinderFactory {

	public static <E extends Enum<E> & CodedEnum<I>,I> CodedEnumFinder<E,I,I> equalsFinder(
			Class<E> clazz) {
		return new CodedEnumFinder<E,I,I>(clazz,
				new EqualsMatcher<I, I>());
	}

	public static <E extends Enum<E> & CodedEnum<String>> EnumFinder<E,String> equalsIgnoreCaseFinder(
			Class<E> clazz) {
		return new StringCodedEnumFinder<E>(clazz,
				new EqualsIgnoreCaseMatcher());
	}

	public static <E extends Enum<E> & CodedEnum<String>> EnumFinder<E,String> prefixFinder(
			Class<E> clazz) {
		return new StringCodedEnumFinder<E>(clazz,
				new PrefixMatcher());
	}

	public static <E extends Enum<E> & CodedEnum<String>> EnumFinder<E,String> postfixFinder(
			Class<E> clazz) {
		return new StringCodedEnumFinder<E>(clazz,
				new PostfixMatcher());
	}

	public static <E extends Enum<E> & CodedEnum<String>> EnumFinder<E,String> regexFinder(
			Class<E> clazz) {
		return new StringCodedEnumFinder<E>(clazz,
				new RegexMatcher<E>(clazz));
	}

	public static <E extends Enum<E>> EnumFinder<E, Integer> ordinalFinder(
			Class<E> clazz) {
		return new OrdinalEnumFinder<E, Integer>(clazz,
				new IndexFinder<Integer>() {
					public int findIndex(Integer input) {
						if (input == null) {
							return -1;
						}
						return input.intValue();
					}
				});
	}

}