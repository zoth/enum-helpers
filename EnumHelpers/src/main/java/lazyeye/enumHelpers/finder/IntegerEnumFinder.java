package lazyeye.enumHelpers.finder;

import lazyeye.enumHelpers.finder.core.EnumFinder;

public class IntegerEnumFinder<E extends Enum<E>> {
	
	private EnumFinder<E,Integer> finder;
	
	public IntegerEnumFinder(EnumFinder<E,Integer> f){
		finder = f;
	}
	
	public E find(Integer input, E defaultValue){
		return finder.find(input, defaultValue);
	}

	public E find(Integer input){
		return finder.find(input);
	}

}
