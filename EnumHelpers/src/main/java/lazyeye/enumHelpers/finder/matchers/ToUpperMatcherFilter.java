package lazyeye.enumHelpers.finder.matchers;

import lazyeye.enumHelpers.finder.core.KeyMatcher;

public class ToUpperMatcherFilter<K> extends MatcherFilter<String, K> {

	public ToUpperMatcherFilter(KeyMatcher<String, K> m) {
		super(m);
	}

	String filterInput(String input) {
		if(input != null){
			return input.toUpperCase();
		}
		return null;
	}

}
