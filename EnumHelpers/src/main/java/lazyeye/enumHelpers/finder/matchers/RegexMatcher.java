package lazyeye.enumHelpers.finder.matchers;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import lazyeye.enumHelpers.finder.core.KeyMatcher;
import lazyeye.enumHelpers.finder.core.KeyProvider;

public class RegexMatcher<E extends Enum<E>> implements KeyMatcher<String, String> {

	private Map<String,Pattern> patterns = null;
	Class<E> enumClass;
	
	public RegexMatcher(Class<E> clazz, KeyProvider<E,String> finder){
		enumClass = clazz;	
		setup(finder);
	}
	
	private void setup(KeyProvider<E,String> finder){
		patterns = new HashMap<String,Pattern>();
		for(E enum_:enumClass.getEnumConstants()){
			String key = finder.key(enum_);
			if(key != null && !patterns.containsKey(key)){
				patterns.put(key, Pattern.compile(key));
			}
		}
	}
	
	public boolean matches(String input, String key) {
		if(input == null || key == null || patterns == null){
			return false;
		}
		return  patterns.get(key).matcher(input).matches();
	}

}
