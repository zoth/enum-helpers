package lazyeye.enumHelpers.finder.core;

/**
 * @author Tom McGee
 *
 * @param <E>
 * @param <K>
 */
public interface KeyProvider<E extends Enum<E>, K> {

	/**
	 * @param enum_
	 * @return
	 */
	abstract K key(E enum_);

}