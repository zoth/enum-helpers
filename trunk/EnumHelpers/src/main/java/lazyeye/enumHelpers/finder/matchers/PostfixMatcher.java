package lazyeye.enumHelpers.finder.matchers;

public class PostfixMatcher implements MatcherStrategy<String, String> {

	public boolean matches(String input, String code) {
		if(input == null || code == null){
			return false;
		}
		return input.endsWith(code);
	}

}