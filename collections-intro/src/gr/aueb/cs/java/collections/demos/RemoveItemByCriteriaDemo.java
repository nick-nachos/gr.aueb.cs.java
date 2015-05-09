package gr.aueb.cs.java.collections.demos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import gr.aueb.cs.java.collections.Demo;

public final class RemoveItemByCriteriaDemo implements Demo {

	private static final String DESCRIPTION = "Remove a single item from a collection, based on some criteria.";
	
	@Override
	public void run() {
		Collection<String> items = new ArrayList<>(Arrays.asList("a", "aa", "aaa"));
		String itemToRemove = null;
		
		for (String item : items) {
			if (item.length() > 1) {
				itemToRemove = item;
				break;
			}
		}
		
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
