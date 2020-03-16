package co.com.todo1.store.domain.factory;

import java.math.BigDecimal;
import java.util.Date;

import co.com.todo1.store.domain.dto.ProductoDTO;
import co.com.todo1.store.domain.model.Producto;

public interface ProductoFactory {

	public static Producto getFromDTO(ProductoDTO source) {
		Producto entity = new Producto();
		entity.setReferencia(source.getReferencia());
		entity.setDescripcion(source.getDescripcion());
		entity.setCantidadDisponible(BigDecimal.ZERO);
		entity.setFechaIngreso(new Date());

		return entity;
	}
}
