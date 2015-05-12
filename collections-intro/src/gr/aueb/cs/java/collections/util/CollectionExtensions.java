package gr.aueb.cs.java.collections.util;

import java.util.ArrayList;
import java.util.Collection;

public final class CollectionExtensions {

	private CollectionExtensions() { }
	
	public static <T> Collection<T> selectMany(Iterable<T> source, Predicate<T> predicate) {
		Collection<T> result = new ArrayList<>();
		
		for (T obj : source) {
			if (predicate.matches(obj)) {
				result.add(obj);
			}
		}
		
		return result;
	}
	
	public static <T> T selectSingle(Iterable<T> source, Predicate<T> predicate) {
		for (T obj : source) {
			if (predicate.matches(obj)) {
				return obj;
			}
		}
		
		return null;
	}
}
