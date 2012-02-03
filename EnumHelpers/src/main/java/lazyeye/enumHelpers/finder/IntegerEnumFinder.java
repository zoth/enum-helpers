package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.EnumFinder;
import lazyeye.enumHelpers.finder.core.EnumFinderWraper;

public class IntegerEnumFinder<E extends Enum<E>> extends EnumFinderWraper<E,Integer>{

	public IntegerEnumFinder(EnumFinder<E, Integer> f) {
		super(f);
	}
	

}
