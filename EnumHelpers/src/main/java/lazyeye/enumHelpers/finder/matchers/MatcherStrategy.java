package lazyeye.enumHelpers.finder.matchers;

public interface MatcherStrategy <I, C>{
	abstract boolean matches(I input, C code );
}
