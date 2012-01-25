package lazyeye.enumHelper.core.strategy;

public class ToUpperMatcherFilter<C> extends MatcherFilter<String, C> {

	public ToUpperMatcherFilter(MatcherStrategy<String, C> m) {
		super(m);
	}

	String filterInput(String input) {
		if(input != null){
			return input.toUpperCase();
		}
		return null;
	}

}
