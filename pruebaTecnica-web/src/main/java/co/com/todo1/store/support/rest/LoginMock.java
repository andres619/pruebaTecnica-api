package co.com.todo1.store.support.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.todo1.store.web.wrappers.LoginRequest;
import co.com.todo1.store.web.wrappers.LoginResponse;

/**
 * 
 * Mock para el feature de login
 * 
 *
 */

@Path("/SecurityServicesWeb/rest/security")
public class LoginMock {

	@POST
	@Path("/authenticate")
	@Produces(MediaType.APPLICATION_JSON)
	public LoginResponse authenticate(LoginRequest request) {
		LoginResponse response = new LoginResponse();
		response.setToken("sadgsgsrwegrsgshgeafgsdxgesrhdjtdgbrdsjsa45tye5drhgdxh");

		return response;
	}

}
