package lazyeye.enumHelpers.finder.core;


/**
 * @author Tom McGee
 *
 * @param <E>
 * @param <I>
 */
public class OrdinalEnumFinder<E extends Enum<E>,I> implements EnumFinder<E, I> {

	private IndexProvider<I> indexProvider;
	private E[] enums;
	
	/**
	 * @param clazz
	 * @param indexProvider_
	 */
	public OrdinalEnumFinder(Class<E> clazz, IndexProvider<I> indexProvider_){
		indexProvider = indexProvider_;
		enums = clazz.getEnumConstants();
	}
	
	/* (non-Javadoc)
	 * @see lazyeye.enumHelpers.finder.core.EnumFinder#find(java.lang.Object, java.lang.Enum)
	 */
	public E find(I input, E defaultValue){
		int index = indexProvider.index(input);
		if(index >= 0 && index < enums.length){
			return enums[index];
		}
		return defaultValue;
	}
	
	/* (non-Javadoc)
	 * @see lazyeye.enumHelpers.finder.core.EnumFinder#find(java.lang.Object)
	 */
	public E find(I input){
		return find(input, null);
	}
}
