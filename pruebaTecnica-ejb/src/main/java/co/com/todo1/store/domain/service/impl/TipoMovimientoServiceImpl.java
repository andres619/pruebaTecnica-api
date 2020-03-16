package co.com.todo1.store.domain.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import co.com.todo1.store.domain.model.TipoMovimiento;
import co.com.todo1.store.domain.repository.ITipoMovimientoRepository;

@Stateless
public class TipoMovimientoServiceImpl {

	@Inject
	private ITipoMovimientoRepository repository;

	public List<TipoMovimiento> findAllTipoMovimientos() {
		List<TipoMovimiento> tiposMovimientosList = repository.findAll();
		return tiposMovimientosList;

	}

	public TipoMovimiento obtenerPorTipo(String tipo) {
		TipoMovimiento tipoMovimiento = repository.findByTipo(tipo);
		return tipoMovimiento;

	}

}
