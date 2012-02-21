package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.EnumFinder;
import lazyeye.enumHelpers.finder.core.EnumFinderFacade;

/**
 * @author Tom McGee
 *
 * @param <E>
 */
public class StringEnumFinder<E extends Enum<E>> extends EnumFinderFacade<E,String>{

	public StringEnumFinder(EnumFinder<E, String> f) {
		super(f);
	}

}
