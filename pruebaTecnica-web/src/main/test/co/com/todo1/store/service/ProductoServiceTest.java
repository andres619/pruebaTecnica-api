package co.com.todo1.store.service;

import static org.mockito.Mockito.verify;

import org.junit.Assert;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.todo1.store.app.carga.dto.ResultadoRegistroDTO;
import co.com.todo1.store.domain.dto.ProductoDTO;
import co.com.todo1.store.domain.model.Producto;
import co.com.todo1.store.domain.repository.IProductoRepository;
import co.com.todo1.store.domain.service.impl.ProductoServiceImpl;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductoServiceTest {

	@Mock
	private IProductoRepository repository;

	@InjectMocks
	private ProductoServiceImpl service;

	@Test
	public void verificarProductos() {

		Producto prod = new Producto();
		prod.setIdProducto(new BigDecimal(1));
		prod.setReferencia("AAA01");
		prod.setDescripcion("CAMISA");
		prod.setCantidadDisponible(new BigDecimal(5));
		prod.setFechaIngreso(new Date());

		List<Producto> all = new LinkedList<Producto>();
		all.add(prod);

		when(repository.findAll()).thenReturn(all);

		List<Producto> list = service.findAllProductos();
		Assert.assertTrue(!list.isEmpty());

		verify(repository).findAll();
	}

	@Test
	public void verificarProductoReferencia() {
		String referencia = "AAA01";
		when(repository.findByReferencia(referencia))
				.thenReturn(new Producto());
		Producto producto = service.obtenerProductoPorReferencia(referencia);
		Assert.assertNotNull(producto);
	}

	@Test
	public void verificarIngresoProducto() {

		ProductoDTO dto = new ProductoDTO();
		dto.setReferencia("AAA02");
		dto.setDescripcion("CHAQUETA");

		Producto prod = new Producto();
		prod.setReferencia("AAA02");
		prod.setDescripcion("CHAQUETA");
		prod.setCantidadDisponible(new BigDecimal(0));
		prod.setFechaIngreso(new Date());

		when(repository.save(prod)).thenReturn(prod);

		ResultadoRegistroDTO resultado = service.registrarProducto(dto);
		Assert.assertEquals(resultado.isErrorResponse(), false);

		Producto prodRes = repository.save(prod);

		Assert.assertSame(prod, prodRes);
	}

}
