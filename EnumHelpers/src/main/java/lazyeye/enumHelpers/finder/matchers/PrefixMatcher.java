package lazyeye.enumHelpers.finder.matchers;

import lazyeye.enumHelpers.finder.core.KeyMatcher;

public class PrefixMatcher implements KeyMatcher<String, String> {

	public boolean matches(String input, String key) {
		if(input == null || key == null){
			return false;
		}
		return input.startsWith(key);
	}

}
