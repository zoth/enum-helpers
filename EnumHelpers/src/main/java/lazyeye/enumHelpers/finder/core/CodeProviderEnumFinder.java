package lazyeye.enumHelpers.finder.core;


public class CodeProviderEnumFinder<E extends Enum<E> & FinderCodeInterface<C>, C> implements CodeProvider<E, C> {

	public C code(E enum_) {
		return enum_.finderCode();
	}

}
