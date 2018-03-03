package main.java.base;

public class Response<T> {
	private String message;
	private T data;
	
	public Response(String error) {
		this.message = error;
	}
	
	public Response(T data, String msg) {
		this.message = msg;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
