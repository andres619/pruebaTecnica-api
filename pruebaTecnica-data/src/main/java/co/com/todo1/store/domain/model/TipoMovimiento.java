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
@Table(name = "tipo_movimiento")
public class TipoMovimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "TIPO_MOVIMIENTOS_GENERATOR", sequenceName = "sq_tipo_movimientos", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPO_MOVIMIENTOS_GENERATOR")
	@Column(name = "id_tipo")
	private BigDecimal IdTipo;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "descripcion")
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_registro")
	private Date fechaRegistro;

	public BigDecimal getIdTipo() {
		return IdTipo;
	}

	public void setIdTipo(BigDecimal idTipo) {
		IdTipo = idTipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
