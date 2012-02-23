package lazyeye.enumHelpers.finder.core;

/**
 * @author Tom McGee
 * 
 * This is the interface defining the strategy used to obtain an index value from an input value.
 *
 * @param <I>  type of input.
 */
public interface IndexProvider<I> {
	
	/**
	 * @param input   the input value used to obtain the index.
	 * @return        obtain index.
	 */
	abstract int index(I input);
	
}
