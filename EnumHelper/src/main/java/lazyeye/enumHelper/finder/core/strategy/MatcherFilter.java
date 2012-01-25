package lazyeye.enumHelper.finder.core.strategy;

public abstract class MatcherFilter<I, C> implements MatcherStrategy<I, C> {
	private MatcherStrategy<I, C> matcher;
	
	public MatcherFilter(MatcherStrategy<I, C> m){
		matcher = m;
	}
	
	abstract I filterInput(I input);
	
	public boolean matches(I input, C code) {
		return matcher.matches(filterInput(input), code);
	}
}
