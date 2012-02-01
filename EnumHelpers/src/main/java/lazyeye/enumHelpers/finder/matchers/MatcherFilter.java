package lazyeye.enumHelpers.finder.matchers;

public abstract class MatcherFilter<I, K> implements MatcherStrategy<I, K> {
	private MatcherStrategy<I, K> matcher;
	
	public MatcherFilter(MatcherStrategy<I, K> m){
		matcher = m;
	}
	
	abstract I filterInput(I input);
	
	public boolean matches(I input, K key) {
		return matcher.matches(filterInput(input), key);
	}
}
