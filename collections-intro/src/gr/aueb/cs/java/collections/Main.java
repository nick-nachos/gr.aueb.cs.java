package gr.aueb.cs.java.collections;

import gr.aueb.cs.java.collections.demos.*;
import gr.aueb.cs.java.collections.io.InputParseResult;
import gr.aueb.cs.java.collections.io.InputReadUtils;

public final class Main {

	private Main() { }
	
	public static void main(String[] args) {
		Demo[] demos = new Demo[] {
			new AddRandomItemsDemo(),
			new RemoveItemDemo(),
			new RemoveItemByCriteriaDemo()
		};
		
		printDemoList(demos);
		int demoSeqNum;
		
		while ((demoSeqNum = readDemoSeqNum(demos.length)) != 0) {
			Demo demo = demos[demoSeqNum - 1];
			printSeparator();
			
			try {
				demo.run();
			}
			catch (Exception ex) {
				ex.printStackTrace(System.out);
			}
			
			printSeparator();
			printDemoList(demos);
		}
	}

	private static void printDemoList(Demo[] demos) {
		for (int i =0; i < demos.length; i++) {
			printDemoEntry(i, demos[i]);
		}
	}
	
	private static void printSeparator() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 40; i++) {
			sb.append('-');
		}
		
		System.out.println(sb);
	}
	
	private static void printDemoEntry(int index, Demo demo) {
		System.out.format("%d. %s%n", index + 1, demo.getDescription());
	}
	
	private static int readDemoSeqNum(int max) {
		System.out.format("Select demo [1, %d], [0] to exit: ", max);
		InputParseResult<Integer> parseResult;
		
		while (!(parseResult = InputReadUtils.tryReadInt(0, max + 1)).isSuccess()) {
			System.out.print("Invalid selection, retry: ");
		}
		
		return parseResult.getValue();
	}
}
