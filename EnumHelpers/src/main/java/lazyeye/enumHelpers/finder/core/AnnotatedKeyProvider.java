package lazyeye.enumHelpers.finder.core;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.EnumMap;
import java.util.Map;

import lazyeye.enumHelpers.finder.EnumFinderKey;

/**
 * @author Tom McGee
 *
 * @param <E> target Enum type.
 * @param <K> key type.
 */
public class AnnotatedKeyProvider<E extends Enum<E>, K> implements KeyProvider<E, K> {

	private Map<E, K> keysMap;

	/**
	 * 
	 * 
	 * 
	 * @param enumClass   class of target Enum.
	 * @param keyClass    class of key.
	 * @param tag         identifying value for annotation.
	 */
	@SuppressWarnings("unchecked")
	public AnnotatedKeyProvider(Class<E> enumClass, Class<K> keyClass,
			String tag){
		keysMap = new EnumMap<E, K>(enumClass);
		
		boolean found = false;
		for(Field field:enumClass.getDeclaredFields()){
			EnumFinderKey enumCoding = field.getAnnotation(EnumFinderKey.class);
			if (enumCoding != null && enumCoding.value().equals(tag)) {
				if (found) {
					throw new IllegalArgumentException(
							"only one field or method can be annotated with same tag value");
				}
				found = true;
				if (!field.isAccessible()) {			
					field.setAccessible(true);
				}
				for (E enum_ : enumClass.getEnumConstants()) {
					if(!field.getType().isAssignableFrom(keyClass)){
						throw new IllegalArgumentException(
								"annotated field not of type "
										+ keyClass.getName());
					}
					try {
						Object obj = field.get(enum_);
						keysMap.put(enum_, (K)obj);
					}  catch (IllegalAccessException e) {
						throw new RuntimeException(e);
					}
					
				}
			}			
		}
		
		
		
		for (Method method : enumClass.getDeclaredMethods()) {

			EnumFinderKey enumCoding = method.getAnnotation(EnumFinderKey.class);
			if (enumCoding != null && enumCoding.value().equals(tag)) {
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
					if(!method.getReturnType().isAssignableFrom(keyClass)){
						throw new IllegalArgumentException(
								"annotated method not returning value of type "
										+ keyClass.getName());
					}
					try {
						Object obj = method.invoke(enum_);
						keysMap.put(enum_, (K)obj);
					}  catch (IllegalAccessException e) {
						throw new RuntimeException(e);
					} catch (InvocationTargetException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
		if (!found) {
			throw new IllegalArgumentException(
					"no method is annotated with id value " + tag);
		}
	}
	

	/* (non-Javadoc)
	 * @see lazyeye.enumHelpers.finder.core.KeyProvider#key(java.lang.Enum)
	 */
	public K key(E enum_) {
		return keysMap.get(enum_);
	}

}
