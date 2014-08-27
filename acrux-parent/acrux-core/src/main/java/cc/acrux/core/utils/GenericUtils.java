/**
 * 
 */
package cc.acrux.core.utils;

import java.lang.reflect.ParameterizedType;

/**
 * @author cunxin.gz
 * @param <T>
 *
 */
public class GenericUtils<T> {
	
	/**
	 * 获得制定索引位置的泛型参数
	 * @param src
	 * @param index
	 * @return
	 */
	public static Class<?> getGenericClass(Class<?> src, int index) {
		return (Class<?>) ((ParameterizedType) src.getGenericSuperclass()).getActualTypeArguments()[index];
	}
	
	/**
	 * 获得第一个泛型参数
	 * @param src
	 * @return
	 */
	public static Class<?> getGenericClass(Class<?> src) {
		return getGenericClass(src, 0);
	}
}
