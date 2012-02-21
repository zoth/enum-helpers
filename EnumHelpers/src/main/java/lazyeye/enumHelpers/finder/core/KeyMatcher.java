package lazyeye.enumHelpers.finder.core;

/**
 * @author fitmcgee
 *
 * @param <I>
 * @param <K>
 */
public interface KeyMatcher <I, K>{
	/**
	 * @param input
	 * @param key
	 * @return
	 */
	abstract boolean matches(I input, K key );
}
