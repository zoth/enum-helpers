package lazyeye.enumHelpers.finder.core.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import lazyeye.enumHelpers.finder.core.EnumFinderCoding;

public class RegexMatcher<E extends Enum<E>> implements MatcherStrategy<String, String> {

	private Map<String,Pattern> patterns = null;
	Class<E> enumClass;
	
	public RegexMatcher(Class<E> clazz){
		enumClass = clazz;		
	}
	
	public void setup(EnumFinderCoding<E,String> finder){
		patterns = new HashMap<String,Pattern>();
		for(E enum_:enumClass.getEnumConstants()){
			String code = finder.enumCoding(enum_);
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
