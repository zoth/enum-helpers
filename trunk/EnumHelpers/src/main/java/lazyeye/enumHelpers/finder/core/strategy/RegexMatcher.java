package lazyeye.enumHelpers.finder.core.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import lazyeye.enumHelpers.finder.core.CodedEnum;

public class RegexMatcher<E extends Enum<E> & CodedEnum<String>> implements MatcherStrategy<String, String> {

	private Map<String,Pattern> patterns = new HashMap<String,Pattern>();
	
	public RegexMatcher(Class<E> clazz){
		for(E enum_:clazz.getEnumConstants()){
			String code = enum_.finderCode();
			if(code != null && !patterns.containsKey(code)){
				patterns.put(code, Pattern.compile(code));
			}
		}
	}
	
	public boolean matches(String input, String code) {
		if(input == null || code == null){
			return false;
		}
		return  patterns.get(code).matcher(input).matches();
	}

}
