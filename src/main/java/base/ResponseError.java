package main.java.base;

public class ResponseError extends Response{
	public ResponseError() {
		super("error");
	}
	public ResponseError(String msg) {
		super(msg);
	}
	
	@SuppressWarnings("unchecked")
	public <T> ResponseError(T data) {
		super(data, "error");
	}
	
	@SuppressWarnings("unchecked")
	public <T> ResponseError(T data, String msg) {
		super(data, msg);
	}
	
	
}
