package co.com.todo1.store.domain.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import co.com.todo1.store.app.carga.dto.ResultadoRegistroDTO;
import co.com.todo1.store.domain.dto.ProductoDTO;
import co.com.todo1.store.domain.factory.ProductoFactory;
import co.com.todo1.store.domain.model.Producto;
import co.com.todo1.store.domain.repository.IProductoRepository;
import co.com.todo1.store.util.FieldValidationUtil;

@Stateless
public class ProductoServiceImpl {

	@Inject
	private IProductoRepository repository;

	public List<Producto> findAllProductos() {
		List<Producto> productoList = repository.findAll();
		return productoList;

	}

	public Producto obtenerProductoPorReferencia(String referencia) {
		Producto producto = repository.findByReferencia(referencia);
		return producto;

	}

	public ResultadoRegistroDTO registrarProducto(ProductoDTO productoDTO) {

		ResultadoRegistroDTO resultado = new ResultadoRegistroDTO();
		Producto productoReferencia = obtenerProductoPorReferencia(productoDTO
				.getReferencia());

		if (productoReferencia != null) {
			resultado.setErrorResponse(true);
			resultado
					.setMensajeError(FieldValidationUtil.ERROR_REFERENCIA_DUPLICADA);
		} else {
			Producto producto = ProductoFactory.getFromDTO(productoDTO);
			repository.save(producto);
		}

		return resultado;
	}

}
