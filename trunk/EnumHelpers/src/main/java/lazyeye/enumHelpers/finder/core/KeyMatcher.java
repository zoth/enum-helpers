package lazyeye.enumHelpers.finder.core;

/**
 * @author Tom McGee
 *
 * This is the interface defining the strategy used to test for a match between the input and the key.
 * 
 * @param <I>  input type.
 * @param <K>  key type.
 */
public interface KeyMatcher <I, K>{
	/**
	 * @param input  input value to test. 
	 * @param key    key value to test.
	 * @return       true if match, false if no match.
	 */
	abstract boolean matches(I input, K key );
}
