package lazyeye.enumHelpers.finder.matchers;


public class EqualsIgnoreCaseMatcher implements MatcherStrategy<String,String> {

	public boolean matches(String input, String key) {
		if(input == null){
			return key == null;
		}
		return input.equalsIgnoreCase(key);
	}

}
