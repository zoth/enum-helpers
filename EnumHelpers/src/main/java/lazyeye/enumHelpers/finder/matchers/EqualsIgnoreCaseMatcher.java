package lazyeye.enumHelpers.finder.matchers;


public class EqualsIgnoreCaseMatcher implements MatcherStrategy<String,String> {

	public boolean matches(String input, String code) {
		if(input == null){
			return code == null;
		}
		return input.equalsIgnoreCase(code);
	}

}
