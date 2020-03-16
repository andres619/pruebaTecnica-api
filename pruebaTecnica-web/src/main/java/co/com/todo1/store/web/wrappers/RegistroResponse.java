package co.com.todo1.store.web.wrappers;

import co.com.todo1.store.app.carga.dto.ResultadoRegistroDTO;

public class RegistroResponse {

	private ResultadoRegistroDTO resultadoRegistro;
	private MainResponse response;

	public ResultadoRegistroDTO getResultadoRegistro() {
		return resultadoRegistro;
	}

	public void setResultadoRegistro(ResultadoRegistroDTO resultadoRegistro) {
		this.resultadoRegistro = resultadoRegistro;
	}

	public MainResponse getResponse() {
		return response;
	}

	public void setResponse(MainResponse response) {
		this.response = response;
	}

}
