package co.com.todo1.store.web.wrappers;

import java.io.Serializable;

public class MainResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;
	private int code;

	public MainResponse(String message, int code) {
		super();
		this.message = message;
		this.code = code;
	}

	public MainResponse() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
