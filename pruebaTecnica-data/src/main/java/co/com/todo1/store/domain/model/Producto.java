package co.com.todo1.store.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PRODUCTO_GENERATOR", sequenceName = "sq_productos", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTO_GENERATOR")
	@Column(name = "id_producto")
	private BigDecimal IdProducto;

	@Column(name = "referencia")
	private String referencia;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "cantidad_disponible")
	private BigDecimal cantidadDisponible;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;

	public BigDecimal getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(BigDecimal idProducto) {
		IdProducto = idProducto;
	}

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

	public BigDecimal getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(BigDecimal cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

}
