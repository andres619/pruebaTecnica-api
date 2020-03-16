package co.com.todo1.store.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.todo1.store.app.carga.dto.ResultadoRegistroDTO;
import co.com.todo1.store.app.dto.MovimientoReferenciaProductoDTO;
import co.com.todo1.store.domain.dto.MovimientoProductoDTO;
import co.com.todo1.store.domain.exceptions.PruebaTecnicaException;
import co.com.todo1.store.domain.model.MovimientoProducto;
import co.com.todo1.store.domain.model.Producto;
import co.com.todo1.store.domain.model.TipoMovimiento;
import co.com.todo1.store.domain.repository.IMovimientoProductoRepository;
import co.com.todo1.store.domain.repository.IProductoRepository;
import co.com.todo1.store.domain.repository.ITipoMovimientoRepository;
import co.com.todo1.store.domain.service.impl.MovimientoProductoServiceImpl;
import co.com.todo1.store.util.FieldValidationUtil;

@RunWith(MockitoJUnitRunner.class)
public class MovimientoProductoServiceTest {

	@Mock
	private IMovimientoProductoRepository repository;

	@Mock
	private IProductoRepository repositoryProd;

	@Mock
	private ITipoMovimientoRepository repositoryTipo;

	@InjectMocks
	private MovimientoProductoServiceImpl service;

	Producto prod;
	TipoMovimiento tipo;
	MovimientoProducto mov;

	@Before
	public void init() {

		prod = new Producto();
		prod.setIdProducto(new BigDecimal(1));
		prod.setReferencia("AAA01");
		prod.setDescripcion("CAMISA");
		prod.setCantidadDisponible(new BigDecimal(5));
		prod.setFechaIngreso(new Date());

		tipo = new TipoMovimiento();
		tipo.setIdTipo(new BigDecimal(1));
		tipo.setTipo("ENTRADA");
		tipo.setDescripcion("Entrada a inventario");
		tipo.setFechaRegistro(new Date());

		mov = new MovimientoProducto();
		mov.setIdMovimiento(new BigDecimal(1));
		mov.setProducto(prod);
		mov.setTipoMovimiento(tipo);
		mov.setDescripcion("Compra articulo");
		mov.setCantidad(new BigDecimal(5));
		mov.setFecha(new Date());

	}

	@Test
	public void verificarProductos() {

		List<MovimientoProducto> all = new LinkedList<MovimientoProducto>();
		all.add(mov);

		when(repository.findAll()).thenReturn(all);

		List<MovimientoProducto> list = service.findAllMovimientos();
		Assert.assertTrue(!list.isEmpty());

		verify(repository).findAll();
	}

	@Test
	public void verificarProductoReferencia() {
		String referencia = "AAA01";
		when(repository.findByProducto_Referencia(referencia)).thenReturn(
				new LinkedList<MovimientoProducto>());
		List<MovimientoReferenciaProductoDTO> resultado = service
				.obtenerMovimientosReferenciaProducto(referencia);
		Assert.assertNotNull(resultado);
	}

	@Test
	public void verificarIngresoProducto() throws PruebaTecnicaException {

		MovimientoProductoDTO dto = new MovimientoProductoDTO();
		dto.setReferenciaProducto("AAA01");
		dto.setCantidad(5);
		dto.setDescripcionMovimiento("Compra");
		dto.setTipoMovimiento("ENTRADA");

		when(repository.save(mov)).thenReturn(mov);

		String referencia = "AAA01";
		when(repositoryProd.findByReferencia(referencia)).thenReturn(prod);

		String tipoMovi = "ENTRADA";
		when(repositoryTipo.findByTipo(tipoMovi)).thenReturn(tipo);

		ResultadoRegistroDTO resultado = service
				.registrarMovimientoProducto(dto);
		Assert.assertEquals(resultado.isErrorResponse(), false);

	}

	@Test
	public void verificarStockSinCantidadesSuficientes()
			throws PruebaTecnicaException {

		tipo.setTipo("SALIDA");
		tipo.setDescripcion("Salida inventario");

		MovimientoProductoDTO dto = new MovimientoProductoDTO();
		dto.setReferenciaProducto("AAA01");
		dto.setCantidad(10);
		dto.setDescripcionMovimiento("venta");
		dto.setTipoMovimiento("SALIDA");

		when(repository.save(mov)).thenReturn(mov);

		String referencia = "AAA01";
		when(repositoryProd.findByReferencia(referencia)).thenReturn(prod);

		String tipoMovi = "SALIDA";
		when(repositoryTipo.findByTipo(tipoMovi)).thenReturn(tipo);

		ResultadoRegistroDTO resultado = service
				.registrarMovimientoProducto(dto);
		System.out.println(resultado.getMensajeError());
		Assert.assertEquals(resultado.isErrorResponse(), true);
		Assert.assertEquals(resultado.getMensajeError(),
				FieldValidationUtil.ERROR_STOCK_SIN_CANTIDAD_SUFICIENTES);

	}

	@Test
	public void verificarSinStock() throws PruebaTecnicaException {

		prod.setCantidadDisponible(BigDecimal.ZERO);

		MovimientoProductoDTO dto = new MovimientoProductoDTO();
		dto.setReferenciaProducto("AAA01");
		dto.setCantidad(1);
		dto.setDescripcionMovimiento("venta");
		dto.setTipoMovimiento("SALIDA");

		when(repository.save(mov)).thenReturn(mov);

		String referencia = "AAA01";
		when(repositoryProd.findByReferencia(referencia)).thenReturn(prod);

		String tipoMovi = "ENTRADA";
		when(repositoryTipo.findByTipo(tipoMovi)).thenReturn(tipo);

		ResultadoRegistroDTO resultado = service
				.registrarMovimientoProducto(dto);
		System.out.println(resultado.getMensajeError());
		Assert.assertEquals(resultado.isErrorResponse(), true);
		Assert.assertEquals(resultado.getMensajeError(),
				FieldValidationUtil.ERROR_PRODUCTO_SIN_STOCK);

	}

}
