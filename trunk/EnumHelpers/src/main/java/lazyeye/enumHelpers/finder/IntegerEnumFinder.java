package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.EnumFinder;
import lazyeye.enumHelpers.finder.core.EnumFinderFacade;

/**
 * @author Tom McGee
 *
 * @param <E>
 */
public class IntegerEnumFinder<E extends Enum<E>> extends EnumFinderFacade<E,Integer>{

	/**
	 * @param f
	 */
	public IntegerEnumFinder(EnumFinder<E, Integer> f) {
		super(f);
	}
	

}
