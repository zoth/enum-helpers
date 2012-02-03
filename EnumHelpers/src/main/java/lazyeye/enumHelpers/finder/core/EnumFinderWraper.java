package lazyeye.enumHelpers.finder.core;


public class EnumFinderWraper<E extends Enum<E>,I> {
	
	private EnumFinder<E,I> finder;
	
	public EnumFinderWraper(EnumFinder<E,I> f){
		finder = f;
	}
	
	public E find(I input, E defaultValue){
		return finder.find(input, defaultValue);
	}

	public E find(I input){
		return finder.find(input);
	}

}
