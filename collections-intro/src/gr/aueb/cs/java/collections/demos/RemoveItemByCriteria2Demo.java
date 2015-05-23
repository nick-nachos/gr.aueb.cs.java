package gr.aueb.cs.java.collections.demos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import gr.aueb.cs.java.collections.Demo;
import gr.aueb.cs.java.collections.util.CollectionExtensions;
import gr.aueb.cs.java.collections.util.Predicate;

public final class RemoveItemByCriteria2Demo implements Demo {

	private static final String DESCRIPTION = "Remove a single item from a collection, based on some criteria (uses the generic based util function 'selectSingle').";
	
	private boolean stringMatches(String obj) {
		return obj.length() > 1;
	}
	
	@Override
	public void run() {
		Collection<String> items = new ArrayList<>(Arrays.asList("a", "aa", "aaa"));
		Predicate<String> predicate = new Predicate<String>() {

			@Override
			public boolean matches(String obj) {
				return stringMatches(obj);
			}
			
		};
		String itemToRemove = CollectionExtensions.selectSingle(items, predicate);
		
		if (itemToRemove != null) {
			System.out.println("Before removal: " + items);
			System.out.println("Item to remove: " + itemToRemove);
			items.remove(itemToRemove);
			System.out.println("After removal: " + items);
		}
		else {
			System.out.println("No items to remove");
		}
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

}
