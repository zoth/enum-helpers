package lazyeye.enumHelpers.finder.core;

public interface CodeProvider<E extends Enum<E>, C> {

	abstract C code(E enum_);

}