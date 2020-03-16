package co.com.todo1.store.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "movimiento_producto")
public class MovimientoProducto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "MOVIMIENTOS_GENERATOR", sequenceName = "sq_movimiento_productos", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MOVIMIENTOS_GENERATOR")
	@Column(name = "id_movimiento")
	private BigDecimal IdMovimiento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "referencia_producto")
	private Producto producto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_movimiento")
	private TipoMovimiento tipoMovimiento;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha")
	private Date fecha;

	@Column(name = "cantidad")
	private BigDecimal cantidad;

	@Column(name = "descripcion")
	private String descripcion;

	public BigDecimal getIdMovimiento() {
		return IdMovimiento;
	}

	public void setIdMovimiento(BigDecimal idMovimiento) {
		IdMovimiento = idMovimiento;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
