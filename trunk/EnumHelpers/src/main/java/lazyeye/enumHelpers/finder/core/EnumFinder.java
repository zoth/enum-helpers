package lazyeye.enumHelpers.finder.core;

public interface EnumFinder<E extends Enum<E>, I> {

	public abstract E find(I input, E defaultValue);

	public abstract E find(I input);

}