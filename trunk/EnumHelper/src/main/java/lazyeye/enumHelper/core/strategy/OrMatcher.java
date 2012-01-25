package lazyeye.enumHelper.core.strategy;

public class OrMatcher<I, C> implements MatcherStrategy<I, C> {

	private MatcherStrategy<I, C> matcher1;
	private MatcherStrategy<I, C> matcher2;
	
	public OrMatcher(MatcherStrategy<I, C> m1, MatcherStrategy<I, C> m2){
		matcher1 = m1;
		matcher2 = m2;
	}
	
	public boolean matches(I input, C code) {
		return matcher1.matches(input, code) || matcher2.matches(input, code);
	}

}
