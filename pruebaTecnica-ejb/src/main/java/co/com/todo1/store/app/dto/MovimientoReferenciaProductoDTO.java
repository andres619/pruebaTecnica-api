package co.com.todo1.store.app.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MovimientoReferenciaProductoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descripcionProducto;
	private BigDecimal cantidadDisponible;
	private Date fechaMovimiento;
	private String detalleMovimiento;
	private String tipoMovimiento;
	private BigDecimal cantidadMovimiento;

	public MovimientoReferenciaProductoDTO(String descripcionProducto,
			BigDecimal cantidadDisponible, Date fechaMovimiento,
			String detalleMovimiento, String tipoMovimiento,
			BigDecimal cantidadMovimiento) {
		this.descripcionProducto = descripcionProducto;
		this.cantidadDisponible = cantidadDisponible;
		this.fechaMovimiento = fechaMovimiento;
		this.detalleMovimiento = detalleMovimiento;
		this.tipoMovimiento = tipoMovimiento;
		this.cantidadMovimiento = cantidadMovimiento;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public BigDecimal getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(BigDecimal cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	public String getDetalleMovimiento() {
		return detalleMovimiento;
	}

	public void setDetalleMovimiento(String detalleMovimiento) {
		this.detalleMovimiento = detalleMovimiento;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public BigDecimal getCantidadMovimiento() {
		return cantidadMovimiento;
	}

	public void setCantidadMovimiento(BigDecimal cantidadMovimiento) {
		this.cantidadMovimiento = cantidadMovimiento;
	}

}
