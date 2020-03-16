package co.com.todo1.store.domain.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;

import co.com.todo1.store.app.carga.dto.ResultadoRegistroDTO;
import co.com.todo1.store.app.dto.MovimientoReferenciaProductoDTO;
import co.com.todo1.store.domain.constants.TipoMovimientosEnum;
import co.com.todo1.store.domain.dto.MovimientoProductoDTO;
import co.com.todo1.store.domain.exceptions.PruebaTecnicaException;
import co.com.todo1.store.domain.factory.MovimientoProductoFactory;
import co.com.todo1.store.domain.model.MovimientoProducto;
import co.com.todo1.store.domain.model.Producto;
import co.com.todo1.store.domain.model.TipoMovimiento;
import co.com.todo1.store.domain.repository.IMovimientoProductoRepository;
import co.com.todo1.store.domain.repository.IProductoRepository;
import co.com.todo1.store.domain.repository.ITipoMovimientoRepository;
import co.com.todo1.store.util.FieldValidationUtil;

@Stateless
public class MovimientoProductoServiceImpl {

	@Inject
	private IMovimientoProductoRepository repository;

	@Inject
	private IProductoRepository productoRepository;

	@Inject
	private ITipoMovimientoRepository tipoMovimientoRepository;

	public List<MovimientoProducto> findAllMovimientos() {

		List<MovimientoProducto> movimientosList = repository.findAll();

		return movimientosList;

	}

	public List<MovimientoReferenciaProductoDTO> obtenerMovimientosReferenciaProducto(
			String referencia) {
		List<MovimientoReferenciaProductoDTO> movimientosList = null;
		List<MovimientoProducto> movimientos = repository
				.findByProducto_Referencia(referencia);
		movimientosList = movimientos
				.stream()
				.map(i -> new MovimientoReferenciaProductoDTO(i.getProducto()
						.getDescripcion(), i.getProducto()
						.getCantidadDisponible(), i.getFecha(), i
						.getDescripcion(), i.getTipoMovimiento().getTipo(), i
						.getCantidad())).collect(Collectors.toList());
		return movimientosList;

	}

	public ResultadoRegistroDTO registrarMovimientoProducto(
			MovimientoProductoDTO movimiento) throws PruebaTecnicaException {

		ResultadoRegistroDTO resultado = new ResultadoRegistroDTO();

		Producto producto = productoRepository.findByReferencia(movimiento
				.getReferenciaProducto());

		validarStockSalida(movimiento, producto, resultado);
		boolean errorMontosStock = resultado.isErrorResponse();
		if (!errorMontosStock) {

			TipoMovimiento tipoMovimiento = tipoMovimientoRepository
					.findByTipo(movimiento.getTipoMovimiento());

			MovimientoProducto movimientoProducto = MovimientoProductoFactory
					.getFromDTO(movimiento, producto, tipoMovimiento);

			repository.save(movimientoProducto);
		}

		return resultado;
	}

	public void validarStockSalida(MovimientoProductoDTO movimiento,
			Producto producto, ResultadoRegistroDTO resultado) {

		if (movimiento.getTipoMovimiento().equals(
				TipoMovimientosEnum.SALIDA.getEstado())) {
			if (producto.getCantidadDisponible() == BigDecimal.ZERO) {
				resultado.setErrorResponse(true);
				resultado
						.setMensajeError(FieldValidationUtil.ERROR_PRODUCTO_SIN_STOCK);
			} else if (producto.getCantidadDisponible().intValue()
					- movimiento.getCantidad() < 0) {
				resultado.setErrorResponse(true);
				resultado
						.setMensajeError(FieldValidationUtil.ERROR_STOCK_SIN_CANTIDAD_SUFICIENTES);
			}
		}

	}

}
