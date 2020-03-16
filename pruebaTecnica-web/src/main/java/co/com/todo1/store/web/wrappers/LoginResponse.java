package co.com.todo1.store.web.wrappers;

import java.io.Serializable;

public class LoginResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "LoginResponse [token=" + token + "]";
	}

}
