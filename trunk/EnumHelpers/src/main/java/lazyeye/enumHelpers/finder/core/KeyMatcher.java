package lazyeye.enumHelpers.finder.core;

public interface KeyMatcher <I, K>{
	abstract boolean matches(I input, K key );
}
