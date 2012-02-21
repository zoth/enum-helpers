package lazyeye.enumHelpers.finder.matchers;

import lazyeye.enumHelpers.finder.core.KeyMatcher;


public class EqualsIgnoreCaseMatcher implements KeyMatcher<String,String> {

	public boolean matches(String input, String key) {
		if(input == null){
			return key == null;
		}
		return input.equalsIgnoreCase(key);
	}

}
