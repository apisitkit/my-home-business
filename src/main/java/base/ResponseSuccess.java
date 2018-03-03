package main.java.base;

public class ResponseSuccess extends Response{
	public ResponseSuccess() {
		super("success");
	}
	public ResponseSuccess(String msg) {
		super(msg);
	}
	@SuppressWarnings("unchecked")
	public <T> ResponseSuccess(T data) {
		super(data, "success");
	}
	
	@SuppressWarnings("unchecked")
	public <T> ResponseSuccess(T data, String msg) {
		super(data, msg);
	}
	
}
