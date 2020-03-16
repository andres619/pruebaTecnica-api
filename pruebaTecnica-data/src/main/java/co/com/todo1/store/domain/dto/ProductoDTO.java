package co.com.todo1.store.domain.dto;

public class ProductoDTO {

	private String referencia;
	private String descripcion;

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "ProductoDTO [referencia=" + referencia + ", descripcion="
				+ descripcion + "]";
	}

}
