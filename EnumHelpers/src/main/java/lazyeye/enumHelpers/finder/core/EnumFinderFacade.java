package lazyeye.enumHelpers.finder.core;


/**
 * @author Tom McGee
 *
 * EnumFinderFacade is a handy facade for EnumFinder to make the API simpler to use.
 * 
 * @param <E>
 * @param <I>
 */
public class EnumFinderFacade<E extends Enum<E>,I> {
	
	private EnumFinder<E,I> finder;
	
	/**
	 * @param f
	 */
	public EnumFinderFacade(EnumFinder<E,I> f){
		finder = f;
	}
	
	/**
	 * @param input
	 * @param defaultValue
	 * @return
	 */
	public E find(I input, E defaultValue){
		return finder.find(input, defaultValue);
	}

	/**
	 * @param input
	 * @return
	 */
	public E find(I input){
		return finder.find(input);
	}

}
