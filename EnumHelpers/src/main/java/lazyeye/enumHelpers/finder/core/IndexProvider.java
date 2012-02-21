package lazyeye.enumHelpers.finder.core;

/**
 * @author Tom McGee
 *
 * @param <I>
 */
public interface IndexProvider<I> {
	
	/**
	 * @param input
	 * @return
	 */
	abstract int index(I input);
	
}
