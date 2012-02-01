package lazyeye.enumHelpers.finder.matchers;

public class EqualsMatcher<I, K> implements MatcherStrategy<I, K> {
	
	public boolean matches(I input, K key) {
		if(input == null){
			return key == null;
		}
		return input.equals(key);
	}

}
