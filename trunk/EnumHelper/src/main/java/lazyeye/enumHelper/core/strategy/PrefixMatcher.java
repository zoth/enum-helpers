package lazyeye.enumHelper.core.strategy;

public class PrefixMatcher implements MatcherStrategy<String, String> {

	public boolean matches(String input, String code) {
		if(input == null || code == null){
			return false;
		}
		return input.startsWith(code);
	}

}
