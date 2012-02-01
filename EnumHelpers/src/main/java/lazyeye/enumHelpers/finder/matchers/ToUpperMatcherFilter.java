package lazyeye.enumHelpers.finder.matchers;

public class ToUpperMatcherFilter<K> extends MatcherFilter<String, K> {

	public ToUpperMatcherFilter(MatcherStrategy<String, K> m) {
		super(m);
	}

	String filterInput(String input) {
		if(input != null){
			return input.toUpperCase();
		}
		return null;
	}

}
