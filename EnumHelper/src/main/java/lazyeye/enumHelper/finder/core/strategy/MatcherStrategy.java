package lazyeye.enumHelper.finder.core.strategy;

public interface MatcherStrategy <I, C>{
	abstract boolean matches(I input, C code );
}
