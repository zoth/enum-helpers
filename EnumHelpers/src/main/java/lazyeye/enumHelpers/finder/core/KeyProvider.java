package lazyeye.enumHelpers.finder.core;

/**
 * @author Tom McGee
 * 
 * This is the interface defining the strategy used to find the key value in the target Enum.
 *
 * @param <E> target Enum type.
 * @param <K> key type.
 */
public interface KeyProvider<E extends Enum<E>, K> {

	/**
	 * @param enum_  target Enum.
	 * @return       key value.
	 */
	abstract K key(E enum_);

}