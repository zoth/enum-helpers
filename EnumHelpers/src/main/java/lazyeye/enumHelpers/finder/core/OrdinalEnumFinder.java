package lazyeye.enumHelpers.finder.core;


public class OrdinalEnumFinder<E extends Enum<E>,I> implements EnumFinder<E, I> {

	private IndexProvider<I> indexProvider;
	private E[] enums;
	
	public OrdinalEnumFinder(Class<E> clazz, IndexProvider<I> indexProvider_){
		indexProvider = indexProvider_;
		enums = clazz.getEnumConstants();
	}
	
	public E find(I input, E defaultValue){
		int index = indexProvider.index(input);
		if(index >= 0 && index < enums.length){
			return enums[index];
		}
		return defaultValue;
	}
	
	public E find(I input){
		return find(input, null);
	}
}
