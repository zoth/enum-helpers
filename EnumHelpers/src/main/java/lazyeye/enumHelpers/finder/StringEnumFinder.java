package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.CodedEnum;
import lazyeye.enumHelpers.finder.core.EnumFinder;

public interface StringEnumFinder<E extends Enum<E> & CodedEnum<String>> extends EnumFinder<E, String>{

}