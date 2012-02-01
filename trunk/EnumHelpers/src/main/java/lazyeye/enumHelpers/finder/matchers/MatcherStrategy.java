package lazyeye.enumHelpers.finder.matchers;

public interface MatcherStrategy <I, K>{
	abstract boolean matches(I input, K key );
}
