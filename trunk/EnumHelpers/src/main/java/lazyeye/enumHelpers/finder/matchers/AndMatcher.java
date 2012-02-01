package lazyeye.enumHelpers.finder.matchers;


public class AndMatcher<I, K> implements MatcherStrategy<I, K> {

	private MatcherStrategy<I, K> matcher1;
	private MatcherStrategy<I, K> matcher2;
	
	public AndMatcher(MatcherStrategy<I, K> m1, MatcherStrategy<I, K> m2){
		matcher1 = m1;
		matcher2 = m2;
	}
	
	public boolean matches(I input, K key) {
		return matcher1.matches(input, key) && matcher2.matches(input, key);
	}

}
