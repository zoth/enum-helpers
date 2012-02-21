package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.EnumFinder;
import lazyeye.enumHelpers.finder.core.EnumFinderFacade;

public class IntegerEnumFinder<E extends Enum<E>> extends EnumFinderFacade<E,Integer>{

	public IntegerEnumFinder(EnumFinder<E, Integer> f) {
		super(f);
	}
	

}
