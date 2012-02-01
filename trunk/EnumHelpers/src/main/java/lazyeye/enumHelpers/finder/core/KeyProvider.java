package lazyeye.enumHelpers.finder.core;

public interface KeyProvider<E extends Enum<E>, K> {

	abstract K key(E enum_);

}