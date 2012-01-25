package lazyeye.enumHelper.core.strategy;

public class EqualsMatcher<I, C> implements MatcherStrategy<I, C> {
	
	public boolean matches(I input, C code) {
		if(input == null){
			return code == null;
		}
		return input.equals(code);
	}

}
