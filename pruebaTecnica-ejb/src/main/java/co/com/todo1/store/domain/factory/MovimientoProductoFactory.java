package co.com.todo1.store.domain.factory;

import java.math.BigDecimal;
import java.util.Date;

import co.com.todo1.store.domain.constants.TipoMovimientosEnum;
import co.com.todo1.store.domain.dto.MovimientoProductoDTO;
import co.com.todo1.store.domain.model.MovimientoProducto;
import co.com.todo1.store.domain.model.Producto;
import co.com.todo1.store.domain.model.TipoMovimiento;

public interface MovimientoProductoFactory {

	public static MovimientoProducto getFromDTO(
			MovimientoProductoDTO movimientoDTO, Producto producto,
			TipoMovimiento tipoMovimiento) {
		MovimientoProducto entity = new MovimientoProducto();
		int cantidadDisponible = producto.getCantidadDisponible().intValue();
		int cantidadMovimiento = movimientoDTO.getCantidad();
		int cantidadModificar = tipoMovimiento.getTipo().equals(
				TipoMovimientosEnum.ENTRADA.getEstado()) ? cantidadDisponible
				+ cantidadMovimiento : cantidadDisponible - cantidadMovimiento;
		producto.setCantidadDisponible(new BigDecimal(cantidadModificar));
		entity.setProducto(producto);
		entity.setTipoMovimiento(tipoMovimiento);
		entity.setFecha(new Date());
		entity.setCantidad(new BigDecimal(movimientoDTO.getCantidad()));
		entity.setDescripcion(movimientoDTO.getDescripcionMovimiento());

		return entity;
	}

}
