package co.com.todo1.store.domain.constants;

public enum TipoMovimientosEnum {

	ENTRADA("ENTRADA"), SALIDA("SALIDA");

	private String estado;

	private TipoMovimientosEnum(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}
}
