package lazyeye.enumHelpers.finder.matchers;

import lazyeye.enumHelpers.finder.core.KeyMatcher;

public class EqualsMatcher<I, K> implements KeyMatcher<I, K> {
	
	public boolean matches(I input, K key) {
		if(input == null){
			return key == null;
		}
		return input.equals(key);
	}

}
