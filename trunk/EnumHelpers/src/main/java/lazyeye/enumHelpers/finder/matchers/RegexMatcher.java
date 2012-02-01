package lazyeye.enumHelpers.finder.matchers;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import lazyeye.enumHelpers.finder.core.CodeProvider;

public class RegexMatcher<E extends Enum<E>> implements MatcherStrategy<String, String> {

	private Map<String,Pattern> patterns = null;
	Class<E> enumClass;
	
	public RegexMatcher(Class<E> clazz, CodeProvider<E,String> finder){
		enumClass = clazz;	
		setup(finder);
	}
	
	private void setup(CodeProvider<E,String> finder){
		patterns = new HashMap<String,Pattern>();
		for(E enum_:enumClass.getEnumConstants()){
			String code = finder.code(enum_);
			if(code != null && !patterns.containsKey(code)){
				patterns.put(code, Pattern.compile(code));
			}
		}
	}
	
	public boolean matches(String input, String code) {
		if(input == null || code == null || patterns == null){
			return false;
		}
		return  patterns.get(code).matcher(input).matches();
	}

}
