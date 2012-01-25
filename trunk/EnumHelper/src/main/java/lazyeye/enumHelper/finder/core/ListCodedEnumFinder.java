package lazyeye.enumHelper.finder.core;

import java.util.Arrays;
import java.util.List;

import lazyeye.enumHelper.finder.core.strategy.MatcherStrategy;


public class ListCodedEnumFinder <E extends Enum<E>, I, C> implements EnumFinder<E, I>{

	private MatcherStrategy<I,C> matcher;
	private E[] enums;
	private List<C> codes;
	
	public ListCodedEnumFinder(Class<E> clazz, MatcherStrategy<I,C> matcher_, C ... codes_){
		matcher = matcher_;
		enums = clazz.getEnumConstants();
		if(enums.length != codes_.length){
			throw new IllegalArgumentException("Enum constants size must match codes list size.");
		}
		codes = Arrays.asList(codes_);
	}
	
	public E find(I input, E defaultValue) {
		for(int i=0; i<codes.size(); ++i){
			if(matcher.matches(input, codes.get(i))){
				return enums[i];
			}
		}
		return defaultValue;
	}

	public E find(I input) {
		return find(input, null);
	}

}
