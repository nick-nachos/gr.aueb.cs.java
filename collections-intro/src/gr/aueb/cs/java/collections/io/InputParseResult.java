package gr.aueb.cs.java.collections.io;

public final class InputParseResult<T> {

	private T value;
	
	public InputParseResult() { 
		this(null);
	}
	
	public InputParseResult(T value) {
		this.value = value;
	}
	
	public boolean isSuccess() {
		return value != null;
	}
	
	public T getValue() {
		return this.value;
	}
}
