package lazyeye.enumHelpers.finder.matchers;

import lazyeye.enumHelpers.finder.core.KeyMatcher;

public class OrMatcher<I, K> implements KeyMatcher<I, K> {

	private KeyMatcher<I, K> matcher1;
	private KeyMatcher<I, K> matcher2;
	
	public OrMatcher(KeyMatcher<I, K> m1, KeyMatcher<I, K> m2){
		matcher1 = m1;
		matcher2 = m2;
	}
	
	public boolean matches(I input, K key) {
		return matcher1.matches(input, key) || matcher2.matches(input, key);
	}

}
