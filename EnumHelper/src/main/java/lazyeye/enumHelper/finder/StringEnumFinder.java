package lazyeye.enumHelper.finder;

import lazyeye.enumHelper.finder.core.CodedEnum;
import lazyeye.enumHelper.finder.core.EnumFinder;

public interface StringEnumFinder<E extends Enum<E> & CodedEnum<String>> extends EnumFinder<E, String>{

}