package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.EnumFinder;

public class StringEnumFinder<E extends Enum<E>> {
	
	private EnumFinder<E,String> finder;
	
	public StringEnumFinder(EnumFinder<E,String> f){
		finder = f;
	}
	
	public E find(String input, E defaultValue){
		return finder.find(input, defaultValue);
	}

	public E find(String input){
		return finder.find(input);
	}

}
