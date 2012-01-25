package lazyeye.enumHelper.core.strategy;

public interface MatcherStrategy <I, C>{
	abstract boolean matches(I input, C code );
}
