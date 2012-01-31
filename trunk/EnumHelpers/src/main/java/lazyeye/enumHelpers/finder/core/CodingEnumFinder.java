package lazyeye.enumHelpers.finder.core;


public class CodingEnumFinder<E extends Enum<E> & CodingTag<C>, C> implements CodingFinder<E, C> {

	public C code(E enum_) {
		return enum_.finderCode();
	}

}
