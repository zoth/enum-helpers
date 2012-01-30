package lazyeye.enumHelpers.finder.core;

public interface EnumFinderCoding<E extends Enum<E>, C> {

	abstract C enumCoding(E enum_);

}