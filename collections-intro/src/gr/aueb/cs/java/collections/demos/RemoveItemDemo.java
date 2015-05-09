package gr.aueb.cs.java.collections.demos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import gr.aueb.cs.java.collections.Demo;

public final class RemoveItemDemo implements Demo {

	private static final String DESCRIPTION = "Remove a single item a from collection.";
	
	@Override
	public void run() {
		Collection<Integer> items = new ArrayList<>(Arrays.asList(6, 4, 2, 1, 5, 6));
		int itemToRemove = 6;
		System.out.println("Before removal: " + items);
		System.out.println("Item to remove: " + itemToRemove);
		items.remove(itemToRemove);
		System.out.println("After removal: " + items);
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

}
