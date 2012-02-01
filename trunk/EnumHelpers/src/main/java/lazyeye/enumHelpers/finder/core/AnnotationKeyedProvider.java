package lazyeye.enumHelpers.finder.core;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.EnumMap;
import java.util.Map;

import lazyeye.enumHelpers.finder.EnumFinderKey;

public class AnnotationKeyedProvider<E extends Enum<E>, C> implements KeyProvider<E, C> {

	private Map<E, C> codesMap;

	@SuppressWarnings("unchecked")
	public AnnotationKeyedProvider(Class<E> enumClass, Class<C> codeClass,
			String annotatedId){
		codesMap = new EnumMap<E, C>(enumClass);
		
		boolean found = false;
		for(Field field:enumClass.getDeclaredFields()){
			EnumFinderKey enumCoding = field.getAnnotation(EnumFinderKey.class);
			if (enumCoding != null && enumCoding.value().equals(annotatedId)) {
				if (found) {
					throw new IllegalArgumentException(
							"only one field or method can be annotated with same tag value");
				}
				found = true;
				if (!field.isAccessible()) {			
					field.setAccessible(true);
				}
				for (E enum_ : enumClass.getEnumConstants()) {
					if(!field.getType().isAssignableFrom(codeClass)){
						throw new IllegalArgumentException(
								"annotated field not of type "
										+ codeClass.getName());
					}
					try {
						Object obj = field.get(enum_);
						codesMap.put(enum_, (C)obj);
					}  catch (IllegalAccessException e) {
						throw new RuntimeException(e);
					}
					
				}
			}			
		}
		
		
		
		for (Method method : enumClass.getDeclaredMethods()) {

			EnumFinderKey enumCoding = method.getAnnotation(EnumFinderKey.class);
			if (enumCoding != null && enumCoding.value().equals(annotatedId)) {
				if (found) {
					throw new IllegalArgumentException(
							"only one field or method can be annotated with same tag value");
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
					if(!method.getReturnType().isAssignableFrom(codeClass)){
						throw new IllegalArgumentException(
								"annotated method not returning value of type "
										+ codeClass.getName());
					}
//					Object obj;
					try {
						Object obj = method.invoke(enum_);
						codesMap.put(enum_, (C)obj);
					}  catch (IllegalAccessException e) {
						throw new RuntimeException(e);
					} catch (InvocationTargetException e) {
						throw new RuntimeException(e);
					}
//					if (obj != null && !obj.getClass().isAssignableFrom(codeClass)) {
//						throw new IllegalArgumentException(
//								"annotated method not returning value of type "
//										+ codeClass.getName());
//					}
				//	codesMap.put(enum_, (C)obj);
				}
			}
		}
		if (!found) {
			throw new IllegalArgumentException(
					"no method is annotated with id value " + annotatedId);
		}
	}
	

	public C key(E enum_) {
		return codesMap.get(enum_);
	}

}
