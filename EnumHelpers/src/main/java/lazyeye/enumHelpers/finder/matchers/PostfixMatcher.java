package lazyeye.enumHelpers.finder.matchers;

public class PostfixMatcher implements MatcherStrategy<String, String> {

	public boolean matches(String input, String key) {
		if(input == null || key == null){
			return false;
		}
		return input.endsWith(key);
	}

}
