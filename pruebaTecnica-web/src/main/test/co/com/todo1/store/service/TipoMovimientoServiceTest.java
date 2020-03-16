package co.com.todo1.store.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.todo1.store.domain.model.TipoMovimiento;
import co.com.todo1.store.domain.repository.ITipoMovimientoRepository;
import co.com.todo1.store.domain.service.impl.TipoMovimientoServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TipoMovimientoServiceTest {

	@Mock
	private ITipoMovimientoRepository repository;

	@InjectMocks
	private TipoMovimientoServiceImpl service;

	@Test
	public void verificarTodosTiposMovimientos() {

		TipoMovimiento tipo = new TipoMovimiento();
		tipo.setIdTipo(new BigDecimal(1));
		tipo.setTipo("ENTRADA");
		tipo.setDescripcion("Entrada a inventario");
		tipo.setFechaRegistro(new Date());

		List<TipoMovimiento> all = new LinkedList<TipoMovimiento>();
		all.add(tipo);

		when(repository.findAll()).thenReturn(all);

		List<TipoMovimiento> list = service.findAllTipoMovimientos();
		Assert.assertTrue(!list.isEmpty());

		verify(repository).findAll();
	}

	@Test
	public void verificarTipoReferencia() {
		String tipo = "ENTRADA";
		when(repository.findByTipo(tipo)).thenReturn(new TipoMovimiento());
		TipoMovimiento tipoMov = service.obtenerPorTipo(tipo);
		Assert.assertNotNull(tipoMov);
	}
}
