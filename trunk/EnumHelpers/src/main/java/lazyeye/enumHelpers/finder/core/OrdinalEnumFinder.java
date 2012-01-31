package lazyeye.enumHelpers.finder.core;


public class OrdinalEnumFinder<E extends Enum<E>,I> implements EnumFinder<E, I> {

	private IndexFinder<I> indexFinder;
	private E[] enums;
	
	public OrdinalEnumFinder(Class<E> clazz, IndexFinder<I> indexFinder_){
		indexFinder = indexFinder_;
		enums = clazz.getEnumConstants();
	}
	
	public E find(I input, E defaultValue){
		int index = indexFinder.findIndex(input);
		if(index >= 0 && index < enums.length){
			return enums[index];
		}
		return defaultValue;
	}
	
	public E find(I input){
		return find(input, null);
	}
}
