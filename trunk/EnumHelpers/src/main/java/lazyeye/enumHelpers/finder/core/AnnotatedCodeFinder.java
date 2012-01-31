package lazyeye.enumHelpers.finder.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.EnumMap;
import java.util.Map;

import lazyeye.enumHelpers.finder.EnumCoding;

public class AnnotatedCodeFinder<E extends Enum<E>, C> implements CodingFinder<E, C> {

	private Map<E, C> codesMap;

	@SuppressWarnings("unchecked")
	public AnnotatedCodeFinder(Class<E> enumClass, Class<C> codeClass,
			String tag){
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

	public C code(E enum_) {
		return codesMap.get(enum_);
	}

}
