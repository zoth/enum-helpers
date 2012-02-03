package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.EnumFinder;
import lazyeye.enumHelpers.finder.core.EnumFinderWraper;

public class StringEnumFinder<E extends Enum<E>> extends EnumFinderWraper<E,String>{

	public StringEnumFinder(EnumFinder<E, String> f) {
		super(f);
	}

}
