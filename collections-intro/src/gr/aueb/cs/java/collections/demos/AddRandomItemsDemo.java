package gr.aueb.cs.java.collections.demos;

import gr.aueb.cs.java.collections.Demo;

import java.util.ArrayList;
import java.util.Collection;

public final class AddRandomItemsDemo implements Demo {

	private static final String DESCRIPTION = "Create random number of integers in a list.";
	
	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
	
	@Override
	public void run() {
		Collection<Integer> items = new ArrayList<>();
		int itemCount = this.generateItemCount();
		
		for (int i = 0; i < itemCount; i++) {
			items.add(i);
		}
		
		System.out.println(items);
		System.out.println("Item count: " + items.size());
	}

	private int generateItemCount() {
		return (int) Math.round(1 + Math.random() * 10);
	}
	
}
