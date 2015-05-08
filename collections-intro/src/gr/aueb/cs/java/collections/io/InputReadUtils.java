package gr.aueb.cs.java.collections.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class InputReadUtils {

	private InputReadUtils() { }

	private static final BufferedReader in;
	
	static {
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static InputParseResult<Integer> tryReadInt(int lowInclusive, int highExclusive) {
		Integer value = null;
		
		try {
			String input = in.readLine();
			int val = Integer.parseInt(input);
			
			if (val >= lowInclusive && val < highExclusive) {
				value = val;
			}
		}
		catch (IOException ex) { }
		catch (NumberFormatException ex) { }
		
		return new InputParseResult<>(value);
	}
}
