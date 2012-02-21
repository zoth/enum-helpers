package lazyeye.enumHelpers.finder.core;

/**
 * @author Tom McGee
 *
 * @param <E>
 * @param <I>
 */
public interface EnumFinder<E extends Enum<E>, I> {

	/**
	 * @param input
	 * @param defaultValue
	 * @return
	 */
	public abstract E find(I input, E defaultValue);

	/**
	 * @param input
	 * @return
	 */
	public abstract E find(I input);

}