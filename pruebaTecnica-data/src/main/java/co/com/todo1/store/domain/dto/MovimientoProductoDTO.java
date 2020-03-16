package co.com.todo1.store.domain.dto;

public class MovimientoProductoDTO {

	private String referenciaProducto;
	private int cantidad;
	private String descripcionMovimiento;
	private String tipoMovimiento;

	public String getReferenciaProducto() {
		return referenciaProducto;
	}

	public void setReferenciaProducto(String referenciaProducto) {
		this.referenciaProducto = referenciaProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcionMovimiento() {
		return descripcionMovimiento;
	}

	public void setDescripcionMovimiento(String descripcionMovimiento) {
		this.descripcionMovimiento = descripcionMovimiento;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	@Override
	public String toString() {
		return "MovimientoProductoDTO [referenciaProducto="
				+ referenciaProducto + ", cantidad=" + cantidad
				+ ", descripcionMovimiento=" + descripcionMovimiento
				+ ", tipoMovimiento=" + tipoMovimiento + "]";
	}

}
