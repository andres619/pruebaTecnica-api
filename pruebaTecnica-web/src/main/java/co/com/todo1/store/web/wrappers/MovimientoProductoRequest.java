package co.com.todo1.store.web.wrappers;

import java.io.Serializable;

import co.com.todo1.store.domain.dto.MovimientoProductoDTO;

public class MovimientoProductoRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private MovimientoProductoDTO movimientoProducto;

	public MovimientoProductoDTO getMovimientoProducto() {
		return movimientoProducto;
	}

	public void setMovimientoProducto(MovimientoProductoDTO movimientoProducto) {
		this.movimientoProducto = movimientoProducto;
	}

	@Override
	public String toString() {
		return "MovimientoProductoRequest [movimientoProducto="
				+ movimientoProducto + "]";
	}

}
