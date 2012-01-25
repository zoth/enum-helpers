package lazyeye.enumHelper;

import lazyeye.enumHelper.core.CodedEnum;
import lazyeye.enumHelper.core.EnumFinder;

public interface StringEnumFinder<E extends Enum<E> & CodedEnum<String>> extends EnumFinder<E, String>{

}