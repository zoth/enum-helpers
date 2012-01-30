package lazyeye.enumHelpers.finder.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.EnumMap;
import java.util.Map;

import lazyeye.enumHelpers.finder.EnumCoding;
import lazyeye.enumHelpers.finder.core.strategy.MatcherStrategy;

public class AnnotatedCodedEnumFinder<E extends Enum<E>, C, I> implements
		EnumFinder<E, I>, EnumFinderCoding<E, C> {

	private MatcherStrategy<I, C> matcher;
	private Map<E, C> codesMap;

	@SuppressWarnings("unchecked")
	public AnnotatedCodedEnumFinder(Class<E> enumClass, Class<C> codeClass,
			String tag, MatcherStrategy<I, C> matcher_){
		matcher = matcher_;
		codesMap = new EnumMap<E, C>(enumClass);
		
		boolean found = false;
		for (Method method : enumClass.getDeclaredMethods()) {

			EnumCoding enumCoding = method.getAnnotation(EnumCoding.class);
			if (enumCoding != null && enumCoding.value().equals(tag)) {
				if (found) {
					throw new IllegalArgumentException(
							"only one method can be annotated with same tag value");
				}
				found = true;
				if (!method.isAccessible()) {
					method.setAccessible(true);
				}
				if (method.getTypeParameters().length != 0) {
					throw new IllegalArgumentException(
							"annotated method cannot have parameters");
				}
				for (E enum_ : enumClass.getEnumConstants()) {
					Object obj;
					try {
						obj = method.invoke(enum_);
					}  catch (IllegalAccessException e) {
						throw new RuntimeException(e);
					} catch (InvocationTargetException e) {
						throw new RuntimeException(e);
					}
					if (obj != null && !obj.getClass().isAssignableFrom(codeClass)) {
						throw new IllegalArgumentException(
								"annotated method not returning value of type "
										+ codeClass.getName());
					}
					codesMap.put(enum_, (C)obj);
				}
			}
		}
		if (!found) {
			throw new IllegalArgumentException(
					"no method is annotated with tag value " + tag);
		}
	}


	public E find(I input, E defaultValue) {
		if (input != null) {
			for (E enum_ : codesMap.keySet()) {
				if (matcher.matches(input, codesMap.get(enum_))) {
					return enum_;
				}
			}
		}
		return defaultValue;
	}

	public E find(I input) {
		return find(input, null);
	}


	public C enumCoding(E enum_) {
		return codesMap.get(enum_);
	}

}
