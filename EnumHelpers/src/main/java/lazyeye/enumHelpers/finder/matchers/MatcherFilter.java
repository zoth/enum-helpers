package lazyeye.enumHelpers.finder.matchers;

import lazyeye.enumHelpers.finder.core.KeyMatcher;

public abstract class MatcherFilter<I, K> implements KeyMatcher<I, K> {
	private KeyMatcher<I, K> matcher;
	
	public MatcherFilter(KeyMatcher<I, K> m){
		matcher = m;
	}
	
	abstract I filterInput(I input);
	
	public boolean matches(I input, K key) {
		return matcher.matches(filterInput(input), key);
	}
}
