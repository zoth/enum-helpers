package lazyeye.enumHelpers.finder.core;

public interface CodingFinder<E extends Enum<E>, C> {

	abstract C code(E enum_);

}