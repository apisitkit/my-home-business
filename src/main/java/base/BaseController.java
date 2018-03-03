package main.java.base;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
	private static Logger log = Logger.getLogger(BaseController.class.getName());

	@ExceptionHandler({Exception.class})
	public ResponseEntity<Response> handleException(Exception e) {
		log.error(e);
		return new ResponseEntity<Response>(new ResponseError(e.getMessage()), 
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public <T> ResponseEntity<Response> sendResponseSuccess(T data) {
		return new ResponseEntity<Response>(new ResponseSuccess(data), 
			HttpStatus.OK);
	}
	
	public <T> ResponseEntity<Response> sendResponseSuccess(T data, String msg) {
		return new ResponseEntity<Response>(new ResponseSuccess(data, msg), 
			HttpStatus.OK);
	}
	
	public <T> ResponseEntity<Response> sendResponseSuccess() {
		return new ResponseEntity<Response>(HttpStatus.OK);
	}
	
	public ResponseEntity<Response> sendResponseError() {
		return new ResponseEntity<Response>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public ResponseEntity<Response> sendResponseNotFound() {
		return new ResponseEntity<Response>(HttpStatus.NOT_FOUND);
	}
}
