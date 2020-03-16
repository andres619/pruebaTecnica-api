package co.com.todo1.store.app.carga.dto;

public class ResultadoRegistroDTO {

	private boolean isErrorResponse;
	private String mensajeError;

	public boolean isErrorResponse() {
		return isErrorResponse;
	}

	public void setErrorResponse(boolean isErrorResponse) {
		this.isErrorResponse = isErrorResponse;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
}
