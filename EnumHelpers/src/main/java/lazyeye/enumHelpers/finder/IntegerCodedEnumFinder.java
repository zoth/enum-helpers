package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.CodedEnum;
import lazyeye.enumHelpers.finder.core.EnumFinder;

public interface IntegerCodedEnumFinder<E extends Enum<E> & CodedEnum<Integer>> extends EnumFinder<E, Integer>{

}